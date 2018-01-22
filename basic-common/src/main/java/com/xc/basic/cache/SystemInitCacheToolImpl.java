package com.xc.basic.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * <p>Title: 系统缓存初始化工具实现类</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月22日
 */
public class SystemInitCacheToolImpl implements SystemInitCacheTool
{
    protected static final  Logger logger  = LoggerFactory.getLogger(SystemInitCacheToolImpl.class);
    private SystemCacheFactory systemCacheFactory;
    @Override
    public void dataDictInit(){
        logger.debug("开始加载缓存[系统数据字典]start!!!!!!!!!!!!!!");
//        List<Map<?,?>> sysResourcePermitOperates = tabDataDictService.getDictDataList();
//        Cache cache = psmcCacheFactory.getCacheSystem();
//        cache.put(CacheContants.CACHE_SYSTEM_DATA_DICT, sysResourcePermitOperates);
        //TODO 初始换数据字典缓存
        logger.debug("开始加载缓存[系统数据字典]end!!!!!!!!!!!!!!");
    }
    
    
    public void tabCityInit(){
        logger.debug("开始加载缓存[系统属地]start!!!!!!!!!!!!!!");
        /*List<Map<?,?>> sysResourcePermitOperates = cityService.getAllRegion();
        Cache cache = psmcCacheFactory.getCacheSystem();
        cache.put(CacheContants.CACHE_SYSTEM_DATA_CITY, sysResourcePermitOperates);*/
       //TODO 初始化属地缓存
        logger.debug("开始加载缓存[系统属地]end!!!!!!!!!!!!!!");
    }
    
    @Override
    public void initCache(Object key){
        if(key == null)
            return;
        String cacheKey = key.toString();
        if(cacheKey.equals(CacheContants.CACHE_SYSTEM_RESOURCE_OPERATE)){
           // resourcePermitOperatesInit();s
        }else if(cacheKey.equals(CacheContants.CACHE_SYSTEM_DATA_DICT)){
            dataDictInit();
        }else if(cacheKey.equals(CacheContants.CACHE_SYSTEM_DATA_CITY)){
            tabCityInit();
        }else{
            logger.warn("缓存["+cacheKey+"]没有可以进行初始化的方法!!!");
        }
    }

	public SystemCacheFactory getSystemCacheFactory() {
		return systemCacheFactory;
	}

	public void setSystemCacheFactory(SystemCacheFactory systemCacheFactory) {
		this.systemCacheFactory = systemCacheFactory;
	}
    
}
