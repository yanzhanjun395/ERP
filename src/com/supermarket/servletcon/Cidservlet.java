package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.User;
import com.supermarket.service.UserService;
import com.supermarket.service.impl.UserServiceImpl;

public class Cidservlet extends HttpServlet {
	UserService service=new UserServiceImpl();
	/**
	 * 根据用户名得到用户编码（修改用户控制器）
	 */

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("name");
		User user=service.userSelcet(username);
		request.setAttribute("uu", user);
		request.getRequestDispatcher("user/userUpdate.jsp").forward(request, response);
		
		
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
