<%@ page import="java.util.Date" %>
<%@ page import="com.sanixadaba.pojo.StudentOrm" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 设置页面出现错误跳转的页面--%>
<%@ page errorPage="error/error_500.jsp" %>
<html>
<body>
<%-- 引用页面--%>
<%@include file="common/header.jsp" %>
<jsp:include page="/common/header.jsp"/>
<%-- 查看网页在线人数--%>
<h1>当前有 <span style="color: blue"><%= pageContext.getServletContext().getAttribute("onlineCount")%> </span>在线</h1>
<%-- 表单的get请求--%>
<div style="text-align: center">
    <h2>Hello World!</h2>
    <h2>Get请求</h2>
    <form action="${pageContext.request.contextPath}/loginGet" method="get">
        用户名:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit">
    </form>
</div>
<%-- 表单的post请求--%>
<div style="text-align: center">
    <h2>Post请求</h2>
    <form action="${pageContext.request.contextPath}/loginPost" method="post">
        用户名:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        爱好:
        <input type="checkbox" name="hobbies" value="代码">代码
        <input type="checkbox" name="hobbies" value="唱歌">唱歌
        <input type="checkbox" name="hobbies" value="电影">电影
        <br>
        <input type="submit">
    </form>
</div>
<h2>JSP基础语法</h2>
<h3>测试热部署</h3>
<%--下main时jsp表达式--%>
<h4>本地时间</h4>
jsp表达式
<%= new Date().toLocaleString() %>
<hr>
jsp脚本片段
<%
    int sum=0;
    for (int i = 0; i < 10; i++) {
        sum+=i;
    }
    out.println("<h5>sum= </h5>"+sum);
%>
<hr>
<h4>
    错误处理
</h4>
<%--<%--%>
<%--    int errorNum=1/0;--%>
<%--    out.println(errorNum);--%>
<%--%>--%>

<%-- 存东西--%>
<%
    /*
    注意下面的作用域
    以及双亲委派机制
     */
    // 只在一个页面有效  后面还有一个参数可以设置作用域
    pageContext.setAttribute("1号","我是1号");
    // 只在一次请求中有效
    request.setAttribute("2号","我是2号");
    // 在一次会话中有效
    session.setAttribute("3号","我是3号");
    // 保存数据在服务器有效 (从打开服务器到关闭服务器,可以共享)
    application.setAttribute("4号","我是4号");
%>
<%-- 取东西--%>
<%
    String name1 = (String) pageContext.findAttribute("1号");
    String name2 = (String) pageContext.findAttribute("2号");
    String name3 = (String) pageContext.findAttribute("3号");
    String name4 = (String) pageContext.findAttribute("4号");
%>

<%-- 使用el表达式输出--%>

<%=name1%>
<%=name2%>
<%=name3%>
<%=name4%>

<%--转发--%>
<%--<%--%>
<%--    pageContext.forward("/redictSuccess.jsp");--%>
<%--    // 后台的转发--%>
<%--    request.getRequestDispatcher("/redictSuccess.jsp").forward(request,response);--%>
<%--%>--%>
<%--也可以转发--%>
<%--<jsp:forward page="error/error_500.jsp"/>--%>

<%-- 使用jsp转发时添加,获取参数--%>
<%--<jsp:forward page="error/error_500.jsp">--%>
<%--&lt;%&ndash;     存参数&ndash;%&gt;--%>
<%--    <jsp:param name="name5" value="name5"/>--%>
<%--    <jsp:param name="name6" value="name6"/>--%>
<%--&lt;%&ndash;    取参数&ndash;%&gt;--%>
<%--    <%=request.getParameter("name5")%>--%>
<%--    <%=request.getParameter("name6")%>--%>
<%--</jsp:forward>--%>

<%-- 使用javaBean--%>
<%--<%--%>
<%--    StudentOrm student = new StudentOrm();--%>
<%--%>--%>
<%--等价于--%>
<jsp:useBean id="student" class="com.sanixadaba.pojo.StudentOrm" scope="page"/>
<jsp:setProperty name="student" property="id" value="1"/>
<jsp:setProperty name="student" property="age" value="2"/>
<jsp:setProperty name="student" property="address" value="3"/>

id为 <jsp:getProperty name="student" property="id"/>
age <jsp:getProperty name="student" property="age"/>
address <jsp:getProperty name="student" property="address"/>


<%@include file="common/footer.jsp" %>
<jsp:include page="/common/footer.jsp"/>
</body>
</html>
