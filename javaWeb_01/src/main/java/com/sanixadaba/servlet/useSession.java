package com.sanixadaba.servlet;

import com.sanixadaba.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

// 使用session

public class useSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先解决乱码问题
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        resp.setContentType("text/html; charset=utf-8");
        // 获取session
        HttpSession session = req.getSession();
        // 给session中存东西
        session.setAttribute("name","张三"); // 存字符串
        session.setAttribute("Person",new Person("张三",20)); // 存对象
        // 获取session的id
        String id = session.getId();
        // 实例化能输出的对象
        PrintWriter out = resp.getWriter();
        // 判断session是不是新创建的
        if (session.isNew()){
            out.write("session创建成功,id为"+id);
        }else {
            out.write("session已经在服务器中存在,id为"+id);
            out.write("从session取到的name为"+session.getAttribute("name"));
            Person person= (Person) session.getAttribute("Person");
            System.out.println(person);
            out.write("从session取到的Person年龄为"+person.getAge());
            // 去除指定session
            session.removeAttribute("name");
            // 注销session
            session.invalidate();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
