package com.sanxiadaba.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class FirstAn {

    @MyAnnotation(name = "我是")
    public void test(){

    }

}

// 自定义注解
@Target(value = {ElementType.METHOD,ElementType.TYPE})  // 放到方法和类上
@Retention(value = RetentionPolicy.RUNTIME)  // 运行期仍识别
@interface MyAnnotation{
    // 传递 name=  参数
    String name() default "你好";
}
