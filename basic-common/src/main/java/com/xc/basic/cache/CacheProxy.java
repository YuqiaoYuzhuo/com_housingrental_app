package com.xc.basic.cache;

import java.util.concurrent.Callable;

import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

/**
 * 缓存代理类，主要对spring的cache对象做一层包装,实现缓存数据二次加载等一些附属功能
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018-01-22
 */
public class CacheProxy implements Cache
{
    private Cache cache;
    private SystemInitCacheTool systemInitCacheTool;
    
    public CacheProxy(Cache cache,SystemInitCacheTool systemInitCacheTool){
        this.cache = cache;
        this.systemInitCacheTool = systemInitCacheTool;
    }
    
    @Override
    public String getName()
    {
       return cache.getName();
    }

    @Override
    public Object getNativeCache()
    {
        return cache.getNativeCache();
    }

    @Override
    public ValueWrapper get(Object key)
    {
        ValueWrapper obj =cache.get(key);
        if(obj == null){
        	systemInitCacheTool.initCache(key);
        }
        obj = cache.get(key);
        return obj;
    }

    @Override
    public <T> T get(Object key, Class<T> type)
    {
        T obj =cache.get(key,type);
        if(obj == null){
        	systemInitCacheTool.initCache(key);
        }
        obj = cache.get(key,type);
        return obj;
    }

    @Override
    public <T> T get(Object key, Callable<T> valueLoader)
    {
        T obj =cache.get(key,valueLoader);
        if(obj == null){
        	systemInitCacheTool.initCache(key);
        }
        obj = cache.get(key,valueLoader);
        return obj;
    }

    @Override
    public void put(Object key, Object value)
    {
         cache.put(key,value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value)
    {
        return cache.putIfAbsent(key,value);
    }

    @Override
    public void evict(Object key)
    {
        cache.evict(key);
    }

    @Override
    public void clear()
    {
        cache.clear();
    }

    public Cache getCache()
    {
        return cache;
    }

    public void setCache(Cache cache)
    {
        this.cache = cache;
    }
    
    

}
