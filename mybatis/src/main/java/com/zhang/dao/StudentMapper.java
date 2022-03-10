package com.zhang.dao;

import com.zhang.pojo.Student01;

import java.util.List;

public interface StudentMapper {
    // 查询所有学生以及老师对应的资料
    List<Student01> selectStudent();

    List<Student01> getStudent();
}
