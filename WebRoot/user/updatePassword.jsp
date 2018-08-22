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

<title>修改用户密码</title>

<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />

<script type="text/javascript" src="JQ/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
     $(function(){
    		var o=0;
    		var n=0;
    		var re=0;
    		//对原密码进行验证
    		$("#oldPassword").blur(function(){
    		//alert(1);
    		var data="oldpass="+$("#oldPassword").val();
    		//alert(data);
    			//提交的数据类型；
    		$.ajax({
    			url:'usServlet',
    			type:'post',
    			data:data,
    			datatype:'text',
    			success:function(result){
    			if(result==1){
    				$('#old').hide();
    				$('#oldpass').html("密码输入正确");
    				o=1;
    			
    			}else if(result==0){
    			//alert(1);
    				$('#old').hide();
    				$('#oldpass').html("您输入的密码与原密码不匹配");
    			}
    			}
    		});
    		});
    		
    		
    		
    		$("#newPassword").change(function(){
         	var old="oldpass="+$("#oldPassword").val();
         	var data1 = $("#newPassword").val();
    		var data=old+"&newpass="+$("#newPassword").val();
    			//提交的数据类型；
    		/* alert(old);
    		alert(data); */
    		var reg=/^\w{5,13}$/;
    		if(reg.test(data1)){
    		//alert(3);
    		$.ajax({
    			url:'passServlet',
    			type:'post',
    			data:data,
    			datatype:'text',
    			success:function(result){
    			//alert(4);
    				if(result==1){
    				$('#newpass').hide();
    				$('#pass').html("新密码不能与原密码相同");
    				}else{
    				$('#newpass').hide();
    				$('#pass').html("输入正确");
    					n=1;
    				}
    			
    			} 
    	
    		});
             
             } else{
             	$('#newpass').hide();
             	$('#pass').html("密码必须是5-12位字符,不能包含特殊字符");
             
             }  
   
  		});
  		
    
    		 $("#reNewPassword").blur(function(){
    		 	var renew=$('#reNewPassword').val();
    		 	var newpass=$('#newPassword').val();
    		 	var reg=/^\w{5,13}$/;
    		 	if(reg.test(renew)){
    		 	if(renew==newpass){
    		 		$('#renewpass').hide();
             		$('#repass').html("输入正确");
    		 		re=1;
    		 	}else{
    		 		$('#renewpass').hide();
             		$('#repass').html("密码不一致");
    		 	
    		 	}
    		 	}else{
    		 		$('#renewpass').hide();
             		$('#repass').html("密码必须是5-12位字符,不能包含特殊字符");
    		 	}
		    });
		    
		  /*   保存 */
		    
		    $('#gei').click(function(){
		    	
    		 	var data="newpass="+$('#newPassword').val();
		    	//alert(data);
		    	if(o==1&&n==1&&re==1){
		    	//alert(2);
		    		$.ajax({
		    			url:'uppassServlet',
    					type:'post',
    					data:data,
    					datatype:'text',
    					success:function(result){
    					//alert(result);
    					if(result==1){
    						alert("你的密码已更新请重新登录");
    						window.location.href='login.jsp';
    					};
    					
    					},
    					error:function(result){
    					 alert("修改失败");
    					}
		    		
		    		});
    		
		    	}else{
		    		alert("密码修改失败");
		    	}
		    
		    });
   });//最后一个括号；
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
		<c:set var="loginUser" value="${loginUser }" scope="session"></c:set>
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
			<strong>你现在所在的位置是:</strong> <span>密码修改页面</span>
		</div>
		<div class="providerAdd">
			<!-- <form action=""> -->
			<!--div的class 为error是验证错误，ok是验证成功-->
			<div class="">
				<label for="oldPassword">旧密码：</label> <input type="password"
					name="oldPassword" id="oldPassword" required /> <span id="old">*请输入原密码</span>
				<span id="oldpass"></span>
			</div>
			<div>
				<label for="newPassword">新密码：</label> <input type="password"
					name="newPassword" id="newPassword" /> <span id="newpass">*请输入新密码</span>
				<span id="pass"></span>
			</div>
			<div>
				<label for="reNewPassword">确认新密码：</label> <input type="password"
					name="reNewPassword" id="reNewPassword" required /> <span
					id="renewpass">*请输入新确认密码，保证和新密码一致</span> <span id="repass"></span>
			</div>
			<div class="providerAddBtn">
				<!--<a href="#">保存</a>-->
				<input id="gei" type="button" value="保存" />
			</div>
			<!--  </form> -->
		</div>
	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="js/time.js"></script>

</body>
</html>
