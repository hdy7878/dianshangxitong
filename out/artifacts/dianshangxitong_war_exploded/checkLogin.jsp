<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/15
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String loginName=(String)session.getAttribute("loginName");
    if(loginName==null) {
        out.write("<script>alert('对不起，请先登录');location.href='login.jsp'</script>");
    }
%>

