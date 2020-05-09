package com.library.smart_library.controller;

import com.library.smart_library.entity.User;
import com.library.smart_library.service.IUserService;
import com.library.smart_library.service.ex.ServiceException;
import com.library.smart_library.util.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/change_password")
    public ResponseResult<Void> changePassword(
            @Param("old_password") String old_password,
            @Param("new_password") String new_password,
            @Param("confirm_password") String confirm_password,
            HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<>();
        if(!new_password.equals(confirm_password)){
            rr.setState(111);
            return rr;
        }
        try {
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            String username = session.getAttribute("loginUser").toString();
            userService.changePassword(uid,username,old_password,new_password);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }

        return rr;
    }

    @GetMapping("/userInfo")
    public ResponseResult<User> userInfo(HttpSession session){
        ResponseResult<User> rr = new ResponseResult<>();
        try{
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            User user = userService.getByUid(uid);
            rr.setData(user);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    @PostMapping("/changeInfo")
    public ResponseResult<Void> changeInfo(User user,HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<>();
        try {
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            user.setUid(uid);
            userService.changeInfo(user);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }

        return rr;
    }
}
