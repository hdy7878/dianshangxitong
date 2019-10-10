<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Providers" %>
<%@ page import="entity.Categorys" %>
<%@ page import="entity.Products" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/18
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    var xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    function cateAndPro(obj) {

        xmlhttp.open("GET", "Products?op=cateAndPros2", true);

        xmlhttp.onreadystatechange=function () {
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                var txt=xmlhttp.responseText;
                var jsonObj=JSON.parse(txt);

                var list1=jsonObj[0];
                var pro=document.getElementById("pro");
                for(var i=0;i<list1.length;i++){
                    var option=document.createElement("option");
                    option.value=list1[i].providerID;
                    option.innerHTML=list1[i].provider_name;
                    pro.appendChild(option);
                }
                var list2=jsonObj[1];
                var cate=document.getElementById("cate");
                for(var i=0;i<list2.length;i++) {
                    var option = document.createElement("option");
                    option.value = list2[i].categoryID;
                    option.innerHTML = list2[i].category_name;

                    cate.appendChild(option);
                }
            }
        }
        xmlhttp.send();
    }
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>

<body onload="cateAndPro(this)">
<h2>产品增加</h2>
<form action="Products?op=doAdd" method="post">
    <table>
        <tr>
            <td>产品名称</td>
            <td><input type="text" name="product_name" ></td>

        </tr>
        <tr>
            <td>产品进价</td>
            <td><input type="text" name="income_price"></td>
        </tr>
        <tr>
            <td>产品供应商</td>
            <td>
                <select name="pro" id="pro">
                    <option value="0">请选择供应商</option>

                </select>
            </td>
        </tr>
        <tr>
            <td>产品数量</td>
            <td><input type="text" name="quantity" ></td>
        </tr>
        <tr>
            <td>产品售价</td>
            <td><input type="text" name="sale_price" ></td>
        </tr>
        <tr>
            <td>产品种类</td>
            <td>
                <select name="cate" id="cate">
                    <option value="0">请选择种类</option>

                </select>
            </td>
        </tr>
        <tr>
            <td>进货时间</td>
            <td><input type="text" name="income_time" class="Wdate" onclick="WdatePicker()" > </td>
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
