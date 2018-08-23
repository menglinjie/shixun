package com.mlj.jdbc;

import com.mlj.model.User;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc {


    @Test
    public void selectUsers() throws ClassNotFoundException, SQLException {
//        加载驱动
        Class.forName("com.mysql.jdbc.Driver");
//        数据库信息
        String url = "jdbc:mysql://localhost:3306/dbtest";
        String user = "root";
        String pass = "root";
//        获取连接
        Connection connection = DriverManager.getConnection(url, user, pass);
//        准备sql
        String sql = "select * from tuser";
//        insert into tuser(id,name,age) values(?,?,?);
//        创建praprestatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        执行sql
        ResultSet resultSet = preparedStatement.executeQuery();
//        处理结果集
        List<User> userList = new ArrayList<User>();
        User user1;
        while (resultSet.next()) {
            user1 = new User();
            user1.setId(resultSet.getInt("id"));
            user1.setName(resultSet.getString("name"));
            user1.setAge(resultSet.getInt("age"));
            userList.add(user1);
        }
        for (User user2 : userList) {
            System.out.print(user2

            );
        }
//        关闭连接(先打开后关闭)
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void insertUser() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/dbtest";
        String user = "root";
        String pass = "root";
        String sql = "insert into tuser(name,age)values('孟',21)";
        Connection connection = DriverManager.getConnection(url, user, pass);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }


    @Test
    public void test() {
//        String x = "fmn";
//        x.toUpperCase();
//        System.out.print("===========>" + x);
//        String y = x.replace('f', 'F');
//        System.out.println("========>" + y);
//        y = y + "wxy";
//        System.out.println("=======>" + y);
//        int a[] = null;
//        a[0] = 1;

        String classFile = "com.jd.".replaceAll("\\.", "/") + "MyClass.class";
        System.out.println(classFile);
    }
}
