package log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class LogBefore implements MethodBeforeAdvice {

    // 目标对象方法 参数 目标对象
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName() + " 的 " + method.getName() + " 被执行了");
    }
}
