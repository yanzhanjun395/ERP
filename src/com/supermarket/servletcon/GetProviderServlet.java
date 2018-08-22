package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.providers;
import com.supermarket.service.ProviderService;
import com.supermarket.service.impl.ProviderServiceImpl;
import com.supermarket.until.NumberUtil;

@SuppressWarnings("serial")
public class GetProviderServlet extends HttpServlet {
  /**
   * 查看供应商列表 包括分页的显示
   */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		ProviderService service=new ProviderServiceImpl();
		
		int index=1;
		int pageSize=3;
		int totalPage=service.showTotalPage(pageSize);
		
		String proName=request.getParameter("proName");
		if(proName==null||"".equals(proName)){
			proName="%";
		}else{
			proName="%"+proName+"%";
		}
		
		
		String no=request.getParameter("page_no");
		if(no!=null && !"".equals(no)){
		index=NumberUtil.getIntNumber(no);
		}
	
		//处理页数输入异常
		if(index<1){
			index=1;
		}else if(index>totalPage){
			index=totalPage;
	
		}
		//得到供应商的集合
		List<providers> list= service.getProviderByIndex(proName,index, pageSize);
		
		
		
		request.setAttribute("index", index);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("list", list);
		
		if(list!=null&&list.size()>0){
			/*ProviderService service=new ProviderServiceImpl();
	        providers provider= service.getProvider(proName);*/
			request.setAttribute("index", index);
			request.setAttribute("pageSize", pageSize);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("list", list);
			
	        request.getRequestDispatcher("provider/providerList.jsp").forward(request, response);
	        //response.sendRedirect("provider/providerList.jsp");
		}else{
			out.print("<script>alert('暂无数据！');window.location.href='provider/providerList.jsp'</script>");
		}
		
		
        
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
