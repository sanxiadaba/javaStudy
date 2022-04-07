package com.sanxiadaba.service;

import com.sanxiadaba.dao.UserTestMapper;
import com.sanxiadaba.pojo.UserTest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserTestImpl implements UserTestMapper {

    //    service调dao层
    private UserTestMapper userTestMapper;

    public void setUserTestMapper(UserTestMapper userTestMapper) {
        this.userTestMapper = userTestMapper;
    }

    @Override
    public List<UserTest> selectAll() {
        return userTestMapper.selectAll();
    }
}
