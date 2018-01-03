<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">  
<html>  
    <head>  
    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${path}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/bootstrap/css/my1.css" rel="stylesheet">
    <link href="${path}/assets/css/face.css" rel="stylesheet">
    <script src="${path}/bootstrap/js/jquery.js"></script>
        <script type="text/javascript">


  window.paths="${path}";

</script>
    <script src="${path}/bootstrap/js/bootstrap.min.js"></script>
    <link  rel="stylesheet" href="${path}/bootstrap-fileinput/css/fileinput.css" />
	<script  src="${path}/bootstrap-fileinput/js/fileinput.js"></script>
<!--	<script  src="${path}/bootstrap-fileinput/js/fileinput_locale_zh.js"></script>-->
	
		<script type="text/javascript" src="${path}/assets/js/face.js"></script>
    </head>  
    <body>   
	<nav class="navbar navbar-default" style="height:20px;"> 
  	<div class="container-fluid">
   		 <div class="navbar-header">
     		 <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
      		  <span class="sr-only">Toggle navigation</span>
       		  <span class="icon-bar"></span>
      		  <span class="icon-bar"></span>
      		  <span class="icon-bar"></span>
     		 </button>
     		 <a class="navbar-brand" href="#">Chenqi</a>
   		 </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">选择1 <span class="sr-only">(current)</span></a></li>
        <li><a href="#">选择2</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">下拉框 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">下拉1</a></li>
            <li><a href="#">下拉2</a></li>
            <li><a href="#">下拉3</a></li>
            <li role="separator" class="divider">分割线</li>
            <li><a href="#">下拉5</a></li>
            <li role="separator" class="divider">分割线</li>
            <li><a href="#">下拉7</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="输入Id">
        </div>
        <button type="submit" class="btn btn-default">查询</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">选择11</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">下拉框2 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">下拉1</a></li>
            <li><a href="#">下拉2</a></li>
            <li><a href="#">下拉3</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">下拉4</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="container-fluid">
	<div class="row">
    	<label class="col-md-2 control-label">图片上传:</label> 
    </div>
    <div class="row" style="">
    
    
    
            <div class="col-md-4" style="margin-left:3px; background-color:#d2dedf;">  
            	<div class="row" style="height:382px;">
            		<p class="help-block" Style="font-size:5px;">支持jpg、jpeg、png格式，大小不超过2.0M</p> 
                	<input id="file" name="file" type="file"  data-show-caption="true">  
                </div>
    		</div>  
    		<div id="tableBox" class="col-md-6" style="background-color:#d2dedf;margin-left:3px; height:382px;">
				<table id="table" class="table table-hover">
					<tr>
						<td>性别：</td><td id="sex"></td>
					</tr>
					<tr>
						<td>人种：</td><td id="person"></td>
					</tr>
					<tr>
						<td>年龄：</td><td id="age"></td>
					</tr>
					<tr>
						<td>颜值：</td><td id="beauty"></td>
					</tr>
					<tr>
						<td>是否戴眼镜：</td><td id="glass"></td>
					</tr>
				</table>
			</div>
	</div>
 </div>   
    

<header>
</header>

























    </body>  
</html>  