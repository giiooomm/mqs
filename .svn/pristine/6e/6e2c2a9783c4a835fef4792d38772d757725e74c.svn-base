package com.base.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang.ArrayUtils;

public class JDBCUtil {
	
	public static Object[] modelToObject(Object obj, Class<?> clazz) {
		Object[] object = {0};
		Object value = null;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			@SuppressWarnings("unused")
			Class<?> fieldType = field.getType();
			try {
				PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
				Method wM = pd.getReadMethod();
				value = wM.invoke(obj);
				
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
			
			object = ArrayUtils.add(object, value);
		}		
		return ArrayUtils.remove(object, 0);		
	}
}
