package com.supermarket.servletcon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class passServlet extends HttpServlet {

private String a;
	//修改密码   新用户名密码ajax验证
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//首先对新密码的位数进行验证满足5-12位；
		String newpass= request.getParameter("newpass");
		String oldpass=request.getParameter("oldpass");
		//System.out.println(oldpass);
		if(oldpass.equals(newpass)){
			out.print("1");
			
		}else{
			out.print("0");
			
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
