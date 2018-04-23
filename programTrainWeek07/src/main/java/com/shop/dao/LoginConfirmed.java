package com.shop.dao;
//*
// 这里是进行数据库操作，根据传递而来的账号和密码，
// 查询数据库，并确定是否登录成功。
// */
import java.sql.*;
import java.sql.DriverManager;
import org.junit.Test;
public class LoginConfirmed {
    private static final String URL = "jdbc:mysql://localhost/online_shop?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "asdhwxv";
    public  static boolean confirmedLogin(String name,String password) {
        Connection conn;
        PreparedStatement ps;
        boolean flag = false;
        ResultSet rs = null;
        String localName; // 遍历结果集时，临时保存
        String localPwd; // 账号和密码
        String strSql = "select * from users ";
        try { // 得到查询结果集
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            ps = conn.prepareStatement(strSql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while(rs.next()) {
                    localName = rs.getString(2);
                    localPwd = rs.getString(3);
                    if ((localName.equals(name) && (localPwd.equals(password))))
                        flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    @Test
    // 这里是测试查询数据库是否成功（账号和密码测试）
    public void myTest() {
        boolean flag = LoginConfirmed.confirmedLogin("eric","123456");
        if(flag==true)
            System.out.println("success");
        else
            System.out.println("failure");

    }
}
