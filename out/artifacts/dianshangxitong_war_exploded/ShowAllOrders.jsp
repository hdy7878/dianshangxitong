<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/9/2
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="80%" border="1px" style="text-align: center">

        <tr>
            <td>订单id</td>
            <td>下单日期</td>
            <td>客户id</td>
            <td>员工id</td>
            <td colspan="2">操作</td>
        </tr>
<c:forEach items="${list}" var="q">
    <td>${q.orderID}</td>
    <td>${q.order_date}</td>

    <td>${q.cus.customerID}</td>
    <td>${q.emp.empID}</td>
    <td><a href="#">删除订单</a></td>
   <td><a href="Orders?op=showIn&oid=${q.orderID}" target="right" >订单详情</a></td>
</c:forEach>
    </tr>
</table>
</body>
</html>
