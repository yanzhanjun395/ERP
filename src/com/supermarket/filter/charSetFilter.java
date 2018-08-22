package com.supermarket.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @ author 闫战军
 * @ version 
 * @ date 2017-2-16下午12:03:53
 * 对请求和响应的字符串的过滤
 */
public class charSetFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse rep,
			FilterChain chain) throws IOException, ServletException {
		//对请求的过滤
		req.setCharacterEncoding("UTF-8");
		//对相应的过滤
		rep.setContentType("text/html;charset=UTF-8");
		//交由下一个过滤器或者servlet
		chain.doFilter(req, rep);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
