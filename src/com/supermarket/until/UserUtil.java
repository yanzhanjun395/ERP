package com.supermarket.until;

import javax.servlet.http.HttpServletRequest;

import com.supermarket.entity.User;
import com.supermarket.service.UserService;
import com.supermarket.service.impl.UserServiceImpl;

public class UserUtil {
	
	public static User getUser(String key,HttpServletRequest request){
		User user=null;
		String result=UtilCookie.getCookie("myUser", request);
		String myName=null;
		if(result!=null && !"".equals(result)){
			//分解字符串,用户名和密码
			String[] temp = result.split("&");
			myName=temp[0];
			String userPass=temp[1];
			UserService service=new UserServiceImpl();
			user=service.login(myName, userPass);
		}
		return user;
	}
}
