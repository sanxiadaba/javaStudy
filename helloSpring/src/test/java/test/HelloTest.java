package test;

import com.zhang.pojo.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.UserService;

public class HelloTest {
    @Test
    public void helloTest() {
//        获取spring的上下文对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//      现在对象交由spring管理,获取的话直接从里面取即可
        Hello hello = (Hello) context.getBean("hello2");
        Hello hello1 = (Hello) context.getBean("hello");
        System.out.println(hello == hello1);
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
        System.out.println(user1.getName());
        System.out.println(user1);
        System.out.println(user2);
    }

    @Test
    public void personTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person01 = context.getBean("person", Person.class);
        System.out.println(person01.getName());
        person01.getCat().shout();
        person01.getDog().shout();
    }

    @Test
    public void testProxy() {
        // 真实角色测试
        Host host = new Host();
        host.rent();

        // 代理测试
        Proxy proxy = new Proxy();
        proxy.setRent(host);
        Rent proxy1 = (Rent) proxy.getProxy();
        proxy1.rent();

    }

    // 测试aop的切入
    @Test
    public void testAop() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }

    // 自己实现切入
    @Test
    public void testDiyAop() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }

    // 使用注解方式注入
    @Test
    public void testAnnotation() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }


}
