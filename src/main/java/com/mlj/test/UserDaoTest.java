package com.mlj.test;

import com.mlj.dao.UserDao;
import com.mlj.dao.impl.UserDaoImpl;
import com.mlj.model.User;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserDaoTest {

    @Test
    public void testSelectByUserAndPass(){
        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.select("孟林洁", 2);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
