<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2018/6/9
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To add GoodsType</title>
</head>
<body>
    <h1 align="center" size="2">商品类别添加</h1>
    <form action="${pageContext.request.contextPath}/admin/goodsTypes/doadd.do" method="post">
        类别名称：<input type="text" name="typeName" > <br>
        <input type="submit" value="提交" name="submit">
    </form>
</body>
</html>
