package com.zhang.service;

import com.zhang.dao.BlogMapper;
import com.zhang.pojo.Blog;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

// 可再简化一步
public class BlogMapperImpl_02 extends SqlSessionDaoSupport implements BlogMapper {

    @Override
    public List<Blog> selectAll() {
        SqlSession sqlSession = getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        return blogMapper.selectAll();
    }
}
