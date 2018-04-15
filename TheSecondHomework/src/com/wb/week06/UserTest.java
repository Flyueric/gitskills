package com.wb.week06;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
public class UserTest {
    private static final String URL = "jdbc:mysql://localhost/online_shop?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "asdhwxv";

    public void insertUser(User user) {
        Connection conn;
        PreparedStatement ps;
        boolean flag = false;
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            ps = conn.prepareStatement("INSERT INTO users(name,sex,age,email) VALUES (?,?,?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getSex());
            ps.setInt(3,user.getAge());
            ps.setString(4,user.getEmail());
            if(ps.executeUpdate()>0)
                flag = true;
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
//            ps.close();
//            conn.close();
        }
    }
    @Test
    public void insertTest() {
        User user = new User("flyu","male",20,"128@aaa");
        insertUser(user);
    }
    public void deleteUser(int id) {
        Connection conn;
        PreparedStatement ps;
        boolean flag = false;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ps = conn.prepareStatement("DELETE FROM users WHERE id=?");
            ps.setInt(1,id);
            if(ps.executeUpdate()>0)
                flag = true;
            ps.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void deleteTest() {
        deleteUser(1);
    }
    public ResultSet selectUser() {
        ResultSet rs = null;
        Connection conn;
        PreparedStatement ps;
        boolean flag = false;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ps = conn.prepareStatement("SELECT * FROM users");
            rs = ps.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    @Test
    public void selectTest() {
        String filePath = "E:\\Codes\\Jcodes\\ProgramTrain\\src\\com\\wb\\week06\\user.txt";
        File file = new File(filePath);
        if(!file.exists()) {
            try {
                boolean flag = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ResultSet rs = selectUser();
        try {
            FileWriter wr = new FileWriter(file);
            while(rs.next()) {
                wr.write(rs.getString(1)+" "+rs.getString(2)+"\r\n");
            }
            wr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
