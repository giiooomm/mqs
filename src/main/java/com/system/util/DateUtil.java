package com.system.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.hazelcast.com.eclipsesource.json.ParseException;



public class DateUtil {
	 
	 // 短日期格式
	 public static String DATE_FORMAT = "yyyy-MM-dd";
	 
	 // 长日期格式
	 public static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	 
	 /**
	  * 将日期格式的字符串转换为长整型
	  * 
	  * @param date
	  * @param format
	  * @return
	  */
	 public static long convert2long(String date, String format) {
	  try {
	   if (StringUtils.isNotBlank(date)) {
	    if (StringUtils.isBlank(format))
	     format = DateUtil.TIME_FORMAT;
	    SimpleDateFormat sf = new SimpleDateFormat(format);
	    return sf.parse(date).getTime();
	   }
	  } catch (ParseException e) {
	   e.printStackTrace();
	  } catch (java.text.ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return 0l;
	 }
	 
	 /**
	  * 将长整型数字转换为日期格式的字符串
	  * 
	  * @param time
	  * @param format
	  * @return
	  */
	 public static String convert2String(long time, String format) {
	  if (time > 0l) {
	   if (StringUtils.isBlank(format))
	    format = DateUtil.TIME_FORMAT;
	   SimpleDateFormat sf = new SimpleDateFormat(format);
	   Date date = new Date(time);
	   return sf.format(date);
	  }
	  return "";
	 }
	 

	 

	}

