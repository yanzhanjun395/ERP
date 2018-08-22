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

<title>添加用户</title>

<link rel="stylesheet" href="css/public.css" />
<link rel="stylesheet" href="css/style.css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
	//alert(1);
		$(function() {
			$("#userName").change(function() {
				//alert(1);
				var data = "uname=" + $("#userName").val();
				var data1 = $('#userName').val();
				reg = /^\S{2,13}$/;
				//alert(data);
				//提交的数据类型；
				if (reg.test(data1)) {
					$.ajax({
						url : 'userAddServlet?ac=password',
						type : 'post',
						data : data,
						datatype : 'text',
						success : function(result) {
							//alert(result);
							if (result == 0) {
								$('#name').show();
								$('#name2').hide();
								$('#name').html("用户名输入正确");
								//alert(1);

							} else {
								$('#name').hide();
								$('#name1').html("用戶名重復，請更換用戶名");

							}

						}

					});
				}else{
					$('#name2').show();
    				$('#name').hide();
    				$('#name1').hide();
    				$('#name2').html("用户名输入有误，必须是5-10");
    			}
			});
		});
		
		
		 //用户电话；
   	$('#userphone').blur(function(){
    	reg=/^\d{11}$/;
    	reg2=/^\d{3,4}-\d{7}$/;
    	var data=$('#userphone').val();
    	if(reg.test(data)||reg2.test(data)){
    		$('#phone').hide();
    		$('#phone1').show();
    		$('#phone1').html("输入正确");
    		c=1;
    	
    	}else {
    		$('#phone1').hide();
    		$('#phone').html("输入格式有误");
    	}
    	
    	});
    	
    	
    	
    	 //日期
    $('#data').blur(function(){
    
    	var datas="birthday="+$('#data').val();
    	/* reg=/^[0-9]\d{3}\/(0[1-9]|1[0-2]\/|[1-2][0-9]|3[0-1])$/;
    	if(reg.test(data)){ */
    	//alert(1);
    	$.ajax({
    		url:'userAddServlet?ac=birthday',
    		data:datas,
    		datatype:'text',
    		type:'post',
    		success:function(result){
    			if(result=="0"){
    				$("#birthdays").html("格式输入有误，必须按照XXXX-mm-dd格式书写");
    				return false;
    			}else if(result==1){
    				$('#birthdays').hide();
    				$('#birthday1').html("输入正确");
    			}
    			
    		}
    	
    	});
    	
    });
    	
    	
    	//地址
    	 $('#userAddress').blur(function(){
    	
    	data=$('#userAddress').val();
    	reg=/^\S{4,100}$/;
    	if(reg.test(data)){
    	
    	
    	if(data=""){
    		$('#dss1').hide();
    		$('#dss2').hide();
    		$('#dss').html("不能为空");
    	}else {
    		$('#dss').hide();
    		$('#dss2').hide();
    		$('#dss1').show();
    		$('#dss1').html("输入正确");
    	
    	}
    }else{
    	$('#dss').hide();
    	$('#dss1').hide();
    	$('#dss2').show();
    	$('#dss2').html("地址太短无法识别");
    
    
    }
    	
    	
    });
    
    
    
    	//密碼4-12位
    	$("#userpassword").change(function(){
    		var data1 = $("#userpassword").val();
    		var reg=/^\w{5,13}$/;
    		if(reg.test(data1)){
    			$('#newpass').hide();
    			$('#pass').show();
    			$('#pass').html("输入正确");
    		
    		}else{
    		
    			$('#pass').hide();
    			$('#newpass').show();
             	$('#newpass').html("密码必须是5-12位字符,不能包含特殊字符");
    		}
    	});
    
    
    
    //確認密碼；
    
    $("#userRemi").blur(function(){
    		 	var renew=$('#userpassword').val();
    		 	var newpass=$('#userRemi').val();
    		 	if(renew==newpass){
    		 		$('#repass').show();
    		 		$('#renewpass').hide();
             		$('#repass').html("输入正确");
    		 		re=1;
    		 	}else{
    		 		$('#repass').show();
    		 		$('#renewpass').hide();
             		$('#repass').html("密码不一致");
    		 	}
		    });
		
		});//
		
	function check(){
	var name=document.getElementById("userName").value;
	var userphone=document.getElementById("userphone").value;
	var data=document.getElementById("data").value;
	var userAddress=document.getElementById("userAddress").value;
	var usertype=document.getElementById("").value;
	if(name!=""&&userphone!=""&&data!=""&&userAddress!=""){
	
		return true;
	}else{
    	   alert("所填数据不能为空，请检查");
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
			<li><a href="../provider/providerList.jsp">供应商管理</a>
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
			<strong>你现在所在的位置是:</strong> <span>用户管理页面 >> 用户添加页面</span>
		</div>

		<div class="providerAdd">
			<form action="userAddServlet?ac=userForm&cid=${cod}" method="post"
				onsubmit="return check()">
				<!--div的class 为error是验证错误，ok是验证成功-->
				<div class="">
					<label for="userId">用户编码：</label> <input type="text" name="usd"
						id="userId" value="${cod}" readonly="readonly" /> <span id="uid">*</span>
				</div>
				<div>
					<label for="userName">用户名称：</label> <input type="text" name="uuser"
						id="userName" /> <span id="uname"></span> <span id="name"></span>
					<span id="name1"></span> <span id="name2"></span>
				</div>
				<div>
					<label for="userpassword">用户密码：</label> <input type="text"
						name="userpassword" id="userpassword" /> <span id="pass"></span>
					<span id="newpass"></span>

				</div>
				<div>
					<label for="userRemi">确认密码：</label> <input type="text"
						name="userRem" id="userRemi" /> <span id="renewpass"></span> <span
						id="repass"></span>

				</div>
				<div>
					<label>用户性别：</label> <select name="sex">
						<option value="男">男</option>
						<option value="女">女</option>
					</select> <span></span>
				</div>
				<div>
					<label for="data">出生日期：</label> <input type="text" name="data"
						id="data" /> <span id="birthdays"></span> <span id="birthday1"></span>
				</div>
				<div>
					<label for="userphone">用户电话：</label> <input type="text"
						name="userphone" id="userphone" /> <span id="phone"></span> <span
						id="phone2"></span>
				</div>
				<div>
					<label for="userAddress">用户地址：</label> <input type="text"
						name="userAddress" id="userAddress" /> <span id="dss"></span> <span
						id="dss1"></span> <span id="dss2"></span>
				</div>
				<div>
					<label>用户类别：</label> <input type="radio" name="userlei" value="2" />管理员
					<input type="radio" name="userlei" value="3" />经理 <input
						type="radio" name="userlei" value="1" checked="checked" />普通用户

				</div>
				<div class="providerAddBtn">
					<!--<a href="#">保存</a>-->
					<!--<a href="userList.html">返回</a>-->
					<input type="submit" value="保存" /> <input type="button" value="返回" />
				</div>
			</form>
		</div>

	</div>
	</section>
	<footer class="footer"> 版权归北大青鸟 </footer>
	<script src="js/time.js"></script>

</body>
</html>
