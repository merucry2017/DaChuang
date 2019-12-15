package cn.tedu.store.impl;



import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.store.entity.Comment;
import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.CommentMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ICommentService;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameDuplicateException;

@Service
public class CommentServiceImpl  implements ICommentService{

	@Autowired private CommentMapper commentMapper;

	@Override
	public void comment(Comment comm) 
	    throws UsernameDuplicateException, 
	        InsertException {
		
	    String username = comm.getUsername();
		comm.setIsDelete(0);		
		//设置时间
		 Date now = new Date();
		 comm.setCreatedUser(username);
		 comm.setCreatedTime(now);
		 comm.setModifiedUser(username);
		 comm.setModifiedTime(now);
	    // 执行插入
	    insert(comm);
	   
	}
   
	/**
     * 插入用户数据
     * @param user 用户数据
     */
    private void insert(Comment comm) {
        Integer rows = commentMapper.insert(comm);
        if (rows != 1) {
            throw new InsertException(String.valueOf(null));
        }
    }
    
 
    /*
    @Override
    public User login(String username, String password)  {
        // 根据参数username查询用户：User findByUsername(String username)
        User result = findByUsername(username);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                "登录失败！尝试登录的用户不存在！");
        }

        // 判断is_delete是否标记为已删除：isDelete属性值是否为1
        if (result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                "登录失败！尝试登录的用户不存在！");
        }
        System.out.println(result.getSalt());
        // 从查询结果中获取盐值
        String salt = result.getSalt();
        // 对参数password执行加密
        String md5Password = getMd5Password(password, salt);
        // 判断查询结果中的密码与刚加密结果是否一致
        if (result.getPassword().equals(md5Password)) {
            // 是：准备返回结果，先去除部分不需要对外使用的数据
            result.setPassword(null);
            result.setSalt(null);
            result.setIsDelete(null);
           
            // 返回查询结果
            return result;
        } else {
        	System.out.println("hello");
            // 否：抛出PasswordNotMatchException
            throw new PasswordNotMatchException(
                "登录失败！错误密码！");
        }
    }*/
    
    /**
     * 更新用户密码
     * @param uid 用户的id
     * @param password 新密码
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @throws UpdateException 
     */
    /*
    private void updatePassword(
            Integer uid, String password, 
            String modifiedUser, Date modifiedTime) throws UpdateException {
        Integer rows = userMapper.updatePassword(uid, password, modifiedUser, modifiedTime);
        if (rows != 1) {
            throw new UpdateException(
                "修改用户数据时出现未知错误！");
        }
    }
*/
    /**
     * 根据用户id查询用户数据
     * @param uid 用户id
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    private Comment findByUid(Integer uid) {
        return commentMapper.findByUid(uid);
    }
    
    private List<Comment> findByBid(Integer bid) {
        return commentMapper.findByBid(bid);
    }
    
    /*
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword)
            throws UserNotFoundException, PasswordNotMatchException, UpdateException {
        // 根据uid查询用户数据
        User result = findByUid(uid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                "修改密码失败！尝试访问的用户不存在！");
        }

        // 判断查询结果中isDelete是否为1
        if (result.getIsDelete().equals(1)) {
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
    *//*
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
        if (result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException
            throw new UserNotFoundException(
                "修改密码失败！尝试访问的用户不存在！");
        }

        // 向user中封装modifiedUser和modifiedTime
        user.setModifiedUser(result.getUsername());
        user.setModifiedTime(new Date());
        // 执行更新
        updateInfo(user);
    }
	*/
    /**
	 * 更新个人资料
	 * @param user 个人资料数据
     * @throws UpdateException 
	 */
    /*
	private void updateInfo(User user) throws UpdateException {
		Integer rows = userMapper.updateInfo(user);
		if (rows != 1) {
			throw new UpdateException(
				"修改用户数据时出现未知错误！");
		}
	}
	   */
	@Override
	public Comment getByUid(Integer uid) {
	    // 根据uid查询用户数据
	    Comment result = findByUid(uid);
	    // 判断查询结果是否为null
	    if (result == null) {
	        // 是：抛出UserNotFoundException
	        throw new UserNotFoundException(
	            "获取用户信息失败！尝试访问的用户不存在！");
	    }

	    // 判断查询结果中isDelete是否为1
	    if (result.getIsDelete().equals(1)) {
	        // 是：抛出UserNotFoundException
	        throw new UserNotFoundException(
	            "获取用户信息失败！尝试访问的用户不存在！");
	    }

	    // 在返回之前隐藏不向外提供的数据
	    result.setComm(null);
	    result.setIsDelete(null);

	    // 执行返回
	    return result;
	}
	
	@Override
	public List<Comment> getByBid(Integer bid) {
	    // 根据uid查询用户数据
	    
	    // 执行返回
	    return findByBid(bid);
	}
	
	/**
	 * 更新用户头像
	 * @param uid 用户的id
	 * @param avatar 头像的路径
	 * @param modifiedUser 修改执行人
	 * @param modifiedTime 修改时间
	 * @throws UpdateException 
	 */
	/*
	private void updateAvatar(
	        Integer uid, String avatar, 
	        String modifiedUser, Date modifiedTime) throws UpdateException {
	    Integer rows = userMapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime);
	    if (rows != 1) {
	        throw new UpdateException(
	            "修改用户数据时出现未知错误！");
	    }
	}
	
	@Override
	public void changeAvatar(Integer uid, String avatar) throws UserNotFoundException, UpdateException {
	    // 根据uid查询用户数据
	    User result = findByUid(uid);
	    // 判断查询结果是否为null
	    if (result == null) {
	        // 是：抛出UserNotFoundException
	        throw new UserNotFoundException(
	            "修改头像失败！尝试访问的用户不存在！");
	    }

	    // 判断查询结果中isDelete是否为1
	    if (result.getIsDelete().equals(1)) {
	        // 是：抛出UserNotFoundException
	        throw new UserNotFoundException(
	            "修改头像失败！尝试访问的用户不存在！");
	    }

	    // 向user中封装modifiedUser和modifiedTime
	    String modifiedUser = result.getUsername();
	    Date modifiedTime = new Date();
	    // 执行更新
	    updateAvatar(uid, avatar, modifiedUser, modifiedTime);
	}*/
}
