package com.oracle.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SnUtils {
	
	static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	 public static String getGoodsSn(){
		return "G"+sdf.format(new Date());
	 }
	
	 public static String getOrderSn(){
		 return "O"+sdf.format(new Date());
	 }
}
