<%@ page import="com.bovane.entity.GoodsType" %><%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2018/6/14
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit goodsType</title>
</head>
<body>
<h1 align="center" size="2">更新商品类别</h1>
<%
    GoodsType goodsType = (GoodsType) session.getAttribute("oneType");
%>
<form action="${pageContext.request.contextPath}/admin/goodsType/doedit.do" method="post">
    类别名称：<input type="text" name="typeName" value="<%=goodsType.getName()%>"> <br>
    <input type="submit" value="修改" name="submit">
</form>

</body>
</html>
