<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2018/6/7
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login here</title>
</head>
<body>
    <h1 align="center" size="2">系统登录</h1>
    <br>
    <form action="${pageContext.request.contextPath}/admin/users/login.do" method="post">
        <th>用户名</th>
        <td><input type="text" name="name"></td> <br>
        <th>密码</th>
        <td><input type="text" name="password"></td> <br>
        <input type="submit" value="登录" name="submit" align="left">
        <input type="reset" value="取消" name="cancel" align="right"> <br>
    </form>
</body>
</html>
