<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8" />
		<script language="javascript" src="jquery-1.8.0.min.js"></script>
		<link type="text/css" rel="stylesheet" href="layui-v2.5.4/layui/css/layui.css" />
		<script language="javascript" src="layui-v2.5.4/layui/layui.js"></script>
		<link type="text/css" rel="stylesheet" href="css/index.css" />
		<title></title>
	</head>
	<body>
		<div class="layui-container">
			<div class="layui-row">
				<div class="layui-col-md8 left">
					<img src="img/timg.jpg" class="left_img" />
				</div>
				<div class="layui-col-md4 right">
					<div class="layui-tab">
						<ul class="layui-tab-title">
							<li class="layui-this"><span>SIGN IN</span></li>
							<li><span>SIGN UP</span></li>
						</ul>
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<div class="img">
									<img src="img/time4.png" />
								</div>
								<div class="ul">
									<form action="" method="">
										<ul>
											<li>
												<div>USERNAME：</div>
												<input type="text" name='username' value="" />
											</li>
											<li>
												<div>PASSWORD：</div>
												<input type="text" name='password' value="" />
											</li>
											<li style="text-align: right;">
												<input type="submit" class="layui-btn layui-btn-sm myBtn" value="SUBMIT" />
											</li>
										</ul>
									</form>
								</div>
							</div>
							<div class="layui-tab-item">
				='password' value="" />
											</li>
											<li style="text-align: right;">
												<input type="submit" class="layui-btn layui-btn-sm myBtn" value="SUBMIT" />
											</li>
										</ul>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
<script type="text/javascript">
	layui.use('element', function() {
		var element = layui.element;
	});
</script>
</html>
