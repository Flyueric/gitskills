package com.bovane.dao.impl;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MyBatisBaseDao {
    public int insert(SqlSession session,String sqlid, Object ... values) {
        int result = 0;
        result = session.insert(sqlid,values);
        return result;
    }
    public int update(SqlSession session,String sqlid, Object ... values) {
        int result = 0;
        result = session.update(sqlid,values);
        return result;
    }
    public int delete(SqlSession session,String sqlid, Object ... values) {
        int result = 0;
        result = session.insert(sqlid,values);
        return result;
    }
    public List select(SqlSession session,String sqlid, Object ... values) {
        List result = null;
        result = session.selectList(sqlid,values);
        return result;
    }
    public Object selectOne(SqlSession session,String sqlid, Object ... values) {
        Object result = null;
        result = session.selectOne(sqlid,values);
        return result;
    }
}
