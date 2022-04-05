package com.sanxiadaba.service;

import com.sanxiadaba.dao.UserTestMapper;
import com.sanxiadaba.pojo.UserTest;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserTestImpl implements UserTestMapper {
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<UserTest> selectAll() {
        UserTestMapper userTestMapper = sqlSession.getMapper(UserTestMapper.class);
        return userTestMapper.selectAll();
    }

}
