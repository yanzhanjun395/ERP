<%@page import="com.supermarket.until.NumberUtil"%>
<%@page import="com.supermarket.entity.providers"%>
<%@page import="com.supermarket.service.impl.ProviderServiceImpl"%>
<%@page import="com.supermarket.service.ProviderService"%>
<%@page import="com.supermarket.until.UserUtil"%>
<%@page import="com.supermarket.entity.User"%>
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

<title>供应商列表</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" language="javascript">
		function jump(){
			var regex=/^\d+$/;
			var num = document.getElementById("mypage").value;
			if(!regex.test(num)){
				alert("请输入正确的数字");
				return false;
			}else{
				window.location.href = "GetProviderServlet?page_no="+num;
			}
		}
		
		function bod(){
		 var tan=document.getElementById("tan").value;
		 //alert(tan);
		 if(tan==1){
		   $('.zhezhao').css('display', 'block');
           $('#removeProv').fadeIn();
		 }else{
		   $('.zhezhao').css('display', 'none');
           $('#removeProv').fadeOut();
		 }
		 
		}
		
	</script>

</head>

<body onload="bod()">
	<!--头部-->
	<header class="publicHeader">
	<h1>超市账单管理系统</h1>
	<%--  <%
	    	User user= UserUtil.getUser("myUser", request);
			session.setAttribute("loginUser", user);
	 %> --%> <c:set var="loginUser" value="${loginUser }" scope="session"></c:set>
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
			<li><a href="../UserServlet?action=out">注销</a>
			</li>
		</ul>
		</nav>
		</div>
	</c:when> </c:choose> </c:if>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>供应商管理页面</span>
		</div>

		<form action="GetProviderServlet" method="post">
			<div class="search">
				<span>供应商名称：</span>
				<c:choose>
					<c:when test="${loginUser.userType eq 1 }">
						<input type="text" name="proName" placeholder="请输入供应商的名称" />
						<input type="submit" value="查询" style="width: 90px;height: 30px;" />
					</c:when>
					<c:otherwise>
						<input type="text" name="proName" placeholder="请输入供应商的名称" />
						<input type="submit" value="查询" style="width: 90px;height: 30px;" />
						<a href="provider/providerAdd.jsp">添加供应商</a>
					</c:otherwise>
				</c:choose>
			</div>

		</form>
		<!--供应商操作表格-->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr class="firstTr">
				<th width="10%">供应商编码</th>
				<th width="20%">供应商名称</th>
				<th width="10%">联系人</th>
				<th width="10%">联系电话</th>
				<th width="10%">传真</th>
				<th width="10%">创建时间</th>
				<th width="30%">操作</th>
			</tr>
			<c:forEach var="provider" items="${list }">
				<tr>
					<td>${provider.proCode}</td>
					<td>${provider.proName}</td>
					<td>${provider.proContact}</td>
					<td>${provider.proPhone}</td>
					<td>${provider.proFax}</td>
					<td>${provider.createDate}</td>
					<td><c:choose>
							<c:when test="${loginUser.userType eq 1 }">
								<a href="providerServlet?proCode=${provider.proCode}"><img
									src="img/read.png" alt="查看" title="查看" />
								</a>
							</c:when>
							<c:when test="${loginUser.userType eq 2 }">
								<a href="providerServlet?proCode=${provider.proCode}"><img
									src="img/read.png" alt="查看" title="查看" />
								</a>
								<a
									href="providerServlet?update=toupdate&proCode=${provider.proCode}"><img
									src="img/xiugai.png" alt="修改" title="修改" />
								</a>
								<a
									href="providerDeleteServlet?proCode=${provider.proCode}&actions=isdele"
									class="removeProvider"><img src="img/schu.png" alt="删除"
									title="删除" />
								</a>
							</c:when>
							<c:when test="${loginUser.userType eq 3 }">
								<a href="providerServlet?proCode=${provider.proCode}"><img
									src="img/read.png" alt="查看" title="查看" />
								</a>
								<a
									href="providerServlet?update=toupdate&proCode=${provider.proCode}"><img
									src="img/xiugai.png" alt="修改" title="修改" />
								</a>
								<a
									href="providerDeleteServlet?proCode=${provider.proCode}&actions=isdele"
									class="removeProvider"><img src="img/schu.png" alt="删除"
									title="删除" />
								</a>
							</c:when>
							<%-- providerDeleteServlet?proCode=${provider.proCode}&actions=dele --%>
						</c:choose></td>
				</tr>
			</c:forEach>
		</table>
		<p align="right">
			当前页数:[${index}/${totalPage}]&nbsp; <a
				href="GetProviderServlet?page_no=${index-1}">上一页&nbsp;&nbsp;</a> <a
				href="GetProviderServlet?page_no=${index+1}">下一页&nbsp;&nbsp;</a> <a
				href="GetProviderServlet">首页</a> <a
				href="GetProviderServlet?page_no=${totalPage}">末页</a> <input
				id="mypage" type="text" size="2" /> <input type="button" value="GO"
				onclick="jump()" />
		</p>
	</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<input type="hidden" id="tan" value="${dele }" />
	<div class="zhezhao"></div>
	<div class="remove" id="removeProv">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该供应商吗？</p>
				<a href="providerDeleteServlet?proCode=${tanku }" id="yes">确定</a> <a
					href="GetProviderServlet" id="no">取消</a>
			</div>
		</div>
	</div>


	<footer class="footer"> 版权归北大青鸟 </footer>

	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
	<script src="js/time.js"></script>

</body>
</html>
