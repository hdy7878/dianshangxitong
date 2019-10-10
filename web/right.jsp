<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/15
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<style>

</style>
<body bgcolor="#dc3545">
<%--<%
    String loginName=(String) session.getAttribute("loginName");
%>--%>
<span style="font-size:18px; color:white; ">JSESSINOID:<%=session.getId()%></span>
</br>
<span style="font-size:18px; color:white; ">在线用户数：${onLineNum}</span>
</br>
<span style="font-size:18px; color:white; ">登录用户数：${loginNum}</span>
</br>
<span style="font-size: 60px ;color: white; ">欢迎管理员${loginName}使用该系统</span>
</body>
</html>

