package com.library.smart_library.impl;

import java.util.Date;
import java.util.UUID;

import com.library.smart_library.entity.User;
import com.library.smart_library.mapper.UserMapper;
import com.library.smart_library.service.IUserService;
import com.library.smart_library.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) throws UsernameDuplicateException, InsertException {
        //根据尝试注册的用户名查询用户数据
        String username = user.getUsername();
        User result = findByUsername(username);
        if(result==null){
            //设置is_delete
            user.setIs_delete("0");

            //设置创建时间跟修改时间
            Date now = new Date();
            user.setCreated_time(now);
            user.setModified_time(now);

            //TODO 密码加密
            //生成随机盐
            String salt = UUID.randomUUID().toString().toUpperCase();
            //执行密码加密，得到加密后的密码
            String md5Password = getMd5Password(user.getPassword(), salt);
            //将盐和加密后的密码封装到user中
            user.setPassword(md5Password);
            user.setSalt(salt);
            //执行注册
            insert(user);
        }else {
            throw new UsernameDuplicateException(
                    "注册失败！您尝试注册的用户名(" + username + ")已经被占用！"
            );
        }
    }

    /**
     * 插入用户数据
     * @param user
     */
    private void insert(User user) {
        Integer rows = userMapper.insert(user);
        if(rows!=1){
            throw new InsertException(String.valueOf(null));
        }
    }

    /**
     * 获取执行MD5加密后的密码
     * @param password
     * @param salt
     * @return
     */
    private String getMd5Password(String password, String salt) {
        //加密规则，使用“盐+密码+盐”作为原始数据，执行5次加密
        String result = salt + password + salt;
        for(int i=0;i < 5;i++){
            result = DigestUtils.md5DigestAsHex(result.getBytes()).toUpperCase();
        }
        return result;
    }

    /**
     * 根据用户名查询用户数据
     * @param username
     * @return
     */
    private User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException
     * @throws PasswordNotMatchException
     */
    @Override
    public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
        //根据参数username查询用户
        User result = findByUsername(username);
        //判断结果是否为空
        if(result==null){
            throw new UserNotFoundException(
                "登录失败！尝试登录的用户不存在！"
            );
        }

        //判断is_delete是否标记为删除
        if(result.getIs_delete().equals("1")){
            //抛出UserNotFoundException
            throw new UserNotFoundException(
                "登录失败！尝试登录的用户不存在！"
            );
        }
//        System.out.println(result.getSalt());
        // 从查询结果中获取盐值
        String salt = result.getSalt();
        // 对参数password执行加密
        String md5Password = getMd5Password(password, salt);
        // 判断查询结果中的密码与刚加密结果是否一致
        if (result.getPassword().equals(md5Password)) {
            // 是：准备返回结果，先去除部分不需要对外使用的数据
            result.setPassword(null);
            result.setSalt(null);
            result.setIs_delete(null);

            // 返回查询结果
            return result;
        } else {
            // 否：抛出PasswordNotMatchException
            throw new PasswordNotMatchException(
                    "登录失败！错误密码！");
        }
    }

    /**
     * 改变用户密码
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     * @throws UserNotFoundException
     * @throws PasswordNotMatchException
     * @throws UpdateException
     */
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) throws UserNotFoundException, PasswordNotMatchException, UpdateException {
        // 根据uid查询用户数据
        User result = findByUid(uid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                    "修改密码失败！尝试访问的用户不存在！");
        }

        // 判断查询结果中isDelete是否为1
        if (result.getIs_delete().equals("1")) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                    "修改密码失败！尝试访问的用户不存在！");
        }

        // 从查询结果中获取盐值
        String salt = result.getSalt();
        // 将oldPassword结合盐值加密，得到oldMd5Password
        String oldMd5Password = getMd5Password(oldPassword, salt);
        // 判断查询结果中的密码（用户当前的真实密码）与oldMd5Password是否不匹配
        if (!result.getPassword().equals(oldMd5Password)) {
            // 是：抛出PasswordNotMatchException
            throw new PasswordNotMatchException(
                    "修改密码失败！原密码错误！");
        }

        // 将newPassword结合盐值加密，得到newMd5Password
        String newMd5Password = getMd5Password(newPassword, salt);
        // 创建时间对象now
        Date now = new Date();
        // 执行修改密码：updatePassword(uid, newMd5Password, username, now)
        updatePassword(uid, newMd5Password, username, now);
    }

    /**
     * 更新用户密码
     * @param uid
     * @param password
     * @param username
     * @param modifiedTime
     */
    private void updatePassword(Integer uid, String password, String username, Date modifiedTime) {
        System.out.println("can collect  "+password);
        Integer rows = userMapper.updatePassword(uid,password,modifiedTime);
        if(rows!=1){
            throw new UpdateException(
                "修改用户数据时出现未知错误！"
            );
        }
    }

    /**
     * 根据用户id查询用户数据
     * @param uid 用户id
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    private User findByUid(Integer uid) {
        return userMapper.findByUid(uid);
    }

    /**
     * 更改用户信息
     * @param user
     * @throws UserNotFoundException
     * @throws UpdateException
     */
    @Override
    public void changeInfo(User user) throws UserNotFoundException, UpdateException {
        // 根据uid查询用户数据
        User result = findByUid(user.getUid());
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                    "修改密码失败！尝试访问的用户不存在！");
        }

        // 判断查询结果中isDelete是否为1
        if (result.getIs_delete().equals("1")) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                    "修改密码失败！尝试访问的用户不存在！");
        }

        user.setModified_time(new Date());
        // 执行更新
        updateInfo(user);
    }

    /**
     * 更新个人资料
     * @param user
     */
    private void updateInfo(User user) {
        Integer rows = userMapper.updateInfo(user);
        if(rows!=1){
            throw new UpdateException(
                    "修改用户数据时出现未知错误！"
            );
        }
    }

    /**
     * 根据用户id查询用户数据
     * @param uid 用户id
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    @Override
    public User getByUid(Integer uid) {
        // 根据uid查询用户数据
        User result = findByUid(uid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                    "获取用户信息失败！尝试访问的用户不存在！");
        }

        // 判断查询结果中isDelete是否为1
        if (result.getIs_delete().equals("1")) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                    "获取用户信息失败！尝试访问的用户不存在！");
        }

        // 在返回之前隐藏不向外提供的数据
        result.setPassword(null);
        result.setSalt(null);
        result.setIs_delete(null);

        // 执行返回
        return result;
    }
}
