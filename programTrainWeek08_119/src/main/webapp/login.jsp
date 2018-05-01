<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2018/4/26
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1 align="center" size="2">用户登录</h1>
    <form action="LoginServlet" method="get">
        用户名 <input type="text" name="name">
        密码 <input type="text" name="pwd">
        <input type="submit" value="登录" name="submit">
    </form>
</body>
</html>
