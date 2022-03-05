package com.sanixadaba.filter;

import javax.servlet.*;
import java.io.IOException;

// 字符编码过滤器过滤器

public class CharacterEncoding implements Filter {
    // 初始化
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // web服务器启动时就初始化
        // 随时监听,等待过滤
        System.out.println("CharacterEncoding初始化");
    }

    /*
    输出输入后都要经过过滤器
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html");
        servletResponse.setContentType("text/html; charset=utf-8");
        // 每一次访问符合要求的页面都会处罚请求
//        System.out.println("过滤器执行前");
        // 让我们的请求继续走,不然到这就停止了
        filterChain.doFilter(servletRequest, servletResponse);
//        System.out.println("过滤器执行后");
    }

    // 销毁
    // 服务器关闭时销毁
    @Override
    public void destroy() {
        System.out.println("CharacterEncoding销毁");
    }
}
