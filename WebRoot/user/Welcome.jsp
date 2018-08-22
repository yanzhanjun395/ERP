<%@page import="com.supermarket.service.impl.UserServiceImpl"%>
<%@page import="com.supermarket.service.UserService"%>
<%@page import="com.supermarket.entity.User"%>
<%@page import="com.supermarket.until.UtilCookie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>超市欢迎页面</title>
<link rel="stylesheet" href="../css/public.css"/>
<link rel="stylesheet" href="../css/style.css"/>
<style type="text/css">
.text {
	float: right;
}
</style>
</head>
<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>超市账单管理系统</h1>
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2015年1月1日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<section class="publicMian"> <%-- <c:set var="isLogin" value="${empty loginUser}" scope="session"/> --%>
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>
		<c:set var="loginUser" value="${loginUser }" scope="session"></c:set>
<c:if test="${loginUser!=null }">
	<c:choose>
		<c:when test="${loginUser.userType eq 1 }">

					<nav>
					<ul class="list">
						<li><a href="../GetBills">查看账单</a></li>
						<li><a href="../GetProviderServlet">查看供应商</a></li>
						<li><a href="../UserServlet?action=out">注销</a></li>
					</ul>
					</nav>
	         </div>
	  </c:when> 
	<c:when test="${loginUser.userType eq 2}">

		<nav>
		<ul class="list">
			<li><a href="../GetBills">账单管理</a></li>
			<li><a href="../GetProviderServlet">供应商管理</a></li>
			<li><a href="../userViewServlet?ac=selectAll">用户管理</a></li>
			<li><a href="updatePassword.jsp">密码修改</a></li>
			<li><a href="../UserServlet?action=out">注销</a></li>
		</ul>
		</nav>
		</div>
	</c:when> 
	<c:when test="${loginUser.userType eq 3}">
		<nav>
		<ul class="list">
			<li><a href="../GetBills">账单管理</a></li>
			<li><a href="../GetProviderServlet">供应商管理</a></li>
			<li><a href="../userViewServlet?ac=selectAll">用户管理</a></li>
			<li><a href="updatePassword.jsp">密码修改</a></li>
			<li><a href="../UserServlet?action=out">注销</a></li>
		</ul>
		</nav>
		</div>
	</c:when> 
   </c:choose> 
  </c:if>
	<div class="right">
		<img class="wColck" src="../img/clock.jpg" alt="" />
		<div class="wFont">
			<h2>My baby！${loginUser.userName }！</h2>
			<p>欢迎来到超市账单管理系统!</p>
		</div>
	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="../js/time.js"></script>
</body>
</html>
