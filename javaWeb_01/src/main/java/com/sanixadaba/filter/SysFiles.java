package com.sanixadaba.filter;

import com.sanixadaba.util.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 登陆情况下才能跳转到指定页面的过滤器
public class SysFiles implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 先要强转下
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Object userSession = request.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession == null) {
            response.sendRedirect(request.getContextPath() + "/error/error_404.jsp");
        }
        // 不管如何要先转发下去
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
