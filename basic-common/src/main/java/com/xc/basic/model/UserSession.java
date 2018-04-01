package com.xc.basic.model;

import java.util.HashMap;
import java.util.Map;

public class UserSession {
	  /** * 保存变量的ThreadLocal，保持在同一线程中同步数据. */
	    @SuppressWarnings("rawtypes")
	private static final ThreadLocal SESSION_MAP = new ThreadLocal();

	    /** * 工具类的protected构造方法. */
	    protected UserSession() {
	    }

	    /**
	     * 获得线程中保存的属性.
	     * @param attribute 属性名称
	     * @return 属性值
	     */
	    @SuppressWarnings("rawtypes")
	    public static Object get(String attribute) {
		  Map map =  null==SESSION_MAP.get()?null:(Map)SESSION_MAP.get();
	        return null==map?null:map.get(attribute);
	    }

	    /**
	     * 获得线程中保存的属性，使用指定类型进行转型.
	     * @param attribute属性名称
	     * @param clazz类型
	     * @param <T>自动转型
	     * @return 属性值
	     */
	    @SuppressWarnings("unchecked")
	public static <T> T get(String attribute, Class<T> clazz) {
	    	Object obj = get(attribute);
	        return null==obj?null:(T)obj;
	    }

	    /**
	     * 设置制定属性名的值.
	     * 
	     * @param attribute
	     *            属性名称
	     * @param value
	     *            属性值
	     */
	    @SuppressWarnings({"unchecked", "rawtypes"})
	public static void set(String attribute, Object value) {
		Map map = (Map) SESSION_MAP.get();
	        if (map == null) {
	            map = new HashMap();
	            SESSION_MAP.set(map);
	        }

	        map.put(attribute, value);
	    }
}
