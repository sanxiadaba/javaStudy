<%--
  Created by IntelliJ IDEA.
  User: 21901
  Date: 2022/3/3
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 显式生命这是一个错误页面--%>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这是404错误页面</h1>
<img src="${pageContext.request.contextPath}/statics/img/error_404.png" alt="404">
</body>
</html>
