package com.sanxiadaba.service;

import com.sanxiadaba.dao.UserTestMapper;
import com.sanxiadaba.pojo.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserTestImpl implements UserTestMapper {

    //    service调dao层
    @Autowired
    private UserTestMapper userTestMapper;

//  等同于
//    public void setUserTestMapper(UserTestMapper userTestMapper) {
//        this.userTestMapper = userTestMapper;
//    }

    @Override
    public List<UserTest> selectAll() {
        return userTestMapper.selectAll();
    }
}
