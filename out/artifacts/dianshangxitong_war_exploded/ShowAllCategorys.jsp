<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Categorys" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/16
  Time: 10:31
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
        <td>产品种类id</td>
        <td>种类名称</td>
        <td>种类介绍</td>
        <td>种类操作</td>
    </tr>
    <c:forEach items="${list}" var="q">
        <tr>
            <td>${q.categoryID}</td>
            <td>${q.category_name}</td>

            <td>${q.category_desc}</td>

            <td>
                <a href="Categorys?op=doDelete&cid=${q.categoryID}">删除种类</a>&nbsp;
                <a href="Categorys?op=ready&cid=${q.categoryID}">修改种类</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
