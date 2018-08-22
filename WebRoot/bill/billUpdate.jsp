<%@page import="com.supermarket.service.impl.BillBizimpl"%>
<%@page import="com.supermarket.service.BillsBiz"%>
<%@page import="com.supermarket.entity.Products"%>
<%@page import="com.supermarket.entity.ShoppingBill"%>
<%@page import="com.supermarket.until.NumberUtil"%>
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

<title>订单修改</title>

<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	 $(function(){
	 	var dingdan=1;
	 	var name=1;
	 	var danwei=1;
	 	var num=1;
	 	var money=1;
	 	
	 	$("#providerId").change(function (){
	     var prod=document.getElementById("providerId");
	     if(prod.value==""||prod.value==null){
	     		$("#proId").html("订单编号不能为空");
	     	
	     	dingdan=0;
	     }else{
	     	$("#proId").html("");
	     }
	     });  
	    
	    $("#providerName").change(function (){
	     var prod=document.getElementById("providerName");
	     if(prod.value==""||prod.value==null){
	     		$("#proname").html("商品名称不能为空");
	     	//ph=1;
	     	name=0;
	     }else{
	     	$("#proname").html("");
	     }
	     }); 
	    
	    $("#pronumber").change(function (){
	   // alert("p");
	     var number=document.getElementById("pronumber");
	     texg=/^[1-9]{1,}([0-9])*\.[0-9]*$/;
	     if(texg.test(number.value)==false){
	     	
	     		$("#pronum").html("商品数量不能为空且必须大于0的整数数字");
	     	//ph=1;
	     	num=0;
	     }else{
	     	$("#pronum").html("");
	     }
    });
    
     $("#allmaney").change(function (){
	     var prod=document.getElementById("allmaney");
	      texg=/^[1-9]{1,}([0-9])*\.{0,1}\d*$/;
	     if(texg.test(prod.value)==false){
	     		$("#allmon").html("金额必须大于0且不能为空");
	     	//ph=1;
	     	money=0;
	     }else{
	     	$("#allmon").html("");
	     }
	     });  
    
             
    $("#doservi").click(function (){
   // alert("ck");
	     if(dingdan==0){
	    // alert("ck1");
	        alert("订单编号不能为空");
	        return false;
	     }else if(name==0){
			     	alert("商品名称不能为空");
			     	return false;
			     }else if(num==0){
			      alert("商品数量不能为空且必须大于0的数字");
			     	return false;
			     }else if(money==0){
			        alert("金额必须大于0且不能为空");
			     	return false;
			     }else{
			        //alert("ck2");
			     	$("form").submit();
			     }
	    
	     //return true;
	     });
	 	
	 	
	 });
	</script>

</head>

<body>
	<!--头部-->
	<header class="publicHeader">
	<h1>超市账单管理系统</h1>
	<c:set var="loginUser" value="${loginUser }" scope="session"></c:set>
	<div class="publicHeaderR">
		<p>
			<span>下午好！</span><span style="color: #fff21b"><c:out
					value="${loginUser.userName }"></c:out> </span> , 欢迎你！
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
						<li><a href="GetBills">查看账单</a></li>
						<li><a href="GetProviderServlet">查看供应商</a></li>
						<li><a href="UserServlet?action=out">注销</a></li>
					</ul>
					</nav>
	</div>
	</c:when> <c:when test="${loginUser.userType eq 2}">
		<nav>
		<ul class="list">
			<li><a href="GetBills">账单管理</a></li>
			<li><a href="GetProviderServlet">供应商管理</a></li>
			<li><a href="userViewServlet?ac=selectAll">用户管理</a></li>
			<li><a href="user/updatePassword.jsp">密码修改</a></li>
			<li><a href="UserServlet?action=out">注销</a></li>
		</ul>
		</nav>
		</div>
	</c:when> <c:when test="${loginUser.userType eq 3}">
		<nav>
		<ul class="list">
			<li><a href="GetBills">账单管理</a></li>
			<li><a href="GetProviderServlet">供应商管理</a></li>
			<li><a href="userViewServlet?ac=selectAll">用户管理</a></li>
			<li><a href="user/updatePassword.jsp">密码修改</a></li>
			<li><a href="UserServlet?action=out">注销</a></li>
		</ul>
		</nav>
		</div>
	</c:when> </c:choose> </c:if>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>账单管理页面 >> 订单修改页面</span>
		</div>

		<%
        request.setCharacterEncoding("utf-8");
        ShoppingBill spl=new ShoppingBill();
        Products pts=new Products();
        BillsBiz bbz=new BillBizimpl();
       String  bid=request.getParameter("billId");
       int id=NumberUtil.getIntNumber(bid);
        List<ShoppingBill> list=bbz.getBillsBybid(id);
        List<Products> prolist=bbz.getAllProname();
        request.setAttribute("list", list);
        request.setAttribute("prolist", prolist);
        
         %>

		<div class="providerAdd">
			<c:if test="${empty list || list.size()==0 }">
                        订单异常，请刷新后进行操作！
         </c:if>
			<c:if test="${!empty list  }">
				<c:forEach items="${list }" var="upbill">
					<form action="UpdateServilet" enctype="multipart/form-data"
						method="get">
						<!--div的class 为error是验证错误，ok是验证成功-->
						<div class="">
							<label for="providerId">订单编码：</label> <input type="text"
								name="providerId" id="providerId" placeholder
								value="${upbill.billcode }" /> <span id="proId"></span>
						</div>
						<div>
							<label for="providerName">商品名称：</label> <input type="text"
								name="providerName" id="providerName" placeholder
								value="${upbill.productName }" /> <input type="hidden"
								name="bilid" id="bilid" value="${upbill.bid }" /> <span
								id="proname"></span>
						</div>

						<div>
							<p>

								<label for="people">商品单位：</label> <select name="pid" id="pid">
									<!-- <option  >--请选择--</option> -->
									<c:forEach items="${prolist }" var="plist">
										<c:set var="nonull" value="${empty plist.proName }"></c:set>
										<c:if test="${!nonull }">
											<option value='${plist.pid}'>${plist.proName}</option>
										</c:if>
									</c:forEach>
								</select>
							</p>
						</div>

						<div>
							<label for="phone">商品数量：</label> <input type="text"
								name="pronumber" id="pronumber" value="${upbill.productCount }" />
							<span id="pronum"></span>
						</div>

						<div>
							<label for="address">总金额：</label> <input type="text"
								name="allmaney" id="allmaney" placeholder
								value="${upbill.totalPrice }" /> <span id="allmon"></span>
						</div>
						<div>

							<label>是否付款：</label>
							<c:if test="${upbill.isPayment eq 0 }">
								<input type="radio" id="fu" name="zhifu" checked value="0" />未付款
                    <input type="radio" id="fu" name="zhifu" value="1" />已付款 
                    </c:if>
							<c:if test="${upbill.isPayment eq 1 }">
								<input type="radio" id="fu" name="zhifu" value="0" />未付款
                    <input type="radio" id="fu" name="zhifu" checked
									value="1" />已付款 
                    </c:if>


						</div>

						<div class="providerAddBtn">
							<input type="button" id="doservi" value="保存" /><input
								type="button" value="返回" onclick="history.back(-1)" />
						</div>
					</form>
				</c:forEach>
			</c:if>
		</div>

	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="js/time.js"></script>

</body>
</html>
