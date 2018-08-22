package com.supermarket.servletcon;
/**
 * 判断输入的是否是数字
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.until.NumberUtil;

public class IsNumberServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获取请求的信息
		String billNum=request.getParameter("Num");
		double nums=NumberUtil.getNumber(billNum);
		if(nums>=0){
			out.print(nums);	
		}else{
			out.print(-1);	
		}
		out.flush();
		out.close();
			
		
	}

}
