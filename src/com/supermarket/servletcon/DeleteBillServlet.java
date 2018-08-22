package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.service.DeleteBillService;
import com.supermarket.service.impl.DeleteBillServiceImpl;

public class DeleteBillServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//得到账单的编号，用作下面的按编号删除此编号的所有信息
		String billCode=request.getParameter("billCode");
		//获得一个参数，用来jsp页面弹框如何出现
		String billnum2=request.getParameter("billnum2");
		//得到一个账单的id，用作删除单条信息
		String billId=request.getParameter("billId");
		//得到页面参数，让页面再删除的时候还在原来位置
		String nid=request.getParameter("nid");
		String page_no=request.getParameter("page_no");
		String proname=request.getParameter("proname");
		String tigong=request.getParameter("tigong");
		String fukuan=request.getParameter("fukuan");
		
		
		DeleteBillService service = new DeleteBillServiceImpl();
		int rowCode=service.deleteBillByCode(billCode);
		int rows=service.deleteBillById(billId);
		request.setAttribute("rows", rows);
		request.setAttribute("billnum2", billnum2);
		request.setAttribute("rowCode", rowCode);
		request.setAttribute("id", nid);
		request.setAttribute("index", page_no);
		request.setAttribute("proname", proname);
		request.setAttribute("tigong", tigong);
		request.setAttribute("fukuan", fukuan);
		request.getRequestDispatcher("bill/billList.jsp").forward(request, response);
		/*System.out.println(billId);
		System.out.println(rowCode);
		System.out.println(rows);
		System.out.println(billnum2);*/
		
		out.flush();
		out.close();
	}

}
