package com.bovane.dao.impl;
/*Base dao,增删改查*/
import com.bovane.entity.Goods;
import com.bovane.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MybatisBaseDao {
    public int insert(SqlSession session,String sqlid,Object values){
        int result=0;
        result = session.insert(sqlid,values);
        return result;
    }
    public int update(SqlSession session,String sqlid,Object values){
        int result=0;
        result = session.update(sqlid,values);
        return result;
    }
    public int delete(SqlSession session,String sqlid,Object ... values){
        int result=0;
        result = session.update(sqlid,values);
        return result;
    }
    public List selectList(SqlSession session,String sqlid,Object ... values){
        List result;
        result = session.selectList(sqlid,values);
        return result;
    }
    public Object selectOne(SqlSession session, String sqlid, Object ... values){
        Object result;
        result = session.selectOne(sqlid,values);
        return result;
    }
}
