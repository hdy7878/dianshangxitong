<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/29
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<h2>文件上传界面</h2>
<form action="File?op=doUpFile" method="post" enctype="multipart/form-data">
    <table>
        <tr>
        <td>文件名称：</td><td><input type="text" name="fileName"/></td>
        </tr>
        </br>
        <tr>
            <td>文件描述：</td><td><textarea rows="6" cols="21" name="fileDesc"></textarea></td>
        </tr>
        </br>
        <tr>
            <td>上传文件:</td><td><input type="file" name="myFile"/> </td>
        </tr>
        </br>
        <tr>
            <td colspan="2">
                <input type="submit" value="上传文件"/>
                <input type="reset" value="重置数据"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
