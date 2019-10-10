<%@ page import="entity.Categorys" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/19
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--<%
    Categorys cg=(Categorys)request.getAttribute("cg");
%>--%>
<body>
<h2>种类修改</h2>
<form action="Categorys?op=doEdit" method="post">
    <table>
        <input type="text" name="categoryID" value="${cg.categoryID}" readonly="readonly">
        <tr>
            <td>种类名称</td>
            <td><input type="text" name="category_name" value="${cg.category_name}"></td>
        </tr>
        <tr>
            <td>种类介绍</td>
            <td><input type="text" name="category_desc" value="${cg.category_desc}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确定修改"/>
                <input type="reset" value="重置数据"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
