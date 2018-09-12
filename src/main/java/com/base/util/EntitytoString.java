package com.base.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntitytoString {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getEntitys(List<Map<String, Object>> maplist, Class<?> c) {
		List<Map<String, Object>> list = getModelFiels(maplist);
		Class clazz = null;
		Object obj = null;
		List resultList = new ArrayList();
		;


		for (Map<String, Object> map : list) {
			try {
				clazz = c;
				obj = clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Field[] fields = c.getDeclaredFields();
			for (String key : map.keySet()) {
				for (Field field : fields) {
					String fieldName = field.getName();

					Class<?> fieldType = field.getType();
					if (fieldName.equals(key)) {
						try {
							PropertyDescriptor pd = new PropertyDescriptor(
									fieldName, clazz);
							Method wM = pd.getWriteMethod();
							
							if(fieldType.getName().equals("java.lang.Long"))
							  wM.invoke(obj,new Long(String.valueOf(map.get(key))));
							else
							  wM.invoke(obj, fieldType.cast(map.get(key)));
							break;
							
						} catch (IntrospectionException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							Throwable t = e.getTargetException();// 获取目标异常
							t.printStackTrace();
						}
					}
					
				}

			}
			resultList.add(obj);
		}
		return resultList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static <T>T getEntitys(Map<String, Object> map, Class<T> c) {

		Class clazz = null;
		Object obj = null;
		List resultList = new ArrayList();
		;
		try {
			clazz = c;
			obj = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] fields = c.getDeclaredFields();

		for (String key : map.keySet()) {
			for (Field field : fields) {
				String fieldName = field.getName();

				Class<?> fieldType = field.getType();
				if (fieldName.equals(key)) {
					try {
						PropertyDescriptor pd = new PropertyDescriptor(
								fieldName, clazz);
						Method wM = pd.getWriteMethod();
						
						
						if(fieldType.getName().equals("java.lang.Long")){							
						  wM.invoke(obj,new Long(String.valueOf(map.get(key).toString())));
						}
						else if(fieldType.getName().equals("int"))
							wM.invoke(obj,Integer.parseInt(String.valueOf(map.get(key).toString())));
						else if(fieldType.getName().equals("java.lang.String"))
							wM.invoke(obj, fieldType.cast(map.get(key).toString()));
						else
						    wM.invoke(obj, fieldType.cast(map.get(key)));
						break;
					} catch (IntrospectionException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						Throwable t = e.getTargetException();// 获取目标异常
						t.printStackTrace();
					}
				}
			}

		}
		return (T) obj;
	
	}
	
	public static List<Map<String, Object>> getModelFiels(List<Map<String, Object>> list){
	  List<Map<String,Object>> newlist = new ArrayList<Map<String,Object>>();  
	  for(Map<String,Object> map : list){
		  Map<String,Object> maps = new  HashMap<String,Object>();
		  for(String key : map.keySet()){
			  if(key.indexOf("_") > 0){
				  String newkey = getdex(key);
				  maps.put(newkey, map.get(key));
			  }else{
				  maps.put(key, map.get(key));
			  }
		  }
		  newlist.add(maps);
	  }
	  return newlist;
	}
	
	public static String getdex(String key){
		char dex1 = key.charAt(key.indexOf("_")+1);
		char dex2 = dex1;
		dex2 -= 32; 
		return key.replace("_"+dex1, dex2+"");
	}
}
