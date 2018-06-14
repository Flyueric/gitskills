package com.bovane.dao;

import com.bovane.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

public interface UserDao {
    public User selectByNamePWD(SqlSession session,@Param(value = "name")String name,@Param(value = "password") String password);
}
