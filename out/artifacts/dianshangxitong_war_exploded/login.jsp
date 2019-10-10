<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/14
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style>
  body {padding: 40px;padding-top:200px;background:url("img/img2.jpg") repeat center;}
  div {text-align: center;}
  input {margin: 10px;padding: 10px;}
  .layui-input{width: 400px;display: inline-block;}
</style>
<%--<embed src="css/1.mp3"  hidden="true"  autostart >
</embed>--%>
<script>
  if(top.location!=self.location){
    top.location='login.jsp';
  }

  function check(myForm){
    if(myForm.username.value==''){
      alert('用户名不能为空！');
      myForm.username.focus();
      return false;
    }
    if(myForm.password.value==''){
      alert('密码不能为空！');
      myForm.password.focus();
      return false;
    }else {
      return true;
    }
  }


</script>

<body>
<form action="ser" >
<center><p style=" font-size: 50px; color: darksalmon;" >杭州大帝国电商系统</p></center>
<div >
  <input type="text" class="layui-input" name="username" placeholder="请输入用户名">
</div>
<div >
  <input type="password" class="layui-input" name="password" placeholder="请输入密码">
</div>
  <div>
    <input type="radio" name="time" value="day"/>一天
    <input type="radio" name="time" value="week"/>一周
    <input type="radio" name="time" value="month"/>一个月
  </div>
<div>

  <input type="submit" class="btn btn-success btn-lg" value="管理员登录">

</div>

</form>
<!-- 模态框（Modal） -->
<center><button class="btn btn-danger btn-lg" data-toggle="modal" data-target="#myModal">
  注册
</button></center>
<div>
  <span style="font-size: 30px; color: white">在线人数：${onLineNum}</span>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="Regist?op=doAdd" method="post" name="myForm" onsubmit="return check(this)">
      <div class="modal-body">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
          &times;
        </button>
        <span style="font-size: 30px;color: black ">注册页面</span>
        <h4 class="modal-title" id="myModalLabel">
          请输入要注册的用户名</br>
          <input type="text"  class="form-control" align="center"  name="username" />
        </h4>
      </div>
      <div class="modal-body">
        请输入要输入的密码</br>
        <input type="password"  class="form-control"  name="password" />
      </div>
      <div class="modal-footer form-inline" >
        <button type="button" class="btn btn-danger btn-lg" data-dismiss="modal">关闭
        </button>

        <button  type="submit"  class="btn btn-success btn-lg">注册</button>

      </div>
      </form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal -->
</div>
</body>
</html>

