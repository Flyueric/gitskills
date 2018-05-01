package com.bov.dao;
/*
* 这里是用户的操作，增加删除修改用户的数据库操作*/
import java.sql.*;
import com.bov.entity.User;
public class UserDao extends BaseDao{
    public int insertUser(Connection conn,User user){
        String sql="insert into users(userName,password,sex,age,email) values (?,?,?,?,?) ";
        Object[] obj = {user.getUserName(),user.getPassword(),user.getSex(),user.getAge(),user.getEmail()};
        int row= super.exeUpdate(conn, sql, obj);
        return row;
    }
    public User selectUser(Connection conn,String userName,String password) {
        String sql="select * from users where userName=? and password=?";
        ResultSet rs= super.exeQuery(conn, sql, userName,password);
        User user=null;
        if(rs!=null){
            try {
                if(rs.next()){
                    user=new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(userName);
                    user.setPassword(rs.getString("password"));
                    user.setSex(rs.getString("sex"));
                    user.setAge(rs.getInt("age"));
                    user.setEmail(rs.getString("email"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
