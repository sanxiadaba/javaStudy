package com.zhang.service;

import com.zhang.dao.BlogMapper;
import com.zhang.pojo.Blog;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class BlogMapperImpl implements BlogMapper {

    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<Blog> selectAll() {
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        return blogMapper.selectAll();
    }
}
