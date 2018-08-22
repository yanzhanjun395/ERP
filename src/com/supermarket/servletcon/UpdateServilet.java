package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.dao.UpdateBillsDao;
import com.supermarket.dao.impl.UpdateBillsDaoimpl;
import com.supermarket.entity.ShoppingBill;
import com.supermarket.until.NumberUtil;

public class UpdateServilet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String bid=request.getParameter("bilid");
		//System.out.println(bid);
		int id=NumberUtil.getIntNumber(bid);
		UpdateBillsDao bd=new UpdateBillsDaoimpl();
		
		ShoppingBill shopbill= bd.getBillsByBcode(id);//通过商品Id得到商品对象
		
		String providerId=request.getParameter("providerId");//商品编码
		String providerName=request.getParameter("providerName");//商品名称
		String pids=request.getParameter("pid");//供应商id
		//int pid=NumberUtil.getIntNumber(pids);
		String pronumber=request.getParameter("allmaney");//总金额
		double pnumber=Double.parseDouble(pronumber);//转换成 double类型
		String zhifu=request.getParameter("zhifu");//根据商品编码和商品名称查询
		int ispay=NumberUtil.getIntNumber(zhifu);
		int shop=bd.updateBillsByBid(shopbill, providerId,providerName,
				pids, pnumber, ispay, id);//调用修改方法
		//System.out.println(shop);
		if(shop==1){
			//正确：syso
			//System.out.println("chengg");
			out.print("<script>alert('修改成功！！！');window.location.href='GetBills'</script>");
			
		}else{
			//错误：
			//System.out.println("000000");
			out.print("<script>alert('修改失败！');window.location.href='GetBills'</script>");
			
		}
		
		
		out.flush();
		out.close();
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

		
	}

}
