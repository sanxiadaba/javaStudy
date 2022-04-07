package com.sanxiadaba.dao;

import com.sanxiadaba.pojo.UserTest;

import java.util.List;

public interface UserTestMapper {
    // 查询全部用户
    List<UserTest> selectAll();
}
