package com.sanixadaba.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 在前端输出hello的响应
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置传输格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        // 实例化输出对象
        PrintWriter writer = resp.getWriter();
        writer.println("Hello,World!");
        // 获取上下文管理器
        ServletContext context = this.getServletContext();
        // 获取一开始设置的param
        String name = context.getInitParameter("testName");
        writer.println(name);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
