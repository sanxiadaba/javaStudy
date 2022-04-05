package log;


import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class LogAfter implements AfterReturningAdvice {

    // 目标对象方法 参数 目标对象
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + target.getClass().getName() + " 的 " + method.getName() + "返回了: " + returnValue);
    }
}
