package com.mlj.jdbc;

import com.mlj.model.User;
import com.mlj.util.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    /**
     * 查询用户列表
     */
    @Test
    public void selectUser() {
//        初始化局部变量
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from tuser");
//            处理结果集
            List<User> userList = new ArrayList<User>();
            User user;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setAge(rs.getInt(3));
                userList.add(user);
            }
            System.out.println(userList);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, stmt, rs);
        }

    }

    /**
     * 添加用户
     */
    @Test
    public void insertUser() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            String sql = "INSERT INTO tuser(name, age) VALUES ('唱完请',21)";
            int i = statement.executeUpdate(sql);
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }

    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            int i = statement.executeUpdate("UPDATE tuser SET name='常万青'WHERE id=4");
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUser() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM tuser WHERE id=3");
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
    }
}
