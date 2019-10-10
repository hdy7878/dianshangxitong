<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/20
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="85%" border="1px">
    <tr>
        <td>产品id</td>
        <td>产品名称</td>
        <td>产品进价</td>
        <td>供应商名称</td>
        <td>产品数量</td>
        <td>产品售价</td>
        <td>种类名称</td>
        <td>进货时间</td>
        <td>购物车操作</td>
    </tr>
<c:forEach items="${requestScope.lists}" var="p">
    <tr>
        <td>${p.productID}</td>
        <td>${p.product_name}</td>
        <td>${p.income_price}</td>
        <td>${p.pv.provider_name}</td>
        <td>${p.quantity}</td>
        <td>${p.sale_price}</td>
        <td>${p.cg.category_name}</td>
        <td>${p.income_time}</td>
        <td><a href="Products?op=doDeleteCar&pid=${p.productID}">从购物车中移除</a> </td>
    </tr>
</c:forEach>
  </table>
<a href="ShowAllProducts.jsp">返回</a>
</body>
</html>
