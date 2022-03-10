package com.zhang.utils;

import java.util.UUID;

// 生成唯一uuid

@SuppressWarnings("all")
public class IDutils {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

//    @Test
//    public void test(){
    // e77a86551a62491e8b2aab58b5ef8b59
//        System.out.println(IDutils.getId());
//    }
}
