<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户详情</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />

</head>

<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>超市账单管理系统</h1>
	<c:set var="loginUser" value="${loginUser }" scope="session"></c:set>
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"><c:out
					value="${loginUser.userName }"></c:out>
			</span> , 欢迎你！
		</p>
		<a href="login.html">退出</a>
	</div>
	</header>
	<!--时间-->
	<section class="publicTime"> <span id="time">2015年1月1日
		11:11 星期一</span> <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a> </section>
	<!--主体内容-->
	<section class="publicMian ">
	<div class="left">
		<h2 class="leftH2">
			<span class="span1"></span>功能列表 <span></span>
		</h2>

		<c:if test="${loginUser!=null }">
			<c:choose>
				<c:when test="${loginUser.userType eq 1 }">

					<nav>
					<ul class="list">
						<li><a href="GetBills">查看账单</a>
						</li>
						<li><a href="GetProviderServlet">查看供应商</a>
						</li>
						<li><a href="../UserServlet?action=out">注销</a>
						</li>
					</ul>
					</nav>
	</div>
	</c:when> <c:when test="${loginUser.userType eq 2}">

		<nav>
		<ul class="list">
			<li><a href="GetBills">账单管理</a>
			</li>
			<li><a href="GetProviderServlet">供应商管理</a>
			</li>
			<li><a href="userViewServlet?ac=selectAll">用户管理</a>
			</li>
			<li><a href="user/updatePassword.jsp">密码修改</a>
			</li>
			<li><a href="../UserServlet?action=out">注销</a>
			</li>
		</ul>
		</nav>
		</div>
	</c:when> <c:when test="${loginUser.userType eq 3}">

		<nav>
		<ul class="list">
			<li><a href="GetBills">账单管理</a>
			</li>
			<li><a href="GetProviderServlet">供应商管理</a>
			</li>
			<li><a href="userViewServlet?ac=selectAll">用户管理</a>
			</li>
			<li><a href="user/updatePassword.jsp">密码修改</a>
			</li>
			<li><a href="UserServlet?action=out">注销</a>
			</li>
		</ul>
		</nav>
		</div>
	</c:when> </c:choose> </c:if>

	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>用户管理页面 >> 用户信息查看页面</span>
		</div>
		<div class="providerView">
			<p>
				<strong>用户编号：</strong><span>${user.userCode}</span>
			</p>
			<p>
				<strong>用户名称：</strong><span>${user.userName}</span>
			</p>
			<p>
				<strong>用户性别：</strong><span>${user.gender}</span>
			</p>
			<p>
				<strong>出生日期：</strong><span>${user.birthday}</span>
			</p>
			<p>
				<strong>用户电话：</strong><span>${user.phone}</span>
			</p>
			<p>
				<strong>用户地址：</strong><span>${user.address}</span>
			</p>
			<p>
				<strong>用户类别：</strong><span><c:if
						test="${user.userType eq 1}">
						<th width="10%">普通用户</th>
					</c:if> <c:if test="${user.userType eq 2}">
						<th width="10%">管理员</th>
					</c:if> <c:if test="${user.userType eq 3}">
						<th width="10%">经理</th>
					</c:if> </span>
			</p>

			<a href="" onclick="history.back(-1)">返回</a>
		</div>
	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="js/time.js"></script>

</body>
</html>
