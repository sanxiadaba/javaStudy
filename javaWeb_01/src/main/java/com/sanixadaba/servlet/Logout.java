package com.sanixadaba.servlet;

import com.sanixadaba.util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object user_session = session.getAttribute(Constant.USER_SESSION);
        if (user_session != null) {
            session.removeAttribute(Constant.USER_SESSION);
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        // 这里如果没有值的话也会返回登陆页面(在jsp也可以处理)
//        else {
//            resp.sendRedirect(req.getContextPath()+"/login");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}