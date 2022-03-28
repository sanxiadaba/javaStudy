package com.zhang.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    @Test
    public void helloTest() {
//        获取spring的上下文对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//      现在对象交由spring管理,获取的话直接从里面取即可
        Hello hello = (Hello) context.getBean("hello2");
        Hello hello1 = (Hello) context.getBean("hello");
        System.out.println(hello==hello1);
//        true
        System.out.println(hello.toString());
        System.out.println(hello.getStr());
        System.out.println(hello1.toString());
        System.out.println(hello1.getStr());

    }

    @Test
    public void studentTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }

    @Test
    public void userTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user1 = (User) context.getBean("user");
        User user2 = (User) context.getBean("user2");
        System.out.println(user1);
        System.out.println(user2);
    }
}
