<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/24
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>种类增加</h2>
<form action="Categorys?op=doAdd" method="post">
    <table>
        <tr>
            <td>种类名称</td>
            <td><input type="text" name="category_name" onblur="checkName(this)" ></td>
            <td><span id="c_name"></span></td>

        </tr>
        <tr>
            <td>种类介绍</td>
            <td><input type="text" name="category_desc"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="确定增加"/>
                <input type="reset" value="重置数据"/>
            </td>
        </tr>
    </table>
</form>
<script>
    var xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    function checkName(obj) {
        var cate_name = obj.value;

        xmlhttp.open("GET", "Categorys?op=checkName&category_name="+cate_name, true);

        xmlhttp.onreadystatechange=function () {
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
                var txt=xmlhttp.responseText;
                var c=document.getElementById("c_name");
                if(cate_name==""){
                    c.innerHTML="<font color='red'>种类名字不能为空</font>";
                }else {
                    if (txt == "true") {
                        c.innerHTML = "<font color='green'>种类名字可以使用</font>";
                    } else {
                        c.innerHTML = "<font color='red'>种类名字已存在</font>";
                    }
                }
            }
        }
        xmlhttp.send();
    }
</script>
</body>
</html>
