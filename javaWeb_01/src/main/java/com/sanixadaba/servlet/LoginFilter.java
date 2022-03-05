package com.sanixadaba.servlet;

import com.sanixadaba.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 拦截器判断用户登陆,并且开放访问指定文件的权限
public class LoginFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入GET方法");
        // 从前端获取传入的参数
        String username = req.getParameter("username");
        // 判断用户
//        System.out.println(username);
        if (username.equals("admin")) {
//            System.out.println("登陆成功");
            // 将信息放到session里
            req.getSession().setAttribute(Constant.USER_SESSION, req.getSession().getId());
            // 然后重定向
            resp.sendRedirect(req.getContextPath() + "/sys/success.jsp");
        } else {
//            System.out.println("登陆失败");
            // 重定向到错误页面
            resp.sendRedirect(req.getContextPath() + "/error/error_404.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入POST方法");
        doGet(req, resp);
    }
}
