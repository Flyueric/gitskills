<%@ page import="com.bovane.entity.Goods" %><%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2018/6/9
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update goods</title>
</head>
<body>
<h1 align="center" size="2">更新商品信息</h1>
<%
    Goods oneGoods = (Goods) session.getAttribute("oneGoods");
%>
<form action="${pageContext.request.contextPath}/admin/goods/doedit.do" method="post">
    商品名称：<input name="goodsName" type="text" value="<%=oneGoods.getGoodsName()%>"/><br/>
    商品类别：<select name="goodsType.id">
    <option value="0">请选择</option>
    <c:forEach items="${requestScope.types}" var="t">
        <option value="${t.id}">${t.name}</option>
    </c:forEach>
</select> <br/>
    商品价格：<input name="goodsPrice" type="text" value="<%=oneGoods.getGoodsPrice()%>"/><br/>
    库存:<input name="stock" type="text" value="<%=oneGoods.getStock()%>"> <br>
    商品描述：<textarea name="goods_desc" rows="8" cols="40"><%=oneGoods.getDescription()%></textarea><br/>
    <input name="goodsEdit" type="submit" value="修改" />
</form>
</body>
</html>
