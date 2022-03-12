package com.zhang.pojo;
// 测试复杂类型的注入

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //    1.一般属性注入
//    <property name="name" value="Spring"/>
    private String name;
    //    2.引用类型注入
    private Address address;
    //    3.数组类型注入
    private String[] books;
    //    4.arraylist类型注入
    private List<String> hobbies;
    //    5.map类型注入
    private Map<String, String> card;
    //    6.set集合注入
    private Set<String> games;
    //    7.空指针注入
    private String wife;
    //    8.properties注入
    private Properties info;
}
