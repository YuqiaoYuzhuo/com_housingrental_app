package com.xc.basic.cache;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.xc.basic.util.MySpringApplicationContext;
/**
 * <p>Title:系统缓存定时加载任务入口 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月22日
 */
public class InitCacheTask extends QuartzJobBean
{
    protected static final  Logger logger  = LoggerFactory.getLogger(InitCacheTask.class);
    private SystemInitCacheTool systemInitCacheTool;    
    public InitCacheTask (){
        Object obj = MySpringApplicationContext.getObject("systemInitCacheTool");
        if(obj !=null){
            this.systemInitCacheTool = (SystemInitCacheTool)obj;
                systemInitCacheTool.dataDictInit();
        }
        else
            logger.warn("bean id systemInitCacheTool not in spring context");
    }
    
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        if(systemInitCacheTool!=null){
            logger.debug("InitCacheTask start! ");
           systemInitCacheTool.dataDictInit();
            logger.debug("InitCacheTask end! ");
        }
    }

	public SystemInitCacheTool getSystemInitCacheTool() {
		return systemInitCacheTool;
	}

	public void setSystemInitCacheTool(SystemInitCacheTool systemInitCacheTool) {
		this.systemInitCacheTool = systemInitCacheTool;
	}
  
}
