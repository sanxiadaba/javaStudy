package com.zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher02 {
    private int id;
    private String name;
    // 一个老师对应多个学生
    private List<Student02> students;
}
