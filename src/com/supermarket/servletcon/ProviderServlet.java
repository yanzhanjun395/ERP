package com.supermarket.servletcon;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.providers;
import com.supermarket.service.ProviderService;
import com.supermarket.service.impl.ProviderServiceImpl;
import com.supermarket.until.NumberUtil;
/**
 * 供应商管理控制器
 * @author Mr孙
 *  2017-2-21上午8:28:32
 */
@SuppressWarnings("serial")
public class ProviderServlet extends HttpServlet {

	ProviderService service = new ProviderServiceImpl();
	//查看单个供应商详情
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String isupdate=request.getParameter("update");
		
		String proCode=request.getParameter("proCode");
		providers provider = service.showProvider(proCode);
		request.setAttribute("provider", provider);
		
		if(isupdate==null||"".equals(isupdate)){
			//request.getSession().setAttribute("provider", provider);
			request.getRequestDispatcher("provider/providerView.jsp").forward(request, response);
			//response.sendRedirect("provider/providerView.jsp");
		}else{
			//逃到修改页面
			request.getRequestDispatcher("provider/providerUpdate.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
