package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.providers;
import com.supermarket.service.ProviderService;
import com.supermarket.service.impl.ProviderServiceImpl;
/**
 * 
 * @author Administrator
 * 修改供应商信息
 */
@SuppressWarnings("serial")
public class ProviderUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ProviderService service=new ProviderServiceImpl();
		providers provider=new providers();
		
		//response.setContentType("text/html");
		
		String proCode=request.getParameter("providerId");
		provider.setProCode(proCode);
		String proName=request.getParameter("providerName");
		provider.setProName(proName);
		
		String proContact=request.getParameter("people");
		provider.setProContact(proContact);
		
		String proPhone=request.getParameter("phone");
		provider.setProPhone(proPhone);
		
		String proAddress=request.getParameter("address");
		provider.setProAddress(proAddress);
		
		String proFax=request.getParameter("fax");
		provider.setProFax(proFax);
		String proDesc=request.getParameter("describe");
		provider.setProDesc(proDesc);
		
		//执行修改操作
		boolean isupdate=service.updateProvider(provider);
		if(isupdate){//修改成功后到供应商列表
			out.print("<script>alert('供应商修改成功！');window.location.href='GetProviderServlet'</script>");
		}else{
			out.print("<script>alert('供应商修改失败！');window.location.href='GetProviderServlet'</script>");
		}
		
		
		
		/*out.flush();
		out.close();*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
