package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.until.NumberUtil;

/**
 * 自动生成用户编码
 * @author Administrator
 *
 */
public class addCodeServlet extends HttpServlet {
	
	
	//得到用户编号自动生成
	public void destroy() {
		super.destroy(); 
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code=NumberUtil.getCode();
		//System.out.println(code);
		request.setAttribute("cod", code);
		request.getRequestDispatcher("user/userAdd.jsp").forward(request, response);
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
