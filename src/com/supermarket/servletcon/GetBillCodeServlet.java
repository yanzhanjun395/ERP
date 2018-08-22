package com.supermarket.servletcon;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.dao.BillsDao;
import com.supermarket.dao.impl.BillsDaoImpl;
import com.supermarket.entity.Provider;
import com.supermarket.service.AddBillService;
import com.supermarket.service.BillsService;
import com.supermarket.service.impl.AddBillServiceImpl;
import com.supermarket.service.impl.BillsServiceImpl;
import com.supermarket.until.StringUtil;

public class GetBillCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num=request.getParameter("num");
		String numName=request.getParameter("numName");
		String money=request.getParameter("money");
		String supplier=request.getParameter("supplier");
		String zhifu=request.getParameter("zhifu");
		
		BillsService service=new BillsServiceImpl();
		BillsDao dao=new BillsDaoImpl();
		service.setDao(dao);
		List<Provider> list=service.getProvider();
		if(!"2".equals(num)){
			numName=StringUtil.getFileName();
		}
		/*int numNmae=NumberUtil.getNumber(name);
		System.out.println(numNmae);*/
		AddBillService serviceS=new AddBillServiceImpl();
		
		String prname=serviceS.getAPro(supplier);
		
		request.setAttribute("prname", prname);
		request.setAttribute("num", num);
		request.setAttribute("money", money);
		request.setAttribute("supplier", supplier);
		request.setAttribute("zhifu", zhifu);
		request.setAttribute("list", list);
		request.setAttribute("numName", numName);
		
   		//转发
   		request.getRequestDispatcher("bill/billAdd.jsp").forward(request, response);
	}



}
