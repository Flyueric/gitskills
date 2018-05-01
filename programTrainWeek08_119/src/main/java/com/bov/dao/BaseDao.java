package com.bov.dao;

import java.sql.*;
import org.junit.Test;
public class BaseDao {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    /**
     * 通用的增删改方法
     * @param conn 数据库连接
     * @param sql  要执行的sql语句  insert update delete
     * @param values  ?对应的参数值
     * @return  返回影响的行数
     */

    public int exeUpdate(Connection conn, String sql, Object ... values) {
        int result = 0;
        try {
            ps = conn.prepareStatement(sql);
            if(values!=null){
                for (int i = 0; i < values.length; i++) {
                    ps.setObject(i+1, values[i]);
                }
            }
            result= ps.executeUpdate();// SQL 数据操作语言 (DML) 语句的行数 (2) 对于无返回内容的 SQL 语句，返回 0
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 通用的查询方法
     * @param conn 数据库连接
     * @param sql  要执行的sql语句  select
     * @param values  ?对应的参数值
     * @return  返回结果集
     */

    public ResultSet exeQuery(Connection conn, String sql, Object... values) {
        try {
            ps = conn.prepareStatement(sql);
            if(values!=null){
                for (int i = 0; i < values.length; i++) {
                    ps.setObject(i+1, values[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    @Test
    public void error() {
      //  ResultSet rs = exeQuery()
    }
}

