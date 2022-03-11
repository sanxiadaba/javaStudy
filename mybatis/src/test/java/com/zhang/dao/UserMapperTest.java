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

    // 测试缓存 默认开启,只在一次sqlsession中有效,只能清理,无法关闭
    @Test
    public void cacheTest() {
        /**
         * 映射语句文件中的所有 select 语句的结果将会被缓存。
         * 映射语句文件中的所有 insert、update 和 delete 语句会刷新缓存。
         * 缓存会使用最近最少使用算法（LRU, Least Recently Used）算法来清除不需要的缓存。
         * 缓存不会定时进行刷新（也就是说，没有刷新间隔）。
         * 缓存会保存列表或对象（无论查询方法返回哪种）的 1024 个引用。
         * 缓存会被视为读/写缓存，这意味着获取到的对象并不是共享的，可以安全地被调用者修改，而不干扰其他调用者或线程所做的潜在修改。
         *
         */

        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.getUserById(1);
//        手动清理缓存
//        sqlSession.clearCache();
        System.out.println("=============");
        User user2 = userMapper.getUserById(1);
        // 结果是 true 在Mybaties里默认开启了一级缓存 而且明显看出sql只执行了一次查询
        System.out.println(user1 == user2);

        sqlSession.close();
    }

    // 测试二级缓存
    @Test
    public void cacheTwoTest() {
        // 获取第一个sqlsession对象
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        // 获取第二个sqlsession对象
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        // 注意,第一个session关闭后才会进入二级缓存
        User user1 = userMapper1.getUserById(1);
        sqlSession1.close();
        User user2 = userMapper2.getUserById(1);
        sqlSession2.close();
        System.out.println("=========");
        // 这里的结果是 true
        System.out.println(user1 == user2);
    }


}

