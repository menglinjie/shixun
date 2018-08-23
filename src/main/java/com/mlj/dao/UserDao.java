package com.mlj.dao;

import com.mlj.model.User;

import java.sql.SQLException;

public interface UserDao {

    //    根据用户名和年龄查找
    User select(String name, int age) throws SQLException;

}
