package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @PostMapping("/reg")
    public ResponseResult<Void> reg(User user) {
        ResponseResult<Void> rr
            = new ResponseResult<Void>();
        System.out.println(user.getUsername());
        try {
            userService.reg(user);
            rr.setState(200);
        } catch (ServiceException e) {
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }

        return rr;
    }
   
    @RequestMapping("/login")
	public ResponseResult<User> login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session) {
		
		// 执行登录验证
		User data = userService.login(username, password);
		// 向Session中封装用户信息
		session.setAttribute("uid", data.getUid());
		session.setAttribute("username", data.getUsername());
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
    
    @RequestMapping("/change_password")
	public ResponseResult<Void> changePassword(
		@RequestParam("old_password") String oldPassword,
		@RequestParam("new_password") String newPassword,
		@RequestParam("new_password_2") String newPassword_2,
		HttpSession session) throws UserNotFoundException, PasswordNotMatchException, UpdateException {
    	//判断密码以不一致
    	System.out.println(newPassword+"_"+newPassword_2);
    	if(!newPassword.equals(newPassword_2)) {
    		return new ResponseResult<>(111);
    	}
    	
		// 从session中获取uid和username
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		// 执行修改密码：service.changePassword(uid,username,oldPassword,newPassword)
		userService.changePassword(uid, username, oldPassword, newPassword);
		// 返回结果
		return new ResponseResult<>(SUCCESS);
	}
    
    @RequestMapping("/change_info")
    public ResponseResult<Void> changeInfo(User user, HttpSession session) throws UserNotFoundException, UpdateException {
        // 封装uid
        Integer uid = getUidFromSession(session);
        user.setUid(uid);
        // 执行修改个人资料
        userService.changeInfo(user);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }
    
    @GetMapping("/info")
    public ResponseResult<User> getByUid(HttpSession session) {
        // 获取uid
        Integer uid = getUidFromSession(session);
        // 查询用户数据
        User data = userService.getByUid(uid);
        // 返回
        return new ResponseResult<User>(SUCCESS, data);
    }
}
