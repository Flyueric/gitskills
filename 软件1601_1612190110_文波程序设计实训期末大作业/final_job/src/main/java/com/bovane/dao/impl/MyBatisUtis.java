package com.bovane.dao.impl;
/*加载全局配置文件Configuration.xml，返回session*/
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtis {
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSession createSqlSession() {
        SqlSession session = null;
        if (sqlSessionFactory == null) { // 加载全局配置文件
            String resource = "config/Configuration.xml";
            Reader reader;
            SqlSessionFactory sqlSessionFactory = null;
            try {
                reader = Resources.getResourceAsReader(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
                session = sqlSessionFactory.openSession();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            session = sqlSessionFactory.openSession();
        }
        return session;
    }
}

