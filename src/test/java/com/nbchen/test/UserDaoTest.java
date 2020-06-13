package com.nbchen.test;

import com.nbchen.dao.UserDao;
import com.nbchen.dao.impl.UserDaoImpl;
import com.nbchen.pojo.User;
import org.junit.Test;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用!");
        } else {
            System.out.println("用户名已存在!");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin","admin") == null) {
            System.out.println("用户名或密码错误,登录失败!");
        } else {
            System.out.println("登录成功!");
        }
    }

    @Test
    public void saveUser() {
        int result = userDao.saveUser(new User(null, "test", "123456", "test@nbchen.com"));
        System.out.println("返回值:"+result);
        if (result == -1) {
            System.out.println("操作失败");
        } else {
            System.out.println("保存成功");
        }
    }
}