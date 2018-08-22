package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.User;
import com.supermarket.service.UserService;
import com.supermarket.service.impl.UserServiceImpl;
/*
 * 修改用户信息控制器；
 */
public class updateServlet extends HttpServlet {
	UserService service=new UserServiceImpl();
	
	/**
	 * 出生日期
	 * @throws IOException 
	 * @throws ParseException 
	 */
	private void upBirthday(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException{
		
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//得到数据后进行判断；
		String birthday=request.getParameter("birthday");
		
		
		SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd");
		
		try{
			
			Date putdate=	format.parse(birthday);
			Date date=new Date();
			
			if(date.getTime()>putdate.getTime()){
				out.print("1");
				
			}
			
			}catch (ParseException e) {
				out.print("0");
			
			
		}
	
		
	}
	
	
	/**
	 * 提交表单方法,修改用户信息
	 */
	private void checkForm(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//可以作为修改后的用户名
		String username=request.getParameter("userName");
		//System.out.println(username);
		//如果用户名是空的话读隐藏域的内容；
		if(username.equals("")){
			 username=request.getParameter("unname");
		
		}
		
		 //	 通过用户编号去修改用户的信息；

		String userCode=request.getParameter("uid");//用户编号
		//String userCode="AAAA02";
		//System.out.println(userCode);
		String gender=request.getParameter("sex");//修改后性别
		//System.out.println(gender);
		String birthdays=request.getParameter("data");//修改后的日期
		//System.out.println(birthdays);
		//SimpleDateFormat format=new SimpleDateFormat("YYYY/MM/dd");
		//Date birthday;
		//try {
			//System.out.println("check");
			//birthday = format.parse(birthdays);
			String phone=request.getParameter("userphone");
			String address=request.getParameter("userAddress");
			String userlei=request.getParameter("userlei");
			int usertype=Integer.parseInt(userlei);
			int rows=service.updateUser(username, birthdays, gender, phone, address,usertype,userCode);
			if(rows==1){
				out.print("<script>alert('修改成功！');window.location.href='userViewServlet?ac=selectAll'</script>");
				//response.sendRedirect("userViewServlet?ac=selectAll");
			}else{
				out.print("<script>alert('修改失败！');window.location.href='userViewServlet?ac=selectAll'</script>");
			}
			
				out.flush();
				out.close();
		
	}
	
	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		String up=request.getParameter("up");
		String upser=request.getParameter("upser");
		
		//System.out.println(upser);
		
		
		if("usernames".equals(up)){
			//this.upuname(request, response);
			
		}else if("birthday".equals(up)){
			
			
			try {
				this.upBirthday(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else if("checks".equals(upser)){
			try {
				this.checkForm(request,response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
			
				
			
		
		/*out.flush();
		out.close();*/
	}

	
	public void init() throws ServletException {
	}

}
