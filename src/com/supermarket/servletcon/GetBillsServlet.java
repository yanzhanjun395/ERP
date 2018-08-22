package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.dao.BillsDao;
import com.supermarket.dao.impl.BillsDaoImpl;
import com.supermarket.entity.Provider;
import com.supermarket.entity.ShopprngBill;
import com.supermarket.service.BillsService;
import com.supermarket.service.impl.BillsServiceImpl;
import com.supermarket.until.NumberUtil;
public class GetBillsServlet extends HttpServlet {
	private BillsService service=new BillsServiceImpl();
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String proname=request.getParameter("proname");
		String tigong=request.getParameter("tigong");
		String fukuan=request.getParameter("fukuan");
		String billCode=request.getParameter("billCode");
		String titles="%";
		String contexts="%";
		String billCodes="%";
		if(billCode!=null&&!"".equals(billCode)){
			billCodes="%"+billCode+"%";
		}
		if(tigong!=null&&!"".equals(tigong)){
			titles="%"+tigong+"%";
		}
		if(proname!=null&&!"".equals(proname)){
			contexts="%"+proname+"%";
		}
		if("".equals(fukuan)||fukuan==null){
			fukuan="%";
		}
		
		//System.out.println(billCode);
		//System.out.println(billCodes);
		
		
		
		Object [] param={contexts,titles,fukuan,billCodes};
		BillsDao dao=new BillsDaoImpl();
		service.setDao(dao);
		int index=1;
		
   		int pageSize=3;
   		int totalpage=service.showTotalPage(pageSize,param);
   		if(totalpage!=0){
   		
   		String no=request.getParameter("page_no");
   		if(no!=null&&!"".equals(no)){
   			index=(int) NumberUtil.getNumber(no);
   		}
   		if(index<1){
   			index=1;
   		}else if(index>totalpage){
   			index=totalpage;
   		}
   		Object [] params={contexts,titles,fukuan,billCodes,(index-1)*pageSize,index*pageSize};
   		List<ShopprngBill> list=service.getBills(params);
   		request.setAttribute("list", list);
   		}
   		List<Provider> list1=service.getProvider();
   		request.setAttribute("list1", list1);
   		request.setAttribute("index",index);
   		request.setAttribute("totalpage",totalpage);
   		request.setAttribute("proname", proname);
   		request.setAttribute("tigong", tigong);
   		request.setAttribute("fukuan", fukuan);
   		request.setAttribute("billCode", billCode);
   		//转发
   		request.getRequestDispatcher("bill/billList.jsp").forward(request, response);
	}

}
