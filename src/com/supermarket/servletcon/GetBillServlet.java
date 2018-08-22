package com.supermarket.servletcon;
/**
 * 得到一个账单信息
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.dao.BillsDao;
import com.supermarket.dao.impl.BillsDaoImpl;
import com.supermarket.entity.ShopprngBill;
import com.supermarket.service.BillsService;
import com.supermarket.service.impl.BillsServiceImpl;

public class GetBillServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BillsService service=new BillsServiceImpl();
		BillsDao dao=new BillsDaoImpl();
		service.setDao(dao);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String billId=request.getParameter("billId");
		String fukuan=request.getParameter("fukuan");
		String tigong=request.getParameter("tigong");
		String proname=request.getParameter("proname");
		String billCode=request.getParameter("billCode");
		Object [] param ={billId};
		
		ShopprngBill bills=service.getBill(param);
		request.setAttribute("bills", bills);
		request.setAttribute("fukuan", fukuan);
		request.setAttribute("tigong", tigong);
		request.setAttribute("proname", proname);
		request.setAttribute("billCode", billCode);
   		//转发
   		request.getRequestDispatcher("bill/billView.jsp").forward(request, response);
		
		
		out.flush();
		out.close();
	}

}
