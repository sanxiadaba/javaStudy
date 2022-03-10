package com.zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student01 {
    private int id;
    private String name;
    // 一个学生对应一个老师
    private Teacher01 teacher;
}
