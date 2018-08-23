package com.mlj.dao.impl;

import com.mlj.dao.UserDao;
import com.mlj.model.User;
import com.mlj.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    /**
     * 根据用户名和密码查找
     * @param name
     * @param age
     * @return
     */
    public User select(String name, int age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        connection = JDBCUtil.getConnection();
        User user = null;
        try {
            String sql = "select * from tuser where name=? and age=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, preparedStatement, resultSet);
        }
        return user;
    }
}
