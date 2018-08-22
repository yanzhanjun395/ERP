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

<title>用户列表</title>
<script src="js/jquery.js"></script>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript">
    function check(){
      var tan=document.getElementById("tan").value;
      //alert(tan);
      if(tan==12){
        $('.zhezhao').css('display', 'block');
        $('#removeUse').fadeIn();
      }
      }
    </script>

</head>

<body onload="check()">

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
		<a href="UserServlet?action=out">退出</a>
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
			<li><a href="userViewServlet?ac=selectAll"">用户管理</a>
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
			<li><a href="userViewServlet?ac=selectAll"">用户管理</a>
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
			<strong>你现在所在的位置是:</strong> <span>用户管理页面</span>
		</div>
		<div class="search">
			<c:choose>
				<c:when test="${loginUser.userType eq 1 }">
					<form action="userViewServlet" method="get" style="height: 5px;">
						<span>用户名：</span> <input type="hidden" name="ac" value="selectAll" />
						<input type="text" name="username" placeholder="请输入用户名" /> <input
							type="submit" value="查询" style="width: 100px;height: 35px;" />
					</form>
				</c:when>
				<c:otherwise>
					<form action="userViewServlet?ac=selectAll" method="get"
						style="height: 5px;">
						<span>用户名：</span> <input type="hidden" name="ac" value="selectAll" />
						<input type="text" name="username" placeholder="请输入用户名" /> <input
							type="submit" value="查询" style="width: 100px;height: 35px;" />
					</form>
					<a href="addCodeServlet">添加用户</a>
				</c:otherwise>
			</c:choose>

		</div>
		<!--用户-->
		<table class="providerTable" cellpadding="0" cellspacing="0">
			<tr class="firstTr">
				<th width="10%">用户编码</th>
				<th width="20%">用户名称</th>
				<th width="10%">性别</th>
				<th width="10%">年龄</th>
				<th width="10%">电话</th>
				<th width="10%">用户类型</th>
				<th width="30%">操作</th>
			</tr>
			<c:if test="${list.size() gt 0 }">
				<c:forEach var="user" items="${list}">
					<tr>
						<th width="10%">${user.userCode }</th>
						<th width="20%">${user.userName }</th>
						<th width="10%">${user.gender }</th>
						<th width="10%">${user.age }</th>
						<th width="10%">${user.phone }</th>
						<c:if test="${user.userType eq 1}">
							<th width="10%">普通用户</th>
						</c:if>
						<c:if test="${user.userType eq 2}">
							<th width="10%">管理员</th>
						</c:if>
						<c:if test="${user.userType eq 3}">
							<th width="10%">经理</th>
						</c:if>
						<td><c:choose>
								<c:when test="${loginUser.userType eq 1 }">
									<a href="userViewServlet?ac=select&sel=${user.userName }"><img
										src="img/read.png" alt="查看" title="查看" />
									</a>
								</c:when>
								<c:when test="${loginUser.userType eq 2 }">
									<a href="userViewServlet?ac=select&sel=${user.userName }"><img
										src="img/read.png" alt="查看" title="查看" />
									</a>
									<a href="Cidservlet?name=${user.userName }"><img
										src="img/xiugai.png" alt="修改" title="修改" />
									</a>
									<c:if test="${user.userType eq 1}">
										<a href="userViewServlet?tan=tankuang&remove=${user.userName }"
											class="removeUser"><img src="img/schu.png" alt="删除"
											title="删除" />
										</a>
									</c:if>
								</c:when>

								<c:otherwise>
									<a href="userViewServlet?ac=select&sel=${user.userName }"><img
										src="img/read.png" alt="查看" title="查看" />
									</a>
									<a href="Cidservlet?name=${user.userName }"><img
										src="img/xiugai.png" alt="修改" title="修改" />
									</a>
                                   
                                   <c:if test="${user.userType eq 1 ||user.userType eq 2}">
	                                    <a href="userViewServlet?tan=tankuang&remove=${user.userName }"
											class="removeUser"> <img src="img/schu.png"
											id="removeUser" alt="删除" title="删除" />
										</a>
                                   </c:if>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty list} ">
				<span>当前没有用户；</span>
			</c:if>

		</table>

		<!-- 翻页 -->
		<div style="float: right;">
			<div class="page-spliter">
				<!-- <a href="#">&lt;</a> -->
				<a href="userViewServlet?ac=selectAll">首页</a> <a
					href="userViewServlet?page_no=${pageIndex-1 }&ac=selectAll">上一页</a>
				<!-- <span class="current">1</span>
				<a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <span>...</span> -->
				<a href="userViewServlet?page_no=${pageIndex+1 }&ac=selectAll">下一页</a>
				<a href="userViewServlet?page_no=${totalPage }&ac=selectAll">尾页</a>
				<!-- <a href="#">&gt;</a> -->
			</div>
		</div>
	</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<input type="hidden" id="tan" value="${tan }" />
	<div class="zhezhao"></div>
	<div class="remove" id="removeUse">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该用户吗？</p>
				<a href="userViewServlet?ac=del&remove=${rename }" id="yes">确定</a> <a
					href="#" onclick="history.back(-1)" id="no">取消</a>
			</div>
		</div>
	</div>

	<footer class="footer"> 版权归北大青鸟 </footer>

	<script src="js/js.js"></script>
	<script src="js/time.js"></script>


</body>
</html>
