<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Products" %>
<%@ page import="until.Page" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link  href="${pageContext.request.contextPath}/css/bootstrap.min.css " rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jQuery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap-table.css">
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/js/locale/bootstrap-table-zh-CN.js"></script>
<script>
    var xmlhttp;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    function search1() {
        showPage(this);
    }
    function showPage(index) {
        var currentPage;
        if (index > 1) {
            currentPage = index;
        } else {
            currentPage = document.getElementById("h_currentPage").value;
        }
        var pageSize = document.getElementById("h_pageSize").value;

        xmlhttp.open("GET", "Products?op=doShowPage"
        +"&currentPage=" + currentPage
            + "&pageSize="+pageSize
            + "&product_name="+document.getElementById("product_name").value
            + "&providerID="+document.getElementById("providerID").value
            + "&categoryID="+document.getElementById("categoryID").value
            ,true);

        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var txt = xmlhttp.responseText;
                var jsonPage = JSON.parse(txt);
                //给当前也和总页数赋值
                document.getElementById("currentPage").innerHTML = jsonPage.currentPage;

                document.getElementById("totalPage").innerHTML = parseInt((jsonPage.totalRecord + jsonPage.pageSize - 1) / jsonPage.pageSize);
                //给上一页下一页赋值
                document.getElementById("up");
                up.onclick = function () {

                    showPage(jsonPage.currentPage > 1 ? jsonPage.currentPage - 1 : jsonPage.currentPage);
                }
                document.getElementById("next");
                next.onclick = function () {

                    showPage(jsonPage.currentPage < parseInt((jsonPage.totalRecord + jsonPage.pageSize - 1) / jsonPage.pageSize) ? jsonPage.currentPage + 1 : jsonPage.currentPage);
                }
                var list = jsonPage.list;
                var r;
                var t = document.getElementById("mytable");
                clearTable();
                for (var i = 0; i < list.length; i++) {
                    var index = t.rows.length - 1;
                    r = t.insertRow(index);
                    r.insertCell().innerHTML = list[i].productID;
                    r.insertCell().innerHTML = list[i].product_name;
                    r.insertCell().innerHTML = list[i].income_price;
                    r.insertCell().innerHTML = list[i].pv.provider_name;
                    r.insertCell().innerHTML = list[i].quantity;
                    r.insertCell().innerHTML = list[i].sale_price;
                    r.insertCell().innerHTML = list[i].cg.category_name;
                    r.insertCell().innerHTML = list[i].income_time;
                    r.insertCell().innerHTML =
                        "<a href='Products?op=doDelete&pid=" + list[i].productID + "'>删除产品</a>&nbsp;&nbsp;" +
                        "<a href='Products?op=ready&pid=" + list[i].productID + "'>修改产品</a>";
                }

            }
        }
        xmlhttp.send();
    }

    //清楚表格数据
    function clearTable() {
        var t = document.getElementById("mytable");
        var len = t.rows.length - 2;
        for (var i = len; i >= 1; i--) {
            t.deleteRow(i);
        }
    }


</script>

<body onload="showPage()" >
<input id="h_currentPage" type="text" value="1" hidden>
<input id="h_pageSize" type="text" value="3" hidden>
<div class="form-inline" style="margin-left: 10px">
    <div class="navbar">

<input class="form-control" id="product_name" type="text" placeholder="请输入产品名">
    &nbsp;
    <select class="form-control" id="providerID">
        <option value="0">请选择供应商</option>
    </select>
    &nbsp;
    <select class="form-control" id="categoryID">
        <option value="0">请选择产品种类</option>
    </select>
    &nbsp;
    <a class="btn btn-danger" href="javascript:void(0)" onclick="search1()">搜索产品</a>
    </div>
</div>

<table width="85%" border="1px" id="mytable" style="margin-left: 10px">
    <tr>
        <td>产品id</td>
        <td>产品名称</td>
        <td>产品进价</td>
        <td>供应商名称</td>
        <td>产品数量</td>
        <td>产品售价</td>
        <td>种类名称</td>
        <td>进货时间</td>
        <td>产品操作</td>
    </tr>
    <tr>
        <td colspan="9" align="center">
            <a id="up" href="#">上一页</a>
            &nbsp;&nbsp;
            当前第<span id="currentPage"></span>页
            &nbsp;&nbsp;
            总共<span id="totalPage"></span>页
            &nbsp;&nbsp;
            <a id="next" href="#">下一页</a>
        </td>
    </tr>
</table>
<script>

    //
    //加载所有供应商和目录
    function cateAddPro() {
        xmlhttp.open("GET", "Products?op=cateAndPros2", false);

        xmlhttp.onreadystatechange=function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var txt = xmlhttp.responseText;
                var jsonObj = JSON.parse(txt);
                var list1=jsonObj[0];
                var list2=jsonObj[1];
                var p=document.getElementById("providerID");
                for(var i=0;i<list1.length;i++){
                    var op=new Option(list1[i].provider_name,list1[i].providerID);
                    p.add(op);
                }
                var c=document.getElementById("categoryID");
                for(var i=0;i<list2.length;i++){
                    var op=new Option(list2[i].category_name,list2[i].categoryID);
                    c.add(op);
                }
            }
        }
        xmlhttp.send();
    }
    cateAddPro();
</script>
</body>
</html>
