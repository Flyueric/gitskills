package com.wb.week06;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class GoodsTest {
    private static final String URL = "jdbc:mysql://localhost/online_shop?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "asdhwxv";
    public void insertGoods(Goods goods) {
        Connection conn;
        PreparedStatement ps;
        boolean flag = false;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ps = conn.prepareStatement("INSERT INTO goods(name,kind,price) VALUES (?,?,?)");
            ps.setString(1, goods.getName());
            ps.setString(2, goods.getKind());
            ps.setDouble(3, goods.getPrice());
            if (ps.executeUpdate() > 0)
                flag = true;
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insertTest() {
        Goods goods = new Goods("T-shirt","clothes",300.0);
        insertGoods(goods);
    }

    public void deleteUser(int id) {
        Connection conn;
        PreparedStatement ps;
        boolean flag = false;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            ps = conn.prepareStatement("DELETE FROM goods WHERE id=?");
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
            ps = conn.prepareStatement("SELECT * FROM goods");
            rs = ps.executeQuery();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    @Test
    public void selectTest() {
        String filePath = "E:\\Codes\\Jcodes\\ProgramTrain\\src\\com\\wb\\week06\\goods.txt";
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
