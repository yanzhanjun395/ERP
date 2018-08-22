<%@page import="com.supermarket.until.UtilCookie"%>
<%@page import="com.supermarket.service.impl.UserServiceImpl"%>
<%@page import="com.supermarket.service.UserService"%>
<%@page import="com.supermarket.entity.User"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>账单列表显示</title>
<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />

<script type="text/javascript">
     	function myPage(){
		var mypage= document.getElementById("mypage").value;
		var id=document.getElementById("mid").value;
		var proname=document.getElementById("proname").value;
		var tigong=document.getElementById("tigong").value;
		var fukuan=document.getElementById("fukuan").value;
		window.location.href="GetBills?page_no="+mypage+"&nid="+id+
		"&proname="+proname+"&tigong="+tigong+"&fukuan="+fukuan;
		
	}
     	
     </script>
</head>

<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>超市账单管理系统</h1>
	<c:set var="loginUser" value="${loginUser }" scope="session"></c:set>
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"> <c:out
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
						<li><a href="UserServlet?action=out">注销</a>
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
			<li><a href="UserServlet?action=out">注销</a>
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
			<strong>你现在所在的位置是:</strong> <span>账单管理页面</span>
		</div>
		<div class="search">
			<form action="GetBills" method="post">
				<span>商品名称：</span> <input type="text" id="proname" name="proname"
					value="${proname}" placeholder="请输入商品的名称" /> <span>供应商：</span> <select
					name="tigong" id="tigong">
					<option value="">--请选择--</option>
					<c:forEach var="comment1" items="${list1 }">
						<option value="${comment1.proCode }"
							<c:if test="${tigong eq comment1.proCode}">selected="selected"</c:if>>${comment1.proName}</option>
					</c:forEach>
				</select> <span>是否付款：</span> <select name="fukuan" id="fukua">
					<option value="">--请选择--</option>
					<option value="1"
						<c:if test="${'1' eq fukuan}">selected="selected"</c:if>>已付款</option>
					<option value="0"
						<c:if test="${'0' eq fukuan}">selected="selected"</c:if>>未付款</option>
				</select>

				<c:choose>
					<c:when test="${loginUser.userType eq 1 }">
						<input type="submit" value="查询" style="width: 110px;height: 30px" />
					</c:when>
					<c:otherwise>
						<input type="submit" value="查询" style="width: 110px;height: 30px" />
						<a href="GetBillCode">添加订单</a>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
		<c:if test="${empty list ||list.size() eq 0 }">
			<p>暂时没有数据</p>
		</c:if>
		<!--账单表格 样式和供应商公用-->
		<c:if test="${!empty list && list.size() gt 0}">
			<table class="providerTable" cellpadding="0" cellspacing="0">
				<tr class="firstTr">
					<th width="10%">账单编码</th>
					<th width="20%">商品名称</th>
					<th width="10%">供应商</th>
					<th width="10%">账单金额</th>
					<th width="10%">是否付款</th>
					<th width="10%">创建时间</th>
					<th width="30%">操作</th>
				</tr>
				<c:forEach var="comment" items="${list }">
					<tr>
						<td>${comment.billCode }</td>
						<td>${comment.productName }</td>
						<td>${comment.proName }</td>
						<td>${comment.totalPrice }</td>
						<td>${comment.pname }</td>
						<td>${comment.creationDate }</td>
						<td><c:choose>
								<c:when test="${loginUser.userType eq 1 }">
									<a
										href="GetBillServlet?billId=${comment.billId}
                        &fukuan=${fukuan}&tigong=${tigong}&proname=${proname}"><img
										src="img/read.png" alt="查看" title="查看" />
									</a>
								</c:when>
								<c:when test="${loginUser.userType eq 2 }">
									<a
										href="GetBillServlet?billId=${comment.billId}
                        &fukuan=${fukuan}&tigong=${tigong}&proname=${proname}"><img
										src="img/read.png" alt="查看" title="查看" />
									</a>
									<a href="bill/billUpdate.jsp?billId=${comment.billId}"><img
										src="img/xiugai.png" alt="修改" title="修改" />
									</a>
									<a
										href="GetIsPaymentServlet?billId=${comment.billId}&billCode=${comment.billCode }&billnum=123&nid=${id }&page_no=${index}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
										class="removeBill"> <img src="img/schu.png" alt="删除"
										title="删除" />
									</a>
								</c:when>

								<c:otherwise>
									<a
										href="GetBillServlet?billId=${comment.billId}
                        &fukuan=${fukuan}&tigong=${tigong}&proname=${proname}"><img
										src="img/read.png" alt="查看" title="查看" />
									</a>
									<a href="bill/billUpdate.jsp?billId=${comment.billId}"><img
										src="img/xiugai.png" alt="修改" title="修改" />
									</a>
									<a
										href="GetIsPaymentServlet?billId=${comment.billId}&billCode=${comment.billCode }&billnum=123&nid=${id }&page_no=${index}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
										class="removeBill"> <img src="img/schu.png" alt="删除"
										title="删除" />
									</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>
			<p align="right">
				当前页数:[${index}/${totalpage}]&nbsp; <a
					href="GetBills?page_no=${1}&nid=${id}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}">首页</a>
				<a
					href="GetBills?page_no=${index-1}&nid=${id}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}">上一页&nbsp;&nbsp;
				</a> <a
					href="GetBills?nid=${id }&page_no=${index+1}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}">下一页&nbsp;&nbsp;
				</a> <a
					href="GetBills?nid=${id }&page_no=${totalpage}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}">末页&nbsp;&nbsp;
				</a> <input id="mypage" type="text" size="3" /> 页 <input id="mid"
					type="hidden" value="${id}" /> <input id="proname" type="hidden"
					value="${proname}" /> <input id="tigong" type="hidden"
					value="${tigong}" /> <input id="fukuan" type="hidden"
					value="${fukuan}" /> <input type="button" value="我跳"
					onclick="myPage()" />
			</p>
		</c:if>
	</div>
	</section>

	<!--点击删除按钮后弹出的页面-->
	<div class="zhezhao"></div>

	<input type="hidden" id="payments" value="${billnum}" />
	<div class="remove" id="removeBi">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>你确定要删除该订单吗？</p>
				<a
					href="GetIsPaymentServlet?billId=${billId}&billnum1=125&billCode=${billCode}&nid=${id }&page_no=${index}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
					id="yes">确定</a> <a href="#" id="no" onclick="history.back(-1)">取消</a>
			</div>
		</div>
	</div>


	<c:if test="${bill.isPayment eq 1 && row eq 1  }">
		<input type="hidden" id="payment" value="${billnum1}" />
		<input type="hidden" id="payment1" value="${id }" />
		<input type="hidden" id="payment2" value="${index}" />
		<input type="hidden" id="payment3" value="${proname}" />
		<input type="hidden" id="payment4" value="${tigong}" />
		<input type="hidden" id="payment5" value="${fukuan}" />

		<input type="hidden" id="billremove" value="${billCode}" />
	</c:if>
	<input type="hidden" id="paymentss" value="${billnum1}" />
	<div class="remove" id="removeBi1">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<c:if test="${bill.isPayment eq 0 && row eq 1  }">
					<p>账单未付款，是否删除</p>
					<a
						href="DeleteBillServlet?billId=${billId}&billnum2=126&billCode=${billCode}&nid=${id }&page_no=${index}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
						id="yes1">删此信息</a>
					<a href="#" id="no1" onclick="history.back(-1)">取消</a>
				</c:if>
				<c:if test="${ row gt 1 }">
					<c:if test="${ bill.isPayment eq 0  }">
						<p>账单未付款，并且这个单号的账单信息不止一条</p>
					</c:if>
					<c:if test="${ bill.isPayment eq 1 }">
						<p>账单已付款，但这个单号的账单信息不止一条</p>
					</c:if>
					<a
						href="DeleteBillServlet?billId=${billId}&billnum2=126&billCode=${billCode}"
						id="yes1">删此信息</a>
					<a href="#" id="yes3">操作此单所有信息</a>
					<a href="#" id="no1" onclick="history.back(-1)">取消</a>
				</c:if>
			</div>
		</div>
	</div>

	<div class="remove" id="removeBi4">
		<div class="removerChid">
			<h2>提示</h2>
			<div class="removeMain">
				<p>请选择操作内容</p>
				<a
					href="DeleteBillServlet?billId=${billId}&billnum2=126&billCode=${billCode}&nid=${id }&page_no=${index}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
					id="yes">删除全部</a> <a
					href="GetBills?billCode=${billCode}&nid=${id }&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
					id="show">查看详情</a> <a
					href="GetBills?billCode=${billCode}&nid=${id }&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
					id="no4" onclick="history.back(-1)">取消</a>
			</div>
		</div>
	</div>
	<c:if test="${rows gt 0 ||rowCode gt 0}">
		<input type="hidden" id="result" value="${billnum2}" />
		<div class="remove" id="removeBi2">
			<div class="removerChid">
				<h2>提示</h2>
				<div class="removeMain">
					<p>删除成功</p>
					<a
						href="GetBills?nid=${id }&page_no=${index}&proname=${proname}&tigong=${tigong}&fukuan=${fukuan}"
						id="yes3">确定</a>
				</div>
			</div>
		</div>

	</c:if>

	<footer class="footer"> 版权归北大青鸟 </footer>


	<script src="js/time.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/js.js"></script>
</body>
</html>
