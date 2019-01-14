package com.base.util;

import org.springframework.beans.factory.annotation.Autowired;


public class RedisUtil {
	 @Autowired
	  private RedisCacheManager redisCacheManager;
	 
	 public  String get(String key){
		 return (String) redisCacheManager.get(key);
		 
	 }
}
