<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2019/8/15
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<link  href="${pageContext.request.contextPath}/css/bootstrap.min.css " rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jQuery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<body>
<div class="container-fluid">
    <%--头--%>
    <div class="row">
        <div class="col-lg-12">
            <div  class="navbar navbar-inverse"  style="margin-bottom: 0px;background-color: gray"  >
                <h1 style="color: white;">杭州大帝国电商系统</h1>
                <a href="lunBo.jsp" class="btn btn-default" target="right">显示操作界面</a>
                <a href="loginOut.jsp" class="btn btn-default" style="margin-left: 94%">退出登录</a>
            </div>
        </div>
    </div>
    <%--xia--%>
        <div class="row" style="padding: 0 ;margin-top: 5px">
            <div class="col-lg-2">
               <%--左--%>
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        产品管理
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                <div class="panel-body">
                    <a class="btn btn-block btn-danger" href="ShowAllProducts.jsp" target="right">查询所有产品</a>
                    <a class="btn btn-block btn-danger" href="ShowAllPPage.jsp" target="right" >分页查询产品</a>
                    <a class="btn btn-block btn-danger" href="Products?op=readyto" target="right">增加产品</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                       供应商管理
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
                    <a class="btn btn-block btn-danger" href="Providers?op=doShowAll" target="right">查看所有供应商</a>
                    <a class="btn btn-block btn-danger" href="Providers?op=doShowPage&currentPage=1&pageSize=3" target="right" >分页查询</a>
                    <a class="btn btn-block btn-danger" href="Providers?op=readyto" target="right">增加供应商</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        种类管理
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                <div class="panel-body">
                    <a class="btn btn-block btn-danger" href="Categorys?op=doShowAll" target="right">查询所有种类</a>
                    <a class="btn btn-block btn-danger" href="Categorys?op=doShowPage&currentPage=1&pageSize=3" target="right" >分页查询种类</a>
                    <a class="btn btn-block btn-danger" href="Categorys?op=readyto" target="right">增加种类</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingFour">
            <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                    文件管理
                </a>
            </h4>
        </div>
        <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
            <div class="panel-body">
                <a class="btn btn-block btn-danger" href="File?op=doShowAll" target="right">查看文件</a>
                <a class="btn btn-block btn-danger" href="upLoad.jsp" target="right">上传文件</a>
            </div>
        </div>
    </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingFive">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFour">
                        订单管理
                    </a>
                </h4>
            </div>
            <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
                <div class="panel-body">
                    <a class="btn btn-block btn-danger" href="Orders?op=doShowAll" target="right">订单查询</a>
                    <a class="btn btn-block btn-danger" href="addOrders.jsp" target="right">增加订单</a>
                </div>
            </div>
        </div>
    </div>
            </div>
    <div class="col-lg-10" style="padding: 0" >
        <%--you--%>
    <div>
        <iframe src="right.jsp" width="1408px" height="673px" name="right" ></iframe>
    </div>
        </div>
</div>
</div>
</body>
</html>