package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;
import cn.tedu.store.service.ex.UpdateException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {

    @Autowired
    public IUserService service;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("mybatis");
            user.setPassword("1234");
            user.setGender(1);
            user.setPhone("13800138006");
            user.setEmail("mybatis@tedu.cn");
            user.setAvatar("http://www.tedu.cn/mybatis.png");
            service.reg(user);
            System.err.println("OK");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        try {
            String username = "root";
            String password = "1234";
            User data = service.login(username, password);
            System.err.println(data);
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
    
    @Test
    public void changePassword() throws UpdateException {
        try {
            Integer uid = 1000;
            String username = "超级管理员";
            String oldPassword = "1234";
            String newPassword = "8888";
            service.changePassword(uid, username, oldPassword, newPassword);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
    
    @Test
    public void changeInfo() throws UpdateException {
        try {
            User user = new User();
            user.setUid(8);
            user.setGender(1);
            user.setPhone("13100131009");
            user.setEmail("root@qq.com");
            service.changeInfo(user);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
    
    @Test
    public void getByUid() {
        try {
            Integer uid = 8;
            User data = service.getByUid(uid);
            System.err.println(data);
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
    
    @Test
    public void changeAvatar() throws UpdateException {
        try {
            Integer uid = 10;
            String avatar = "新头像的路径";
            service.changeAvatar(uid, avatar);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
}
