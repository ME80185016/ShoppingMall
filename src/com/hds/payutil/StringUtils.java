package com.hds.payutil;

import java.util.UUID;

/**
 * String工具 主要是对StringUtils一些方法进行重写,从而达到更好的应用
 * 
 * @author hds
 * 
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

	/**
	 * 一次性判断多个或单个对象为空。
	 * 
	 * @param objects
	 * @author ztt
	 * @return 只要有一个元素为Blank，则返回true
	 */
	public static boolean isBlank(Object... objects) {
		Boolean result = false;
		for (Object object : objects) {
			if (null == object || "".equals(object.toString().trim()) || "null".equals(object.toString().trim())) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 一次性判断多个或单个对象不为空。
	 * 
	 * @param objects
	 * @author ztt
	 * @return 只要有一个元素不为Blank，则返回true
	 */
	public static boolean isNotBlank(Object... objects) {
		return !isBlank(objects);
	}

	public static boolean isBlank(String... objects) {
		Object[] object = objects;
		return isBlank(object);
	}

	public static boolean isNotBlank(String... objects) {
		Object[] object = objects;
		return !isBlank(object);
	}

	public static boolean isBlank(String str) {
		Object object = str;
		return isBlank(object);
	}

	public static boolean isNotBlank(String str) {
		Object object = str;
		return !isBlank(object);
	}
	
	public static String getSessionId(){
		UUID uuid=UUID.randomUUID();
		String str=uuid.toString();
		return str.substring(0, 8)+str.substring(9, 13)+str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
	}

}
