package com.supermarket.servletcon;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.entity.User;
import com.supermarket.service.UserService;
import com.supermarket.service.impl.UserServiceImpl;
import com.supermarket.until.NumberUtil;

/**
 * 添加用户
 * @author Administrator
 *
 */
public class userAddServlet extends HttpServlet {
	UserService service=new UserServiceImpl();
	
	//验证用户是否重复；
	private void checkname(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String us=request.getParameter("uname");
		//System.out.println(us);
		User user=service.userSelcet(us);	
		//System.out.println(user);
		if(user==null){
			out.print("0");
		}else{
			out.print("1");
		}
		
	}
	
	//日期
	private void upBirthday(HttpServletRequest request,HttpServletResponse response) throws IOException, ParseException{
		
		response.setContentType("text/html");
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
	
	//提交表单
	private void checkForm(HttpServletRequest request,HttpServletResponse response) throws ParseException, ServletException, IOException{
		String userd=request.getParameter("cid");
		//System.out.println(userd);
		PrintWriter out = response.getWriter();
		
		String uuser=request.getParameter("uuser");
		String userpassword=request.getParameter("userpassword");
		String userRemi=request.getParameter("userRem");
		//System.out.println(userRemi);
		String sex=request.getParameter("sex");
		String data=request.getParameter("data");
		String phone=request.getParameter("userphone");
		String userAddress=request.getParameter("userAddress");
		String userlei=request.getParameter("userlei");
		
		double usertype=NumberUtil.getNumber(userlei);
		int row=service.addUser(userd, uuser, userpassword, sex, data,phone, userAddress, usertype);
		//System.out.println(row);
		if(row==1){
			//添加成功
		 out.print("<script>alert('用户添加成功！');window.location.href='userViewServlet?ac=selectAll'</script>");
			//request.getRequestDispatcher("UserList.jsp").forward(request, response);
		}else{
			//添加失败
			out.print("<script>alert('用户添加失败！');window.location.href='userViewServlet?ac=selectAll'</script>");
		}
		
	
		out.flush();
		out.close();
	}
	
	
	

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();*/
		String result=request.getParameter("ac");
		if("password".equals(result)){
			
			this.checkname(request, response);
			
		}else if("birthday".equals(result)){
			try {
				this.upBirthday(request, response);
			} catch (ParseException e) {
				
			}
			
			
		} else if("userForm".equals(result)){
			
			try {
				this.checkForm(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
		/*out.flush();
		out.close();*/
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

	
	public void init() throws ServletException {
	}

}
