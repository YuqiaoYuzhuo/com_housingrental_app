package com.xc.basic.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import com.xc.basic.cache.SystemCacheFactory;
@Component("cacheUtil")
public class CacheUtil {
	@Autowired
	private SystemCacheFactory systemCacheFactory;
	public Object get(String key,Class<?> clazz){
		 Cache cacheProxy = systemCacheFactory.getCacheSystem();
		 return cacheProxy.get(key,clazz);
	}
}
