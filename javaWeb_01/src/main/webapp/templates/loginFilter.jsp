<%--
  Created by IntelliJ IDEA.
  User: 21901
  Date: 2022/3/4
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 一个简单的登陆表单--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginFilter" method="post">
    <input type="text" name="username"><br>
    <input type="submit">
</form>
</body>
</html>
