package com.library.smart_library.controller;

import com.library.smart_library.entity.User;
import com.library.smart_library.service.IUserService;
import com.library.smart_library.service.ex.ServiceException;
import com.library.smart_library.util.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public String login(@Param("username") String username,
                        @Param("password") String password,
                        Map<String,Object> map, HttpSession session){

        System.out.println("login beginning......");
        ResponseResult<Void> rr
                = new ResponseResult<Void>();
        User result = null;
        try {
            result = userService.login(username,password);
            rr.setState(200);
        } catch (ServiceException e) {
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        if(rr.getState()==200&&result!=null){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            Integer uid = result.getUid();
            session.setAttribute("uid",uid);
            return "redirect:/index";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }

    }
}
