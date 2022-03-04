package com.sanixadaba.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// 处理前端返回的表单请求,并重定向

public class RequestFormGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        System.out.println("进入get请求");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username+":"+password);
        // 重定向时注意路径问题
        resp.sendRedirect("/javaWeb_01/redictSuccess.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
