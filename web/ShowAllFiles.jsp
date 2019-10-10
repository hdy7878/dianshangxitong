<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/30
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>显示所有文件</h2>
<table border="1px" width="80%">
    <tr>
        <td>ID</td>
        <td>文件名</td>
        <td>说明</td>
        <td>识别ID</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="f">
        <tr>
            <td>${f.id}</td>
            <td>${f.file_name}</td>
            <td>${f.file_desc}</td>
            <td>${f.file_auto_name}</td>
            <td>
               <a href="File?op=doDownLoad&id=${f.id}">下载文件</a>
                <a href="File?op=doDelFile&id=${f.id}">删除文件</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
