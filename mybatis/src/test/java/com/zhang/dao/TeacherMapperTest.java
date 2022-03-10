package com.zhang.dao;

import com.zhang.pojo.Teacher02;
import com.zhang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {
    // 初始化定义log4j
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    // 测试log4j
    @Test
    public void testLog4j() {
        logger.info("info,测试log4j");
        logger.debug("debug,测试log4j");
        logger.error("error,测试log4j");
        logger.warn("warn,测试log4j");
    }

    @Test
    public void getTeacher() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher02> teachers = teacherMapper.getTeacher();
        for (Teacher02 teacher : teachers) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    // 一对多查询 //第一种方法 对结果集合进行映射
    @Test
    public void getTeacherById() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher02 teacher = teacherMapper.getTeacherById(1);
        System.out.println(teacher);

        sqlSession.close();
    }

    // 一对多查询 //第二种方法 嵌套子查询
    @Test
    public void getTeacherById02() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher02 teacher = teacherMapper.getTeacherById02(1);
        System.out.println(teacher);

        sqlSession.close();
    }
}
