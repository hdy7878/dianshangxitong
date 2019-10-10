<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Products" %>
<%@ page import="servlet.ProductServlet" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/15
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link  href="${pageContext.request.contextPath}/css/bootstrap.min.css " rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jQuery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
<script src="${pageContext.request.contextPath}/js/locale/bootstrap-table-zh-CN.js"></script>
<body>
<h2><a href="Products?op=doShowCar">显示购物车</a></h2>
<table width="85%" border="1px" id="mytable">
    <%--<tr>
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


    <c:forEach items="${requestScope.list}" var="p">
        <tr>
            <td>${p.productID}</td>
            <td>${p.product_name}</td>
            <td>${p.income_price}</td>
            <td>${p.pv.provider_name}</td>
            <td>${p.quantity}</td>
            <td>${p.sale_price}</td>
            <td>${p.cg.category_name}</td>
            <td>${p.income_time}</td>
            <td>
                <a href="Products?op=doDelete&pid=${p.productID}">删除产品</a>&nbsp;
                <a href="Products?op=ready&pid=${p.productID}">修改产品</a>
                <a href="Products?op=addToCar&pid=${p.productID}">添加到购物车</a>
            </td>
        </tr>

    </c:forEach>--%>
</table>
</body>
<script type="text/javascript">
$(function () {
    var t=new TableInit();
    t.Init();
})
var TableInit=function() {
    var oTableInit=new Object();
    oTableInit.Init=function() {
        $('#mytable').bootstrapTable({
            url: 'Products?op=doShowAll',
            method: 'get',
            striped: true,
            columns: [{
                checkbox: true
            }, {
                field: 'productID',
                title: '产品ID'
            }, {
                field: 'product_name',
                title: '产品名称'
            }, {
                field: 'income_price',
                title: '产品进价'
            }, {
                field: 'pv.provider_name',
                title: '供应商名'
            }, {
                field: 'quantity',
                title: '产品数量'
            }, {
                field: 'sale_price',
                title: '产品售价'
            }
                , {
                    field: 'cg.category_name',
                    title: '种类名称'
                }
                , {
                    field: 'income_time',
                    title: '进货时间'
                }, {
                    field: 'productID',
                    title: '操作',
                    formatter: actionFormatter

                }]
        });
    }
    oTableInit.queryParams = function (params) {
        var temp = {
            limit: params.limit,
            offset: params.offset,
            'op': 'doShowAll',
            'product_name': $("#product_name").val(),
            'providerID': $("#providerID").val(),
            'categoryID': $("#categoryID").val()
        }
        return temp;
    }
   return oTableInit;
}
function  actionFormatter(value,row,index) {
    return "<a class='btn btn-danger' href='#' onclick='del("+value
           +")'>删除产品</a>&nbsp;&nbsp;"
           +"<a class='btn btn-success' href='Products?op=ready&pid="+value+"'>修改产品</a>&nbsp;&nbsp;"
           +"<a class='btn btn-default' href='#' onclick='addToCar("+value+")'>添加到购物车</a>"
}
function addToCar(id) {
    $.ajax({
        url: 'Products',
        type: "get",
        data: {
            'op': 'addToCar',
            'pid': id
        }
    });
}
function del(id) {
    $.ajax({
        url:'Products',
        type:"get",
        data:{
            'op':'doDelete',
            'pid':id
        },
        success:function (msg) {
            if(msg=="ok"){
                alert("删除成功");
                $("#product_name").val("")
                $("#providerID").val(0)
                $("#categoryID").val(0)
                $("#mytable").bootstrapTable('refresh')
            }else{
                alert("删除失败");
            }

        }

    })
}
</script>
</html>
