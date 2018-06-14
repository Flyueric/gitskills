<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2018/6/9
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GoodsType List</title>
</head>
<body>
    <h2 align="center" size="2">商品类型列表</h2>
    <table>
        <tr>
            <td>类别编号</td>
            <td>类别名称</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.goodsTypes}" var="goodsType">
            <tr>
            <td>${goodsType.id}</td>
            <td>${goodsType.name}</td>
            <td>
            <a href="${pageContext.request.contextPath}/admin/goodsTypes/del.do?id=${goodsType.id}">删除</a>
            <a href="${pageContext.request.contextPath}/admin/goodsTypes/toedit.do?id=${goodsType.id}">修改</a></td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
