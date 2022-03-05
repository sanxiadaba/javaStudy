<%--
  Created by IntelliJ IDEA.
  User: 21901
  Date: 2022/3/4
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 用来测试指定拦截器才能访问指定页面--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--//     用这种方式也能实现重定向--%>
<%--//     也可以用过滤器实现--%>
<%--    Object userSession = request.getSession().getAttribute("USER_SESSION");--%>
<%--    if (userSession==null){--%>
<%--        response.sendRedirect(application.getContextPath()+"/login");--%>
<%--    }--%>
<%--%>--%>
<%--<h1>测试用的系统主页</h1>--%>
<p><a href="${pageContext.request.contextPath}/logout">注销</a></p>
</body>
</html>
