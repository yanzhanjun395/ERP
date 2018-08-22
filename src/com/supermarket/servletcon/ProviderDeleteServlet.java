package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.service.ProviderService;
import com.supermarket.service.impl.ProviderServiceImpl;

@SuppressWarnings("serial")
public class ProviderDeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		//actions=dele
		String userCode = request.getParameter("proCode");
	    String tankuang=request.getParameter("actions");
	   
	    if(tankuang!=null){
	    	request.setAttribute("tanku", userCode);
	    	request.setAttribute("dele", 1);
	    	request.getRequestDispatcher("GetProviderServlet").forward(request, response);
	    }else{
	    	//response.setContentType("text/html;charset=utf-8");
			ProviderService service=new ProviderServiceImpl();
			boolean isDelete=service.deleteProByCode(userCode);
			
			if(isDelete){
				out.print("<script>alert('供应商删除成功！');window.location.href='GetProviderServlet'</script>");
			}else{
				out.print("<script>alert('供应商删除失败！');window.history.back()</script>");
			}
	    }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");*/
		this.doGet(request, response);
		
	}

}
