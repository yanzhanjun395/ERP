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

<title>修改用户信息</title>

<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />

<script type="text/javascript" src="JQ/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function(){
   var b=0;
   var c=0;
   var d=0;
    //日期
    $('#birthday').blur(function(){
    
    	var data="birthday="+$('#birthday').val();
    	$.ajax({
    		url:'updateServlet?up=birthday',
    		data:data,
    		datatype:'text',
    		type:'post',
    		success:function(result){
    			//alert(result);
    			if(result=="0"){
    				//alert(result);
    				$("#birthdays").html("格式输入有误，必须按照XXXX-mm-dd格式书写");
    				return false;
    			}else if(result==1){
    				$('#birthdays').hide();
    				$('#birthday1').html("输入正确");
    				b=1;
    				
    			}
    		}
    	
    	
    	});
    	
    });
    
    
    //用户电话；
   	$('#userphone').blur(function(){
    	reg=/^\d{11}$/;
    	reg2=/^\d{4}-\d{7}$/;
    	var data=$('#userphone').val();
    	if(reg.test(data)||reg2.test(data)){
    		$('#phone').hide();
    		$('#phone1').html("输入正确");
    		c=1;
    		
    	}else {
    		$('#phone1').hide();
    		$('#phone').html("输入格式有误");
    		
    	
    	}
    });
    
    
    
    $('#userAddress').blur(function(){
    	data=$('#userAddress').val();
    	if(data=""){
    		$('#dss').html("不能为空");
    	}else {
    		//$('#dss').hide();
    		$('#dss').html("输入正确");
    		d=1;
    	
    	}
    	
    });
    
    
    
    
    	
    });
    
    
    function check(){
    	var username=document.getElementById("userName").value;
    	var birthday=document.getElementById("birthday").value;
    	var userphone=document.getElementById("userphone").value;
    	var userAddress=document.getElementById("userAddress").value;
    	reg=/^\d{11}$/;
    	reg2=/^\d{4}-\d{7}$/;
    	if(birthday!=""&&userphone!=""&&userAddress!=""){
    	    if(reg.test(userphone)||reg2.test(userphone)){
    	  return true; 
    	}else{
    	 alert("所填电话格式不正确，请检查");
    	   return false;
    	}
    	}else{
    	   alert("所填数据不能为空，请检查");
    	   //window.history.back();
    	   return false;
    	}
    	
    	
    	
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
						<li><a href="userList.jsp">查看供应商</a></li>
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
			<strong>你现在所在的位置是:</strong> <span>用户管理页面 >> 用户修改页面</span>
		</div>
		<div class="providerAdd">
			<form action="updateServlet" onsubmit="return check()">
				<input type="hidden" name="upser" value="checks" />
				<!--div的class 为error是验证错误，ok是验证成功-->
				<div>
					<label for="userName">用户名称：</label> <input type="hidden" name="uid"
						value="${uu.userCode}" /> <input type="text" name="userName"
						id="userName" placeholder="${uu.userName }" /> <input
						type="hidden" name="unname" value="${uu.userName }" /> <span
						id="name"></span> <span id="name1"></span> <span id="name2"></span>
				</div>

				<div>
					<label>用户性别：</label> <select name="sex" id="sex">
						<option value="男">男</option>
						<option value="女" selected>女</option>
					</select>
				</div>
				<div>
					<label for="data">出生日期：</label> <input type="text" name="data"
						id="birthday" placeholder="2016年2月1日" /> <span id="birthdays"></span>
					<span id="birthday1"></span>
				</div>
				<div>
					<label for="userphone">用户电话：</label> <input type="text"
						name="userphone" id="userphone" placeholder="13533667897" /> <span
						id="phone"></span> <span id="phone1"></span>
				</div>
				<div>
					<label for="userAddress">用户地址：</label> <input type="text"
						name="userAddress" id="userAddress" placeholder="北京" /> <span
						id="dss"></span>
				</div>
				<div>
					<label>用户类别：</label> <input type="radio" name="userlei" value="1" />普通用户
					<input type="radio" name="userlei" value="2" />管理员 <input
						type="radio" name="userlei" value="3" checked />经理

				</div>
				<div class="providerAddBtn">
					<!--<a href="#">保存</a>-->
					<!--<a href="userList.html">返回</a>-->
					<input type="submit" value="保存" /> <input type="button" value="返回"
						onclick="history.back(-1)" />
				</div>
			</form>
		</div>

	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="js/time.js"></script>

</body>
</html>
