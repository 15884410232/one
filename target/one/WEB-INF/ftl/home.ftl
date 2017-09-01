<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${path}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/bootstrap/css/my1.css" rel="stylesheet">
<link href="${path}/assets/css/home.css" rel="stylesheet">
<script src="${path}/bootstrap/js/jquery.js"></script>
<script src="${path}/bootstrap/js/bootstrap.min.js"></script>
<script src="${path}/assets/js/home.js"></script>
<script src="${path}/assets/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<div class="back">
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<a href="www.baidu.com">baidu</a> <a href="47.94.164.74/one/redis">redis</a>
					</div>
					<div class="col-md-2 col-md-offset-6">
						<a id="login" type="button">登录</a> <a href="#">注册</a>
					</div>

				</div>
			</div>


		</div>
		<div class="main">
			<form method="post" class="form-horizontal"
				action="/one/webuploader" enctype="multipart/form-data">
				<div class="form-group">
					<label class="col-sm-3">上传</label> <input type="file" name="file">
					</input>
				</div>
				<input type="submit"></input>
			</form>
		</div>
	</div>

</body>
</html>
