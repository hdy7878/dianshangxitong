<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Categorys" %>
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
    Page<Categorys> cpage=(Page<Categorys>)request.getAttribute("page");
    List<Categorys> list=cpage.getList();
%>
<body>
<table width="85%" border="1px">
    <tr>
        <td>产品种类id</td>
        <td>种类名称</td>
        <td>种类介绍</td>
        <td>种类操作</td>
    </tr>
        <%
        for(Categorys cg:list){
     %>
    <tr>
        <td><%=cg.getCategoryID()%></td>
        <td><%=cg.getCategory_name()%></td>

        <td><%=cg.getCategory_desc()%></td>

        <td>
            <a href="Categorys?op=doDelete&cid=<%=cg.getCategoryID()%>">删除种类</a>&nbsp;
            <a href="Categorys?op=ready&cid=<%=cg.getCategoryID()%>">修改种类</a>
        </td>
    </tr>
        <%
        }
    %>
    <tr>
        <td colspan="4" align="center">
            <%
            if(cpage.getCurrentPage()==1){
            %>
            <a>上一页</a>
            <%
            }else {
            %>
            <a href="Categorys?op=doShowPage&currentPage=<%=cpage.getPreviousPage()%>&pageSize=3">上一页</a>
            <%
                }
            %>

            &nbsp;&nbsp;
            当前第<%=cpage.getCurrentPage()%>页
            &nbsp;&nbsp;
            总共<%=cpage.getTotalPage()%>页
            &nbsp;&nbsp;
            <%
                if(cpage.getCurrentPage()==cpage.getTotalPage()){
            %>
            <a>下一页</a>
            <%
            }else{
            %>
            <a href="Categorys?op=doShowPage&currentPage=<%=cpage.getNextPage()%>&pageSize=3">下一页</a>
            <%
                }
            %>

        </td>
    </tr>
</body>--%>
<body>
<table width="85%" border="1px">
    <tr>
        <td>产品种类id</td>
        <td>种类名称</td>
        <td>种类介绍</td>
        <td>种类操作</td>
    </tr>
    <c:forEach items="${page.list}" var="q">
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

    <tr>
        <td colspan="4" align="center">
            <c:if test="${page.currentPage==1}">
                <a >上一页</a>
            </c:if>
            <c:if test="${page.currentPage>1}">
                <a href="Categorys?op=doShowPage&currentPage=${page.previousPage}&pageSize=3">上一页</a>
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
                <a href="Categorys?op=doShowPage&currentPage=${page.nextPage}&pageSize=3">下一页</a>
            </c:if>


        </td>
    </tr>
</body>
</html>
