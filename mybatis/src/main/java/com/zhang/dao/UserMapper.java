package com.zhang.dao;

import com.zhang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    // 查询全部用户
    List<User> getUserList();

    // 根据id查询用户
    User getUserById(int id);

    // 增加用户
    int addUser(User user);

    // 更新用户
    int updateUser(User user);

    // 删除一个用户
    int delUserById(int id);

    // 万能的map
    int useMap(Map<String, Object> map);

    // 模糊查询
    List<User> getUserByName(String name);

    // 实现分页功能
    List<User> getUserByPage(Map<String, Integer> map);


}
