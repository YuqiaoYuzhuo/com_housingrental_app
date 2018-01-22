package com.xc.basic.cache;

import org.springframework.cache.Cache;

/**
 * <p>Title: 自定义缓存工厂类，用于包装获取缓存Cache对象,实际返回的是CacheProxy对象</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月22日
 */
public interface SystemCacheFactory
{
    /**
     * 得到系统缓存key=CACHE_SYSTEM的缓存对象
     * <p>Description:<p>
     * @return
     * @author wanglei 2018年1月22日
     */
    public Cache getCacheSystem();
    

}
