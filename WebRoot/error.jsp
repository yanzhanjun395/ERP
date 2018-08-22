<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>异常处理</title>
<link type="text/css" rel="stylesheet" href="errorcss/style.css" />

<script type="text/javascript">
	function countDown(sec, url) {

		var jump = document.getElementById("jumpTo");
		//alert(jump);
		jump.innerHTML = sec;
		if (--sec > 0) {
			setTimeout("countDown(" + sec + ",'" + url + "')", 1000);
		} else {
			//跳转
			window.location.href = url;
		}
	}
</script>
</head>

<body>
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<div class="box">
				<h4 style="text-align: center; color: red; font-size: 20px;">操作失败</h4>
				<!-- <form action="login.action"> -->
				<div class="infos">
					<!-- UserServlet?action=out -->
					<div style="text-align:center">
						您迷路了,<span id="jumpTo" style="color: red;font-size: 15px;">5</span>秒后自动跳转到欢迎页面
						<script type="text/javascript">
							countDown(5, 'UserServlet?action=out');
						</script>
					</div>
					<div style="text-align:center">
						如果浏览器没有跳转，请点击 <a href="UserServlet?action=out">返回</a>
					</div>
				</div>
				<!-- </form> -->
			</div>
		</div>
	</div>
</body>
</html>
