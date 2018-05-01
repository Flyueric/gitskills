package com.bov.dao;
/*
* This is for connecting database . */
import java.sql.*;
import java.sql.DriverManager;
import org.junit.Test;
public class DaoUtils {
    private static final String URL = "jdbc:mysql://localhost/online_shop?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "asdhwxv";
    public static Connection getConn() {
        Connection conn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn; // 返回连接对象
    }
    @Test
    public void error() {
        Connection myconn = getConn();
        if(myconn==null) {
            System.out.println("Error");
        }
    }
}

