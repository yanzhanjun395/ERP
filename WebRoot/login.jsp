<%@page import="com.supermarket.service.impl.UserServiceImpl"%>
<%@page import="com.supermarket.service.UserService"%>
<%@page import="com.supermarket.entity.User"%>
<%@page import="com.supermarket.until.UtilCookie"%>
<%@page import="java.net.URLDecoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录 - 超市账单管理系统</title>
    <link rel="stylesheet" href="css/style.css"/>
    <script language="javascript">
		function check(){
			var login_username = document.getElementById("username");
			var login_password = document.getElementById("password");
			if(login_username.value == ""){
				alert("用户名不能为空！请重新填入！");
				login_username.focus();	
				return false;
			}else if(login_password.value == ""){
				alert("密码不能为空！请重新填入！");
				login_password.focus();
				return false;
			}
			return true;
		}
		
		function focusOnLogin(){
			var login_username = document.getElementById("username");
			if( login_username != null )
				login_username.focus();	
		}
	</script>
  </head>
  
  <body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>超市账单管理系统</h1>
        </header>
        <%
			String result=UtilCookie.getCookie("myUser", request);
			String myName=null;
			User user=null;	
			if(result!=null && !"".equals(result)){
				//分解字符串,用户名和密码
				String[] temp = result.split("&");
				myName=temp[0];
				String userPass=temp[1];
				UserService service=new UserServiceImpl();
				user=service.login(myName, userPass);
				session.setAttribute("loginUser", user);
			}
		%>
        <c:set var="isLogin" value="${empty loginUser}" scope="session"/>
        <section class="loginCont">
            <form class="loginForm" action="UserServlet?action=login" method="post" onsubmit="return check()">
                <div class="inputbox">
                    <label for="user">用户名：</label>
                    <input id="user" type="text" name="username" placeholder="请输入用户名" required/>
                </div>
                <div class="inputbox">
                    <label for="mima">密码：</label>
                    <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
                </div>
                <div class="subBtn">
                    <input type="submit" value="登录" />
                    <input type="reset" value="重置"/>
                </div>
            </form>
        </section>
        
        
    </section>
  </body>
</html>
