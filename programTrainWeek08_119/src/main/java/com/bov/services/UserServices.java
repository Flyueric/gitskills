package com.bov.services;
import com.bov.dao.DaoUtils;
import com.bov.dao.UserDao;
import com.bov.entity.User;
/*
* This class is for userServices . login and register !*/
import java.sql.Connection;
import java.sql.SQLException;

public class UserServices {
    private UserDao dao = new UserDao();
    public boolean login(User user) {
        boolean isLogin = false;
        Connection conn = DaoUtils.getConn();
        User userRej = dao.selectUser(conn,user.getUserName(),user.getPassword());
        if(userRej!=null) {
            if((userRej.getUserName().equals(user.getUserName())||(userRej.getUserName().equals(user.getUserName()))))
                isLogin = true;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isLogin;
    }
    public int register(User user) {
        int result = 0;
        Connection conn = DaoUtils.getConn();
        User userRej = dao.selectUser(conn,user.getUserName(),user.getPassword());
        if(userRej==null) {
            result = dao.insertUser(conn, user);
        }
        else{
            result = -1;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
