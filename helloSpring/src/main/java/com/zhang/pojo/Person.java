package com.zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    @Autowired
    private Cat cat;
    @Autowired
    @Qualifier(value = "dog22")
    private Dog dog;
}
