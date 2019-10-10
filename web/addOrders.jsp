
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/23
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery-1.12.4.js"></script>
<body>
<form id="myform" action="Orders?op=doAdd" method="post">
    订单编号：<input type="text" id="orderID" name="orderID" readonly="readonly" size="35"/>&nbsp;
    下单日期：<input type="text" name="order_daate" id="order_date" class="Wdate" onclick="WdatePicker()">
    <select name="customerID" id="customerID">
        <option value="0">选择客户</option>
    </select>
    <select name="empID" id="empID">
        <option value="0">选择员工</option>
    </select>
    </br>
    </br>
    <table border="1px solid" cellpadding="0px" cellspacing="0px" width="80%" style="text-align: center">
        <tr>
            <td>产品名称</td>
            <td><b>数量</b></td>
            <td>是否折扣</td>
            <td>操作</td>
        </tr>


        <tr>
            <td>

                <select name="productID" id="productID">
                    <option value="0">产品选择</option>
                </select>

            </td>
            <td><input name="quantity" type="number"></td>
            <td>

                <select name="discount">
                    <option value="1">不打折</option>
                    <option value="0.9">九折</option>
                    <option value="0.8">八折</option>
                    <option value="0.7">七折</option>
                </select>

            </td>
            <td><a href="#">删除</a></td>
        </tr>
        <tr>
            <td colspan="6">
                <center>
                <a href="#">增加数据</a>
                <a href="#">提交订单</a>
                </center>
            </td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
$(function () {
    $.ajax({
        type:"post",
        url:"Orders",
        data:"op=readyto",
        dataType:"json",
        success:function(arr){
            $("#orderID").val(arr[0]);
            var cusList=arr[1];
            for(var i=0;i<cusList.length;i++){
                $("#customerID").append($("<option value='"+cusList[i].customerID+"'>"+cusList[i].customer_name+"</option>"));
            }
            var empList=arr[2];
            for(var i=0;i<empList.length;i++){
                $("#empID").append($("<option value='"+empList[i].empID+"'>"+empList[i].emp_name+"</option>"));
            }
            var pList=arr[3];
            for(var i=0;i<pList.length;i++){
                $("#productID").append($("<option value='"+pList[i].productID+"'>"+pList[i].product_name+"</option>"));
            }
        }

    })

})
$(document).click(function (e) {
    var $obj=$(e.target);
    var op=$obj.html();
    if("增加数据"==op){
        $("tr:eq(1)").clone().insertBefore($("tr:last"));
    }else if("删除"==op){
        if($("tr").length>3){
            $obj.parent().parent().remove();
        }
    }else if("提交订单"==op){
       $("#myform").submit();
    }
})
</script>
</html>
