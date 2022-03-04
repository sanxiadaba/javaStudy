package com.sanixadaba.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 用javaBean进行数据库的映射
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOrm {
    private int id;
    private int age;
    private String address;
}
