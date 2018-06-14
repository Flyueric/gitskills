<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>商品管理列表</h3>
	<table>
		<tr>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>类别</td>
			<td>库存</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${requestScope.goods}" var="good">
			<tr>
				<td>${good.goodsName}</td>
				<td>${good.goodsPrice}</td>
				<td>${good.goodsType.name}</td>
				<%--<td>${good.description}</td>--%>
				<td>${good.stock}</td>
				<td>
				<a href="${pageContext.request.contextPath}/admin/goods/del.do?id=${good.id}">删除</a>
				<a href="${pageContext.request.contextPath}/admin/goods/toedit.do?id=${good.id}">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>