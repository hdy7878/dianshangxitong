<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/19
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>供应商增加</h2>
<form method="post" action="Providers?op=doAdd">
    <table>
        <tr>
        <td>供应商名称</td>
        <td><input type="text" name="provider_name"> </td>
    </tr>
        <tr>
            <td>供应商地址</td>
            <td><input type="text" name="provider_add"> </td>
        </tr>
        <tr>
            <td>供应商联系方式</td>
            <td><input type="text" name="provider_tel"> </td>
        </tr>
        <tr>
            <td>供应商账户</td>
            <td><input type="text" name="account"> </td>
        </tr>
        <tr>
            <td>供应商邮箱</td>
            <td><input type="text" name="email"> </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确定增加"/>
                <input type="reset" value="重置数据"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
