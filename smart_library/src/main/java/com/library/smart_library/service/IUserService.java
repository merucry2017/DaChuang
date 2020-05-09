package com.library.smart_library.service;

import com.library.smart_library.entity.User;
import com.library.smart_library.service.ex.*;

public interface IUserService {

    /**
     * 用户注册
     * @param user
     * @throws UsernameDuplicateException 用户名被占用
     * @throws InsertException 插入数据失败
     */
    void reg(User user) throws UsernameDuplicateException, InsertException;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     * @throws UserNotFoundException 用户数据不存在
     * @throws PasswordNotMatchException 密码错误
     */
    User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException;

    /**
     * 更改密码
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     * @throws UserNotFoundException  用户数据不存在
     * @throws PasswordNotMatchException 密码错误
     * @throws UpdateException 更新失败
     */
    void changePassword(Integer uid,String username,String oldPassword,String newPassword)
        throws UserNotFoundException,PasswordNotMatchException, UpdateException;

    /**
     * 更改用户信息
     * @param user
     * @throws UserNotFoundException
     * @throws UpdateException
     */
    void changeInfo(User user) throws UserNotFoundException,UpdateException;

    /**
     * 通过uid找用户
     * @param uid
     * @return
     */
    User getByUid(Integer uid);
}
