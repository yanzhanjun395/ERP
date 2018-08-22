package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.User;
import com.supermarket.service.UserService;
import com.supermarket.service.impl.UserServiceImpl;
/**
 * 用户登录控制器
 * @author 孙文刚
 *
 */
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {

	UserService service=new UserServiceImpl();
	
	private void doLoginOut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 程序主动处理会话,使会话失效
		request.getSession().invalidate();

		// 清理cookie
		// 创建cookie对象
		Cookie cookie = new Cookie("myUser", null);
		// 设置有效期
		cookie.setMaxAge(0);
		// 设置有效路径
		cookie.setPath("/");
		// 由服务器向客户端写入cookie对象
		response.addCookie(cookie);

		// 页面进行重定向
		response.sendRedirect("login.jsp");
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 调用业务逻辑层
		User user = service.login(username, password);

		if (user != null) {
			// 账号和密码正确
			String value = username + "&" + password;
			// 如果cookie中存在中文，编码
			value = URLEncoder.encode(value, "UTF-8");
			// 创建cookie对象
			Cookie cookie = new Cookie("myUser", value);
			// 设置有效期
			cookie.setMaxAge(10 * 24 * 3600);
			// 设置有效路径
			cookie.setPath("/");
			// 由服务器向客户端写入cookie对象
			response.addCookie(cookie);

			request.getSession().setAttribute("loginUser", user);
			
			
			// 页面进行重定向
			response.sendRedirect("user/Welcome.jsp");
		} else {
			// 账号或密码错误
			out.print("<script>alert('账号或密码错误');window.history.back()</script>");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action=request.getParameter("action");
		if(action!=null && !"".equals(action)){
			if("login".equals(action)){
				doLogin(request,response);
			}else if("out".equals(action)){
				doLoginOut(request,response);
			}
		}
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
