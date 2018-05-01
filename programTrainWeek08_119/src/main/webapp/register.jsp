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
    <title>Register</title>
</head>
<body>
    <h1 align="center" size="2">用户注册</h1>
    <form action="LoginServlet" method="post">
        用户名 <input type="text" name="userName">
        密码 <input type="text" name="pwd">
        性别 <input type="radio" name="sex" value="male" checked="default"> 男
                <input type="radio" name="sex" value="female"> 女
        年龄 <input type="text" name="age">
        e-mail <input type="text" name="email">
        <input type="submit" value="提交" name="submit">
    </form>
</body>
</html>
