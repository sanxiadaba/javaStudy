package diy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {

    @Before("execution(* study.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("使用注解执行前");
    }

    @After("execution(* study.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("使用注解执行后");
    }
}
