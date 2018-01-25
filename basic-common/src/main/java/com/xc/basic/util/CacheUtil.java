package com.xc.basic.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import com.xc.basic.cache.SystemCacheFactory;
@Component("cacheUtil")
public class CacheUtil {
	@Autowired
	private SystemCacheFactory systemCacheFactory;
	/**
	 * <p>Description:<p>
	 * @param key
	 * @param clazz
	 * @return
	 * @author wanglei 2018年1月25日
	 */
	public Object get(String key,Class<?> clazz){
		 Cache cacheProxy = systemCacheFactory.getCacheSystem();
		 return cacheProxy.get(key,clazz);
	}
	/**
	 * <p>Description:把对象加入缓存中<p>
	 * @param key 键
	 * @param obj 值
	 * @author wanglei 2018年1月25日
	 */
	public void set(String key,Object obj){
		Cache cacheProxy = systemCacheFactory.getCacheSystem();
		  cacheProxy.put(key, obj);
	}
}
