<%@ page import="service.ProviderService" %>
<%@ page import="entity.Providers" %><%--
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
    Providers pv=(Providers) request.getAttribute("pv");
%>--%>
<body>
<h2>供应商修改</h2>
<form action="Providers?op=doEdit" method="post">
    <table>
        <input type="text" name="providerID" value="${pv.providerID}" readonly="readonly">
        <tr>
            <td>供应商名称</td>
            <td><input type="text" name="provider_name" value="${pv.provider_name}"></td>
        </tr>
        <tr>
            <td>供应商地址</td>
            <td><input type="text" name="provider_add" value="${pv.provider_add}"></td>
        </tr>
        <tr>
            <td>供应商联系方式</td>
            <td><input type="text" name="provider_tel" value="${pv.provider_tel}"></td>
        </tr>
        <tr>
            <td>供应商账户</td>
            <td><input type="text" name="account" value="${pv.account}"></td>
        </tr>
        <tr>
            <td>供应商邮箱</td>
            <td><input type="text" name="email" value="${pv.email}"></td>
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
