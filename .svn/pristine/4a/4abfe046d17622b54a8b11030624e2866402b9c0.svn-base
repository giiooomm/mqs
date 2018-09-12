package com.base.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;

public class RequestUtil {
  @SuppressWarnings({ "unchecked"})
public static <T> T getObject(Class<?> clazz,ServletRequest request){
	  Map<String, Object> map= new HashMap<String, Object>();
	Enumeration<?> enums = request.getParameterNames();
	while (enums.hasMoreElements()) {
		String name = (String) enums.nextElement();
		String value = request.getParameter(name);	
		map.put(name, value);
	}
	return (T) EntitytoString.getEntitys(map, clazz);  
  }
}
