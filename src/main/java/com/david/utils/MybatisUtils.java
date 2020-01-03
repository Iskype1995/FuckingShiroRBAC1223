package com.david.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 作者：赵伟风
 * 项目名： mybatis1910root
 * 时间：2019/12/6  10:11
 * 描述: ${描述}
 */
public class MybatisUtils {

    public static SqlSessionFactory sessionFactory;

    static {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        sessionFactory = factoryBuilder.build(resourceAsStream);
    }


    /**
     * 获取sqlsession
     * @return
     * @throws IOException
     */
    public static SqlSession openSession() throws IOException {

        SqlSession sqlSession = sessionFactory.openSession();

        return sqlSession;
    }

    /**
     * 关闭
     */
    public static void  commitAndClose(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }
}
