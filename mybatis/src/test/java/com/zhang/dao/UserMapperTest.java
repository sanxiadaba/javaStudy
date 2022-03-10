package com.zhang.dao;

import com.zhang.pojo.User;
import com.zhang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    // 初始化定义log4j
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    // 查询全部
    @Test
    public void getUserList() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user.getName());
        }
        sqlSession.close();
    }

    // 根据指定id查询
    @Test
    public void getUserById() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.getUserById(1);
        System.out.println(user);


        sqlSession.close();
    }

    // 插入用户
    @Test
    public void addUser() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Date date = new Date();
        int i = userMapper.addUser(new User(5, "李白", "123456", "lb@qq.com", date));
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    // 更新
    @Test
    public void updateUser() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Date date = new Date();
        int i = userMapper.updateUser(new User(5, "李白", "654321", "lb@qq.com", date));
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    // 删除
    @Test
    public void delUser() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.delUserById(5);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    // 使用map插入
    @Test
    public void useMap() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        // 不一定参数写完
        map.put("userId", 5);
        map.put("name", "李白");
        map.put("passWord", "76422");
        map.put("email", "lb@qq.com");
        map.put("birthday", new Date());

        int i = userMapper.useMap(map);

        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }

    // 模糊查询测试
    @Test
    public void getUserByName() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userByNameList = userMapper.getUserByName("%李%");
        for (User user : userByNameList) {
            System.out.println(user.getName());
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

    // 实现分页
    @Test
    public void getUserByPage() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> integerIntegerHashMap = new HashMap<String, Integer>();
        integerIntegerHashMap.put("start", 0);
        integerIntegerHashMap.put("size", 3);
        List<User> userByPageList = userMapper.getUserByPage(integerIntegerHashMap);
        for (User user : userByPageList) {
            System.out.println(user.getName());
            System.out.println(user.getPwd());
        }
        sqlSession.close();
    }


}

