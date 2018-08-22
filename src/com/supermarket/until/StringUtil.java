package com.supermarket.until;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {
	/**
	 * 获得当时时间字符串
	 * @return 时间字符串
	 */
	public static String getFileName() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String temp = sdf.format(new Date());
		temp="888"+temp;
		return temp;
	}

}
