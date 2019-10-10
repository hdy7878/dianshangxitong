<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Providers" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/16
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--<%
    ArrayList<Providers> list=(ArrayList<Providers>)request.getAttribute("list");

%>

<body>
<table width="85%" border="1px">
    <tr>
        <td>供应商id</td>
        <td>供应商名称</td>
        <td>供应商地址</td>
        <td>供应商电话</td>
        <td>供应商账户</td>
        <td>供应商邮箱</td>
        <td>供应商操作</td>
    </tr>
        <%
        for(Providers pv:list){
     %>
    <tr>
        <td><%=pv.getProviderID()%></td>
        <td><%=pv.getProvider_name()%></td>

        <td><%=pv.getProvider_add()%></td>
        <td><%=pv.getProvider_tel()%></td>
        <td><%=pv.getAccount()%></td>
        <td><%=pv.getEmail()%></td>
        <td>
            <a href="Providers?op=doDelete&pvid=<%=pv.getProviderID()%>">删除供应商</a>&nbsp;
            <a href="Providers?op=ready&pvid=<%=pv.getProviderID()%>">修改供应商</a>
        </td>
    </tr>
        <%
        }
    %>
    <tr><td colspan="7" align="center">
        <a href="Providers?op=doShowPage&currentPage=1&pageSize=3" target="right" >分页查询</a>
        <a href="Providers?op=readyto" target="right">增加供应商</a>
    </td></tr>
</body>--%>
<body>
<table width="85%" border="1px">
    <tr>
        <td>供应商id</td>
        <td>供应商名称</td>
        <td>供应商地址</td>
        <td>供应商电话</td>
        <td>供应商账户</td>
        <td>供应商邮箱</td>
        <td>供应商操作</td>
    </tr>

    <c:forEach items="${list}" var="q">
    <tr>
        <td>${q.providerID}</td>
        <td>${q.provider_name}</td>

        <td>${q.provider_add}</td>
        <td>${q.provider_tel}</td>
        <td>${q.account}</td>
        <td>${q.email}</td>
        <td>
            <a href="Providers?op=doDelete&pvid=${q.providerID}">删除供应商</a>&nbsp;
            <a href="Providers?op=ready&pvid=${q.providerID}">修改供应商</a>
        </td>
    </tr>
    </c:forEach>
</body>
</html>
