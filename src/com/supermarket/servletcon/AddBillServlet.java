package com.supermarket.servletcon;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.service.AddBillService;
import com.supermarket.service.impl.AddBillServiceImpl;

public class AddBillServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name=request.getParameter("name");
		String billCode1=request.getParameter("billCode");
		String billName=request.getParameter("billName");
		String billCom=request.getParameter("billCom");
		String billNum=request.getParameter("billNum");
		String money=request.getParameter("money");
		String supplier=request.getParameter("supplier");
		//System.out.println(supplier);
		String zhifu=request.getParameter("zhifu");
		Object [] params={billCode1,billName,billCom,billNum,money,
				supplier,zhifu,name};
		/*Object [] params={"12","23","34","23","34",
				"45","56","67",new Date()};*/
		
		AddBillService service=new AddBillServiceImpl();
		int num=service.addBill(params);
		String prname=service.getAPro(supplier);
		
		request.setAttribute("num", num);
		request.setAttribute("billCode1", billCode1);
		request.setAttribute("supplier", supplier);
		request.setAttribute("zhifu", zhifu);
		request.setAttribute("prname", prname);
		request.getRequestDispatcher("bill/billAdd.jsp").forward(request, response);
		
		
		
		
		
		
		
		
	}

}
