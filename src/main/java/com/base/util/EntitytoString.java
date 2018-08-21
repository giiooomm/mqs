package com.base.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class EntitytoString {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static  List getEntitys(List<Map<String, Object>> list,Class< ? > c){
		
		Class clazz = null;
		Object obj  = null;
		List resultList = new ArrayList();;
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

		for(Map<String,Object> map : list){
			for(String key : map.keySet()){
				for(Field field : fields){
					String fieldName = field.getName();	
					@SuppressWarnings("unused")
					Class<?> fieldType = field.getType();
					if(fieldName.equals(key)){
						try {
							PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
							Method wM = pd.getWriteMethod();
							wM.invoke(obj, map.get(key));
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
	
	
}
