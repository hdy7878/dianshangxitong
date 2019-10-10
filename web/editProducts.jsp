<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Products" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Providers" %>
<%@ page import="entity.Categorys" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/17
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jQuery-1.12.4.js"></script>
<script type="text/javascript" src="javascript/My97DatePicker/WdatePicker.js"></script>
<script>
        function cateAndPro(obj) {
            $.ajax({
                type: "post",
                url: "Products",
                data:"op=cateAndPros&pid=${pid}",
                success: function (txt) {
                    var jsonObj = JSON.parse(txt);
                    var p = jsonObj[2];
                    var providerID = p.pv.providerID;
                    var categoryID = p.cg.categoryID;
                    document.getElementById("productID").value = p.productID;
                    document.getElementById("product_name").value = p.product_name;
                    document.getElementById("income_price").value = p.income_price;
                    document.getElementById("quantity").value = p.quantity;
                    document.getElementById("sale_price").value = p.sale_price;
                    document.getElementById("income_time").value = p.income_time;
                    var list1 = jsonObj[0];
                    var pro = document.getElementById("pro");
                    for (var i = 0; i < list1.length; i++) {
                        var option = document.createElement("option");
                        option.value = list1[i].providerID;
                        option.innerHTML = list1[i].provider_name;
                        if (list1[i].providerID == providerID) {
                            option.selected = "selected";
                        }
                        pro.appendChild(option);

                    }
                    var list2 = jsonObj[1];
                    var cate = document.getElementById("cate");
                    for (var i = 0; i < list2.length; i++) {
                        var option = document.createElement("option");
                        option.value = list2[i].categoryID;
                        option.innerHTML = list2[i].category_name;
                        if (list2[i].categoryID == categoryID) {
                            option.selected = "selected";
                        }
                        cate.appendChild(option);
                    }

                }
            })
        }
        function re(obj) {
            $.ajax({
                type: "post",
                url: "Products",
                data:"op=cateAndPros&pid=${pid}",
                success: function (txt) {
                    var jsonObj = JSON.parse(txt);
                    var p = jsonObj[2];
                    var providerID = p.pv.providerID;
                    var categoryID = p.cg.categoryID;
                    document.getElementById("productID").value = p.productID;
                    document.getElementById("product_name").value = p.product_name;
                    document.getElementById("income_price").value = p.income_price;
                    document.getElementById("quantity").value = p.quantity;
                    document.getElementById("sale_price").value = p.sale_price;
                    document.getElementById("income_time").value = p.income_time;
                    var list1 = jsonObj[0];
                    var pro = document.getElementById("pro");
                    for (var i = 0; i < list1.length; i++) {
                        var option = document.createElement("option");
                        option.value = list1[i].providerID;
                        option.innerHTML = list1[i].provider_name;
                        if (list1[i].providerID == providerID) {
                            option.selected = "selected";
                        }
                        pro.appendChild(option);

                    }
                    var list2 = jsonObj[1];
                    var cate = document.getElementById("cate");
                    for (var i = 0; i < list2.length; i++) {
                        var option = document.createElement("option");
                        option.value = list2[i].categoryID;
                        option.innerHTML = list2[i].category_name;
                        if (list2[i].categoryID == categoryID) {
                            option.selected = "selected";
                        }
                        cate.appendChild(option);
                    }

                }
            })
        }
</script>

<body onload="cateAndPro(this)">
<h2>产品修改</h2>
<form action="Products?op=doEdit" method="post">
    <table>
        <input type="text" name="productID" id="productID" readonly="readonly" >
        <tr>
            <td>产品名称</td>
            <td><input type="text" name="product_name" id="product_name" onblur="checkName(${p.productID},this)" ></td>
            <td><span id="check_name"></span></td>
        </tr>
        <tr>
            <td>产品进价</td>
            <td><input type="text" name="income_price" id="income_price" /></td>
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
            <td><input type="text" name="quantity" id="quantity"></td>
        </tr>
        <tr>
            <td>产品售价</td>
            <td><input type="text" name="sale_price" id="sale_price"></td>
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
            <td><input type="text" name="income_time" id="income_time" class="Wdate" onclick="WdatePicker()" > </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确定修改"/>
                <input type="button" value="重置数据" onclick="re(this)"/>
            </td>
        </tr>

    </table>
</form>
</body>
<script type="text/javascript">

    function checkName(id,obj) {
        $.ajax({
            type:"get",
            url:"Products",
            data:{
                "op":"checkName",
                "id":id+"",
                "name":obj.value
            },
            success:function(txt){
                var c = document.getElementById("check_name");
                if(obj.value=="") {
                    c.innerHTML = "<font color='red'>产品名不能为空</font>";
                }else {
                    if (txt == "可用") {
                        c.innerHTML = "<font color='green'>产品名可以使用</font>";
                    } else if (txt == "重名") {
                        c.innerHTML = "<font color='red'>产品名已存在</font>";
                    }
                }
        }

        })
    }
</script>
</html>
