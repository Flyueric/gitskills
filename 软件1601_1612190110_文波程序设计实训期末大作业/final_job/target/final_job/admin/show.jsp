<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 2018/6/9
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show info</title>
</head>
<%--<%
    if(session.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    }
%>--%>
<body>
<table width="100%" height="100%" border="1" cellspacing="0">
    <tr height="100">
        <th colspan="2"><h1> 欢迎来到购物系统管理后台</h1></th>
    </tr >
    <tr height="100">
        <td><a href="/admin/goods/list.do" target="main">商品信息管理</a></td>
    </tr>
    <tr height="80">
        <td><a href="/admin/goods/toadd.do" target="main">商品信息添加</a></td>
    </tr>
    <tr height="100">
        <td width="15%">
            <a href="/admin/goodsTypes/list.do" target="main">商品类别管理</a>
        </td>
       <%-- <td rowspan="6"><iframe name="main" src="successLogin.jsp" frameborder="no" width="100%" height="100%"> </iframe></td>--%>
    </tr>
    <tr height="100">
        <td><a href="goodsType_toadd.jsp" target="main">商品类别添加</a></td>
    </tr>
    <tr height="80">
        <td><a href="exit.jsp" >系统退出</a></td>
    </tr>

</table>
</body>
</html>
