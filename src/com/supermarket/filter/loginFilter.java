package com.supermarket.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @ author 闫战军
 * @ version 
 * @ date 2017-2-17下午12:25:34
 *
 */
public class loginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		PrintWriter out=rep.getWriter();
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) rep;
		HttpSession session=request.getSession();
		if(session.getAttribute("loginUser")==null){
			//没有登录
			out.print("<script>alert('您没有登录，无法查看，请登录。');window.location.href='../login.jsp'</script>");
			
		}else{
			//登录
			chain.doFilter(req, rep);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
