package com.sanixadaba.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 使用lombok简化
// 此时生成get/set/toString/hashCode 还有参构造和无参构造

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
}
