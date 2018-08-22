package com.supermarket.until;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NumberUtil {
	/**
	 * 字符串转换为数组，
	 * @param num 数字格式的字符串
	 * @return 如果返回-1， 转换失败
	 */
	public static double getNumber(String num){
		double temp=-1;
		try {
			temp =Double.valueOf(num);
		} catch (NumberFormatException e) {
			
		}
		
		return temp;
	}
	
	public static int getIntNumber(String num){
		int temp=-1;
		try {
			temp =Integer.parseInt(num);
		} catch (NumberFormatException e) {
			
		}
		
		return temp;
	}

	//得到用户编码
			public static String getCode(){
				String  code=null;
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMddhhmmss");
				 code=sdf.format(date);
				
				return code;
			
			}
}
