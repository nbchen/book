package com.nbchen.dao.impl;

import com.nbchen.dao.UserDao;
import com.nbchen.dao.impl.BaseDao;
import com.nbchen.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {

    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    public int saveUser(User user) {
        String sql = "insert into t_user (username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
