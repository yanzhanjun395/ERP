package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.until.UtilCookie;

//import entity.User;

//import service.userService;
//import serviceimpl.userServiceImpl;
//import util.CookieUtil;

public class usServlet extends HttpServlet {

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//得到表单元素的userPass;
		String userPass=request.getParameter("oldpass");
		//得到登录界面的用户名； cookie里面存放的用户信息；
		
	
		String result=UtilCookie .getCookie("myUser", request);
		
		//System.out.println(result);
		if(result!=null&&!result.equals("")){
			
			
			
			String [] user=result.split("&");
			String name=user[0];
			String pass=user[1];
			
			//userService service=new userServiceImpl();
			//User users= service.getPass(name);
			if(pass!=null&&!pass.equals("")){
				if(pass.equals(userPass)){
					out.print("1");
					
				}else{
					out.print("0");
					
				}
				
				
			}
		}
		
		
		out.flush();
		out.close();
	}

	
	public void init() throws ServletException {
	}

}
