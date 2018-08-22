package com.supermarket.until;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @ author 闫战军
 * @ version 
 * @ date 2017-2-16上午11:44:21
 * cookie操作类
 */
public class UtilCookie {
	public static String getCookie(String key,HttpServletRequest request){
		String cook=null;
		if(key!=null){
			Cookie[] cookie = request.getCookies();
			if(cookie!=null){
				for (Cookie cookie2 : cookie) {
					if(key.equals(cookie2.getName())){
						//进行读取解码防止乱码
						try {
							cook=URLDecoder.decode(cookie2.getValue(), "UTF-8");
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			}
			
			
		}
		
		return cook;
	}
	
	
	
	
	
	
}
