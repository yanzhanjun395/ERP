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

<title>修改供应商信息</title>

<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
    $(function (){
        var ph=1;
        var pe=1;
        var proname=1;
        var adss=1;
	    $("#providerName").blur(function (){
	     var prod=document.getElementById("providerName");
	     if(prod.value==""||prod.value==null){
	     		$("#pro").html("供应商名称不能为空");
	     	//ph=1;
	     }else{
	     	$("#pro").html("");
	     	proname=0;
	     }
	     });  
	    
	    
	    
	    $("#phone").blur(function (){
	    //alert("p");
	     var phone=document.getElementById("phone");
	     //var tel=document.getElementById("tel");
	     texg=/^\d{11}$/;
	     texg2=/^\d{3,4}-\d{7}$/;
	     if(texg.test(phone.value)==false&&texg2.test(phone.value)==false){
	     	if(phone.value==""){
	     		$("#tel").html("电话不能为空");
	     	}else{
	     		$("#tel").html("电话格式输入有误");
	     	}
	     	//ph=1;
	     }else{
	     	$("#tel").html("");
	     	ph=0;
	     }
    });
    
     $("#people").blur(function (){
	     var prod=document.getElementById("people");
	     alert
	     if(prod.value==""||prod.value==null){
	     		$("#lian").html("联系人不能为空");
	     	//ph=1;
	     }else{
	     	$("#lian").html("");
	     	pe=0;
	     }
	     });  
    
    $("#address").blur(function (){
	     var prod=document.getElementById("address");
	     if(prod.value==""||prod.value==null){
	     		$("#adres").html("联系地址不能为空");
	     	//ph=1;
	     }else{
	     	$("#adres").html("");
	     	adss=0;
	     }
	     });  
             
    $("#sub").click(function (){
    // alert("ck");
	     if(proname==1){
	    // alert("ck1");
	        alert("供应商名称不能为空");
	        return false;
	     }else if(pe==1){
			     	alert("联系人不能为空");
			     	return false;
			     }else if(ph==1){
			     	alert("电话格式不正确");
			     	return false;
			     }else if(adss==1){
			      alert("联系地址不能为空");
			     	return false;
			     }else{
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
						<li><a href="GetBills">查看账单</a></li>
						<li><a href="GetProviderServlet">查看供应商</a></li>
						<li><a href="../UserServlet?action=out">注销</a></li>
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
			<li><a href="../UserServlet?action=out">注销</a></li>
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
			<li><a href="../UserServlet?action=out">注销</a></li>
		</ul>
		</nav>
		</div>
	</c:when> </c:choose> </c:if>
	<div class="right">
		<div class="location">
			<strong>你现在所在的位置是:</strong> <span>供应商管理页面 >> 供应商修改页</span>
		</div>
		<div class="providerAdd">
			<form action="providerUpdateServlet" id="myform" method="post">
				<!--div的class 为error是验证错误，ok是验证成功-->
				<div class="">
					<label for="providerId">供应商编码：</label> <input type="text"
						name="providerId" id="providerId" readonly="readonly" placeholder
						value="${provider.proCode }" /> <span>*</span>
				</div>
				<div>
					<label for="providerName">供应商名称：</label> <input type="text"
						name="providerName" id="providerName"
						placeholder="${provider.proName }" /> <span id="pro"></span>
				</div>
				<div>
					<label for="people">联系人：</label> <input type="text" name="people"
						id="people" placeholder="${provider.proContact }" /> <span
						id="lian"></span>

				</div>
				<div>
					<label for="phone">联系电话：</label> <input type="text" name="phone"
						id="phone" placeholder="${provider.proPhone }" /> <span id="tel"></span>
				</div>
				<div>
					<label for="address">联系地址：</label> <input type="text"
						name="address" id="address" placeholder="${provider.proAddress }" />
					<span id="adres"></span>

				</div>
				<div>
					<label for="fax">传真：</label> <input type="text" name="fax" id="fax"
						placeholder="${provider.proFax }" /> <span id="fa"></span>

				</div>
				<div>
					<label for="describe">描述：</label> <input type="text"
						name="describe" id="describe" placeholder="${provider.proDesc }" />
					<span id="desc"></span>

				</div>
				<div class="providerAddBtn">
					<!--<a href="#">保存</a>-->
					<!--<a href="providerList.html">返回</a>-->
					<input type="button" value="保存" id="sub" /> <input type="button"
						value="返回" onclick="history.back(-1)" />
				</div>
			</form>
		</div>

	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="js/time.js"></script>

</body>
</html>
