package com.sanxiadaba.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTest {
    private int id;
    private String name;
    private String pwd;
    private String email;
    private Date birthday;
}
