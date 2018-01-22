package com.xc.basic.cache;
/**
 * <p>Title:缓存初始化加载方法</p>
 * <p>Description:缓存初始化加载方法 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月22日
 */
public interface SystemInitCacheTool
{
    /**
     * <p>Description:数据字典缓存加载<p>
     * @author wanglei 2018年1月22日
     */
    public void dataDictInit();
    /**
     * <p>Description:属地缓存数据初始化<p>
     * @author wanglei 2018年1月22日
     */
    public void tabCityInit();
    
    /**
     * 统一缓存数据初始化入口,根据缓存数据的key进行数据初始化
     * <p>Description:<p>
     * @param key
     * @author wanglei 2018年1月22日
     */
    
    public void initCache(Object key);
    
    
}
