package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.User;
import com.supermarket.entity.providers;
import com.supermarket.service.ProviderService;
import com.supermarket.service.impl.ProviderServiceImpl;


@SuppressWarnings("serial")
public class ProviderAddServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProviderService service =new ProviderServiceImpl();
		
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user=(User)request.getSession().getAttribute("loginUser");
		providers provider = new providers();
		provider.setProCode(request.getParameter("providerId"));
		provider.setProName(request.getParameter("providerName"));
		provider.setProDesc(request.getParameter("describe"));
		provider.setProContact(request.getParameter("people"));
		provider.setProPhone(request.getParameter("phone"));
		provider.setProAddress(request.getParameter("address"));
		provider.setProFax(request.getParameter("fax"));
		provider.setCreateBy(user.getUserName());
		/*provider.setCreateDate(new Date());
		provider.setModifyDate(new Date());*/
		provider.setModifyBy(user.getUserName());
		if(service.addPro(provider)){
			//成功，回到后台的首页
			out.print("<script>alert('供应商添加成功！');window.location.href='GetProviderServlet'</script>");
		}else{
			//失败，回到添加页面1
			out.print("<script>alert('供应商添加失败，请检查添加供应商编码是否重复！');window.history.back()</script>");
		}
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");*/
		this.doGet(request, response);
	}

}
