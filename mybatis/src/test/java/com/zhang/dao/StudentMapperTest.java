package com.zhang.dao;

import com.zhang.pojo.Student01;
import com.zhang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
    // 初始化定义log4j
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    /*多对一的处理*/ // 对应子查询与连表查询

    // 复杂查询
    // 方式一 按照查询进行嵌套处理
    @Test
    public void selectStudent() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student01> students = studentMapper.selectStudent();

        for (Student01 student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }

    // 方式二 结果的嵌套映射处理
    @Test
    public void getStudent() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student01> students = studentMapper.getStudent();

        for (Student01 student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }


    // 测试log4j
    @Test
    public void testLog4j() {
        logger.info("info,测试log4j");
        logger.debug("debug,测试log4j");
        logger.error("error,测试log4j");
        logger.warn("warn,测试log4j");
    }

    /*一对多的处理*/


}
