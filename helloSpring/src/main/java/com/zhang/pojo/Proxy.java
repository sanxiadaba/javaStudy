package com.zhang.pojo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 使用动态代理
public class Proxy implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setRent(Object target) {
        this.target = target;
    }

    // 生成得到代理类
    public Object getProxy() {
        return java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    // 处理代理示例,并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
