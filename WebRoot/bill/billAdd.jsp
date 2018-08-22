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

<title>添加订单</title>
<script src="js/jquery.js"></script>
<script src="js/billAdd.js"></script>

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
					value="${loginUser.userName }"></c:out> , 欢迎你！
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
						<li><a href="userList.jsp">查看供应商</a>
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
			<li><a href="../provider/providerList.jsp">供应商管理</a>
			</li>
			<li><a href="userList.jsp">用户管理</a>
			</li>
			<li><a href="updatePassword.jsp">密码修改</a>
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
			<li><a href="../provider/providerList.jsp">供应商管理</a>
			</li>
			<li><a href="userList.jsp">用户管理</a>
			</li>
			<li><a href="updatePassword.jsp">密码修改</a>
			</li>
			<li><a href="../UserServlet?action=out">注销</a>
			</li>
		</ul>
		</nav>
		</div>
	</c:when> </c:choose> </c:if>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>账单管理页面 >> 订单添加页面</span>
		</div>
		<c:if test="${empty num ||num eq '0'||num eq '2'}">
			<div class="providerAdd">
				<form action="AddBillServlet" method="get" onsubmit="return check()">
					<!--div的class 为error是验证错误，ok是验证成功-->
					<input type="hidden" name="name" value="${loginUser.userName }" />
					<div class="">
						<label for="billId">订单编码：</label> <input type="hidden"
							name="billCode" value="${numName}" /> <input type="text"
							name="billCode" id="billCode" value="${numName}" required
							disabled="disabled" />
						<c:if test="${empty num ||num eq '0'}">
							<span>*订单编码由系统自动生成</span>
						</c:if>
						<c:if test="${num eq '2'}">
							<span>*同一订单，订单编码不能改变</span>
						</c:if>
					</div>
					<div>
						<label for="billName">商品名称：</label> <input type="text"
							name="billName" id="billName" required /> <span>*请输入商品名称</span>
					</div>
					<div>
						<label for="billCom">商品单位：</label> <input type="text"
							name="billCom" id="billCom" required /> <span>*请输入商品单位</span>

					</div>
					<div>
						<label for="billNum">商品数量：</label> <input type="text"
							name="billNum" id="billNum" required /> <input type="hidden"
							name="billNums" id="billNums" value="123" required /> <span>*请输入大于0的正自然数，小数点后保留2位</span>
					</div>
					<div>
						<label for="money">总金额：</label> <input type="text" name="money"
							id="money" required /> <input type="hidden" name="moneys"
							id="moneys" value="123" required /> <span>*请输入大于0的正自然数，小数点后保留2位</span>

					</div>
					<div>
						<label>供应商：</label>

						<c:if test="${empty supplier}">
							<select name="supplier" id="supplier">
								<option value="">--请选择相应的提供商--</option>
								<c:forEach var="comment" items="${list}">
									<option value="${comment.proCode }">${comment.proName}</option>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${!empty supplier}">
							<input type="hidden" name="supplier" id="supplier"
								value="${supplier}" />
							<input type="text" name="suppliers" id="suppliers"
								value="${prname}" disabled="disabled" />
						</c:if>
						<c:if test="${empty num ||num eq '0'}">
							<span>*请选择供应商</span>
						</c:if>
						<c:if test="${num eq '2'}">
							<span>*同一订单，供应商不能改变</span>
						</c:if>
					</div>
					<div>
						<label>是否付款：</label>
						<c:if test="${num eq 2}">
							<c:if test="${zhifu eq 0}">
								<input type="hidden" name="zhifu" value="0" />
								<input type="radio" name="zhifu" checked value="0"
									disabled="disabled" />未付款
                    <input type="radio" name="zhifu" value="1"
									disabled="disabled" />已付款
                    </c:if>
							<c:if test="${zhifu eq 1}">
								<input type="hidden" name="zhifu" value="1" />
								<input type="radio" name="zhifu" value="0" disabled="disabled" />未付款
                    <input type="radio" name="zhifu" checked value="1"
									disabled="disabled" />已付款
                    </c:if>
						</c:if>
						<c:if test="${empty num ||num eq '0'}">
							<input type="radio" name="zhifu" checked value="0" />未付款
                    <input type="radio" name="zhifu" value="1" />已付款
                    </c:if>
						<c:if test="${num eq '2'}">
							<span>*同一订单，是否付款不能改变</span>
						</c:if>

					</div>
					<div class="providerAddBtn">
						<!--<a href="#">保存</a>-->
						<!--<a href="billList.html">返回</a>-->
						<input type="submit" value="保存" style="width: 100px;height: 40px" />
						<input type="reset" value="返回" style="width: 100px;height: 40px"
							onclick="history.back(-1)" />
					</div>
				</form>
			</div>
		</c:if>
		<c:if test="${num eq 1}">
			<input type="hidden" name="num" id="num" value="${num}" />
			<div class="zhezhao"></div>
			<div class="remove" id="removeBi">
				<div class="removerChid">
					<h2>提示</h2>
					<div class="removeMain">
						<p>添加成功，是否在同一单上添加别的货物</p>
						<a
							href="GetBillCode?num=2&numName=${billCode1}&money=${money}&supplier=${supplier}&zhifu=${zhifu}"
							id="yes">确定</a> <a href="GetBills" id="no">取消</a>
					</div>
				</div>
			</div>
		</c:if>
	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="js/time.js"></script>

</body>
</html>
