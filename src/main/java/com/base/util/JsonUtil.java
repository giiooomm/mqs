package com.base.util;

import java.util.List;

import net.sf.json.JSONArray;

public class JsonUtil {
  public static String getResultJson(String result){
	  System.out.println("{"+"\"result\":\""+result+"\"}");
	  
	  return "{"+"\"result\":\""+result+"\"}";
  }
  
  public static JSONArray modelToJsonArray(List<?> list){
	JSONArray json = JSONArray.fromObject(list); 
	return json; 
  }
}
