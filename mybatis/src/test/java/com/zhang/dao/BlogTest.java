package com.zhang.dao;

import com.zhang.pojo.Blog;
import com.zhang.utils.IDutils;
import com.zhang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BlogTest {
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


    // 先插入数据
    @Test
    public void addBlog() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        // 插入的话别忘了提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    // 根据if来查询数据
    @Test
    public void queryBlogIF() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "Spring");
        List<Blog> blogs = blogMapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    // 根据if来查询数据
    @Test
    public void queryBlogChoose() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "Spring");
        map.put("author", "狂神说");
        List<Blog> blogs = blogMapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    // 根据set来更新数据
    @Test
    public void updateBlogSet() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("id", "1358195b66cd48409a7826b7094a2171");
        map.put("author", "又改名");
        blogMapper.updateBlogSet(map);

        sqlSession.commit();
        sqlSession.close();
    }

    // 根据for-each来查询
    @Test
    public void queryBlogForeach() {
        // 获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        // 数组里什么都不添加就是查询全部了
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Java");
        titles.add("Spring");
        map.put("titles", titles);
        List<Blog> blogs = blogMapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
