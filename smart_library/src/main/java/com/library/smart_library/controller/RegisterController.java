package com.library.smart_library.controller;

import com.library.smart_library.entity.User;
import com.library.smart_library.service.IUserService;
import com.library.smart_library.service.ex.ServiceException;
import com.library.smart_library.util.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/register")
    public String  register(User user,
                            Map<String,Object> map,
                            HttpSession session){
        System.out.println("register begining .....");

        if(!user.getPassword().equals(user.getCpassword())){
            map.put("msg","两次密码不一致");
            return "register";
        }
        ResponseResult<Void> rr
                = new ResponseResult<Void>();
        try {
            userService.reg(user);
            rr.setState(200);
        } catch (ServiceException e) {
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        if(rr.getState()==200){
            map.put("msg","注册成功");
            return "register";
        }else {
            map.put("msg",rr.getMessage());
            return "register";
        }
    }
}
