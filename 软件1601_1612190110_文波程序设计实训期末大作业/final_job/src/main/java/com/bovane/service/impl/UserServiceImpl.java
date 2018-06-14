package com.bovane.service.impl;

import com.bovane.dao.UserDao;
import com.bovane.dao.impl.MyBatisUtis;
import com.bovane.dao.impl.UserDaoImpl;
import com.bovane.entity.User;
import com.bovane.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.junit.Test;

@Service
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public boolean login(String name, String password) { // 登录服务
        boolean isLogin = false;
        Object user=null;
        SqlSession session = MyBatisUtis.createSqlSession();
        try {
           user =  dao.selectByNamePWD(session,name,password);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if(session!=null)
                session.close();
        }
        if(user!=null) {
            isLogin = true;
        }
        return isLogin;
    }
}
