package com.base.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;

public class EhcacheUtil {
	private static CacheManager cacheManager = null;
	private final static String sysCache = "system";
	
	static{
		if(cacheManager == null){
			cacheManager = CacheManager.create(); 
		}
	}
	
	public static void addCache(String key,String value){
		Cache cache = getCache();
	    add(cache,key,value);
	}
	private static Cache getCache(){
		Cache cache = cacheManager.getCache(sysCache);
		if(cache == null){
 			cache = new Cache(sysCache, 1000, false, true, 3600, 7200);
 			cache.setCacheManager(cacheManager);
 			cacheManager.addDecoratedCache(cache);
		}
		return cache;
	}
	private static void add(Cache cache, String key,String value) {
		Element element = new Element(key,value);
		if(!cache.getStatus().equals(Status.STATUS_ALIVE)) cache.initialise();
		cache.put(element);
	}
	
	public static Object getCache(String key){
		Cache cache = cacheManager.getCache(sysCache);
		if(cache==null) return null;
		Element element = cache.get(key);
		Object value = null;
		try{
			value =  element.getObjectValue();
		}catch(NullPointerException e){
			return  "";
		}
		return value;
		
	}
	
	public static String getStringCache(String key){
		return (String)getCache(key);
	}
	
	public static Long getLongCache(String key){
		return (Long)getCache(key);
	}
	
	public static boolean removeElement(String key){
		Cache cache = cacheManager.getCache(sysCache);
		if(cache==null) return true;
		return cache.remove(key);
		
	}
	
	
	
	public static void main(String[] args){
		//EhcaceUtil.addCache();
		//EhcaceUtil.addCache();
	}
}
