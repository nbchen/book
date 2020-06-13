package com.nbchen.service.impl;

import com.nbchen.dao.UserDao;
import com.nbchen.dao.impl.UserDaoImpl;
import com.nbchen.pojo.User;
import com.nbchen.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            // 登录null,说明没查到,没查到表示可用
            return false;
        }
        return true;
    }
}
