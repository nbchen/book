package com.nbchen.test;

import com.nbchen.pojo.User;
import com.nbchen.service.UserService;
import com.nbchen.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"nbchen","123456","nbchen@nbchen.com"));
    }

    @Test
    public void login() {
        if (userService.login(new User(null,"nbchen","123456","nbchen@nbchen.com")) == null) {
            System.out.println("登录失败！");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("nbchen")) {
            System.out.println("用户名已存在！");
        } else {
            System.out.println("用户名可用");
        }
    }
}