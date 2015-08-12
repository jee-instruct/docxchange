package com.vamsee.spring.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtil {
	
	public static java.sql.Date getCurrentSqlDate() {
		java.sql.Date sDate = new java.sql.Date(new java.util.Date().getTime());
		return sDate;
	}
	
	public static String getCurrentDate(){
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("E, dd MMMM yyyy");
		return format.format(curDate);
	}
	
	public static String getCurrentTime(){
		return DateFormat.getTimeInstance(DateFormat.LONG).format(new Date());
	}
}
