<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Providers" %>
<%@ page import="until.Page" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/16
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%--<%
    Page<Providers> pvpage=(Page<Providers>)request.getAttribute("page");
    List<Providers> list=pvpage.getList();
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
    <tr>
        <td colspan="7" align="center">
            <%
                if(pvpage.getCurrentPage()==1){
            %>
            <a>上一页</a>
            <%
            }else {
            %>
            <a href="Providers?op=doShowPage&currentPage=<%=pvpage.getPreviousPage()%>&pageSize=3">上一页</a>
            <%
                }
            %>

            &nbsp;&nbsp;
            当前第<%=pvpage.getCurrentPage()%>页
            &nbsp;&nbsp;
            总共<%=pvpage.getTotalPage()%>页
            &nbsp;&nbsp;
            <%
                if(pvpage.getCurrentPage()==pvpage.getTotalPage()){
            %>
            <a>下一页</a>
            <%
            }else{
            %>
            <a href="Providers?op=doShowPage&currentPage=<%=pvpage.getNextPage()%>&pageSize=3">下一页</a>
            <%
                }
            %>
        </td>
    </tr>
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
    <c:forEach items="${page.list}" var="q">
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
    <tr>
        <td colspan="7" align="center">
            <c:if test="${page.currentPage==1}">
                <a>上一页</a>
            </c:if>
            <c:if test="${page.currentPage>1}">
                <a href="Providers?op=doShowPage&currentPage=${page.previousPage}&pageSize=3">上一页</a>
            </c:if>

            &nbsp;&nbsp;
            当前第${page.currentPage}页
            &nbsp;&nbsp;
            总共${page.totalPage}页
            &nbsp;&nbsp;
            <c:if test="${page.currentPage==page.totalPage}">
                <a >下一页</a>
            </c:if>
            <c:if test="${page.currentPage<page.totalPage}">
                <a href="Providers?op=doShowPage&currentPage=${page.nextPage}&pageSize=3">下一页</a>
            </c:if>
        </td>
    </tr>
</body>
</html>
