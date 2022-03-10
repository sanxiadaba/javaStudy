package com.zhang.dao;

import com.zhang.pojo.Teacher02;

import java.util.List;

public interface TeacherMapper {
    // 获取教师
    List<Teacher02> getTeacher();

    // 获取指定老师下的所有学生  (使用结果集映射的方法)
    Teacher02 getTeacherById(int id);

    // 与上一个函数相同作用,使用的是子查询的方法
    Teacher02 getTeacherById02(int id);
}
