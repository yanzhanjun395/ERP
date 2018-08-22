package com.supermarket.servletcon;
/**
 * 得到一个账单对象，然后得到其中的是否付款
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

public class GetIsPaymentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BillsService service=new BillsServiceImpl();
		BillsDao dao=new BillsDaoImpl();
		service.setDao(dao);
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String billId=request.getParameter("billId");
		String billnum=request.getParameter("billnum");
		String billnum1=request.getParameter("billnum1");
		String billCode=request.getParameter("billCode");
		String nid=request.getParameter("nid");
		String page_no=request.getParameter("page_no");
		String proname=request.getParameter("proname");
		String tigong=request.getParameter("tigong");
		String fukuan=request.getParameter("fukuan");
		
		Object [] param ={billId};
		ShopprngBill bill=service.getBill(param);
		
		//System.out.println("账单编号1"+billCode);
		int row=service.getCodeNum(billCode);
		
		request.setAttribute("row", row);
		request.setAttribute("bill", bill);
		request.setAttribute("billId", billId);
		request.setAttribute("billnum", billnum);
		request.setAttribute("billnum1", billnum1);
		request.setAttribute("billCode", billCode);
		request.setAttribute("id", nid);
		request.setAttribute("index", page_no);
		request.setAttribute("proname", proname);
		request.setAttribute("tigong", tigong);
		request.setAttribute("fukuan", fukuan);
		/*System.out.println("是否付款"+bill.getIsPayment());
		System.out.println("行数"+row);
		System.out.println("num****"+billnum);
		System.out.println("NUM数"+billnum1);
		System.out.println("页数"+page_no);*/
   		//转发
   		request.getRequestDispatcher("bill/billList.jsp").forward(request, response);
		
		
		out.flush();
		out.close();
	}

}
