package com.bovane.dao.impl;

import com.bovane.dao.UserDao;
import com.bovane.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends MybatisBaseDao implements UserDao {
    @Override
    public User selectByNamePWD(SqlSession session,String name,String password) {
        User user = (User) super.selectOne(session, "UserMapper.selectByNamePWD", name, password);
        return user;
    }
}
