package com.mlj.util;

import java.sql.*;

public class JDBCUtil {

    //静态代码块，随着类的加载而加载 ，并且只加载一次
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //连接数据库
    public static Connection getConnection(){

        String url="jdbc:mysql:///dbtest";
        String user="root";
        String password="root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭资源-- 三个参数
    public static void close(Connection conn, Statement stmt, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
                rs=null;//gc	一个变量被赋值为null， 垃圾回收机制。 会优先处理这些对象。
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(stmt != null){
                stmt.close();
                stmt=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn !=null){
                conn.close();
                conn=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //关闭资源-- 两个参数
    public static void close(Connection conn,Statement stmt){
        try {
            if(stmt != null){
                stmt.close();
                stmt=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn !=null){
                conn.close();
                conn=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

