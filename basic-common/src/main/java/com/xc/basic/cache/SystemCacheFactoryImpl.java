package com.xc.basic.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.xc.basic.exception.BusinessException;
/**
 * <p>Title:系统缓存初始化工工厂类 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月22日
 */
public class SystemCacheFactoryImpl implements SystemCacheFactory
{
    public CacheManager cacheManager; 
    private SystemInitCacheTool systemInitCacheTool;
    
    protected static final  Logger logger  = LoggerFactory.getLogger(SystemCacheFactoryImpl.class);
    
    private Cache cacheSystem = null;
    
    public Cache getCacheSystem(){
        if(cacheSystem == null){
            Cache cacheObj= getCacheByName(CacheContants.CACHE_SYSTEM);
            cacheSystem = new CacheProxy(cacheObj,systemInitCacheTool);
        }
        return cacheSystem;
    }
    
    private Cache getCacheByName(String name){
        Cache cache = cacheManager.getCache(name);
        if(cache == null){
            String msg = "缓存["+name+"]无法找到!!!请检查缓存配置项!";
            logger.warn(msg);
            throw new BusinessException(msg);
        }
        return cache;
    }
    

    public CacheManager getCacheManager()
    {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager)
    {
        this.cacheManager = cacheManager;
    }

	public SystemInitCacheTool getSystemInitCacheTool() {
		return systemInitCacheTool;
	}

	public void setSystemInitCacheTool(SystemInitCacheTool systemInitCacheTool) {
		this.systemInitCacheTool = systemInitCacheTool;
	}

	public void setCacheSystem(Cache cacheSystem) {
		this.cacheSystem = cacheSystem;
	}
}
