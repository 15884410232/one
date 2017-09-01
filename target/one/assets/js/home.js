var system = {};
var p = navigator.platform;
system.win = p.indexOf("Win") == 0;
system.mac = p.indexOf("Mac") == 0;
system.x11 = (p == "X11") || (p.indexOf("Linux") == 0);
$("document").ready(function() {
	
	$.ajax({
		url : "http://47.94.164.74/one/redis",
		Type : "GET",
		dataType:"json",
		success: function(res){
			$(".main").html(res);
		},
		
	});
	
	
	$("#login").click(function(){
		var html="<form action='/one/redis'>" +
				"name<input type='text' name='name'></input>" +
				"<input type='submit' value='login'></input></form>"
				$(".main").html(html);
	})
	
	
//	if (system.win || system.mac || system.xll) {
//		window.location.href = "http://www.baidu.com/";
//	} else {
//		window.location.href = "http://www.sina.com.cn/";
//	}
//	document.write("<p>我的第一段 JavaScript</p>");
//	txt = "            "+navigator.appCodeName;
//	txt+= "            " + navigator.appName;
//	txt+= "            " + navigator.appVersion;
//	txt+= "            " + navigator.cookieEnabled;
//	txt+= "            " + navigator.platform ;
//	txt+= "            " + navigator.userAgent ;
//	txt+= "            " + navigator.systemLanguage;
//	alert(txt);
})


$("#login").click(function(){
	var html="<from>" +
			"name<input type='text' name='name'></input>" +
			"<button type='submit' value='login'></button</from>"
			$("#main").html(html);
})










