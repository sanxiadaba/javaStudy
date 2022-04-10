package com.sanxiadaba.reflect;

import java.util.Objects;

public class FirstRe{
    public static void main(String[] args) throws ClassNotFoundException {
        User user = new User();
        Class<?> c1 = Class.forName("com.sanxiadaba.reflect.User");
        Class<? extends User> c2 = user.getClass();
        Class<User> c3 = User.class;

        System.out.println(c1);   //  class com.sanxiadaba.reflect.FirstRe
        System.out.println(c1.hashCode()+" "+c2.hashCode()+" "+c3.hashCode()); // 685325104 685325104 685325104

    }
}


class User {
    private String name;
    private Integer age;

    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User firstRe = (User) o;
        return name.equals(firstRe.name) && age.equals(firstRe.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
