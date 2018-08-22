package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.management.j2ee.statistics.SessionBeanStats;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.service.UserService;
import com.supermarket.service.impl.UserServiceImpl;
import com.supermarket.until.UtilCookie;

public class uppassServlet extends HttpServlet {

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String result=UtilCookie.getCookie("myUser", request);
		//String result=com.jbit.until.CookieUtil .getCookie("myUser", request);
		String name=null;
		
		
		if(result!=null&&!result.equals("")){
			String [] user=result.split("&");
			 name=user[0];
		}
		String pass=request.getParameter("newpass");
		
		UserService service=new UserServiceImpl();
		int row=service.updatePass(name, pass);
		if(row==1){
			
			//System.out.println(row);
			request.getSession().invalidate();
			Cookie cookie=new Cookie("myUser","");
			cookie.setMaxAge(0);
			// 设置有效路径
			cookie.setPath("/");
			// 由服务器向客户端写入cookie对象
			response.addCookie(cookie);
			//response.sendRedirect("Login.jsp");			
			out.print(1);
		}
		
		
		
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void init() throws ServletException {
		
	}

}
