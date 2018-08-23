package com.mlj.service.impl;

import com.mlj.dao.UserDao;
import com.mlj.dao.impl.UserDaoImpl;
import com.mlj.model.User;
import com.mlj.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    /**
     * 用户登录
     *
     * @param name
     * @param age
     * @return
     */
    public boolean login(String name, int age) {
        try {
            User user = userDao.select(name,age);
            if (user!=null){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
