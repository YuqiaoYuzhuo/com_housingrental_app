package com.xc.basic.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
/**
 * <p>Title:spring缓存容器类 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月22日
 */
@Component("mySpringApplicationContext")
public class MySpringApplicationContext implements ApplicationContextAware
{
        /**
         * 当前spring ioc容器
         */
        private static ApplicationContext applicationContext;

        /**
         * 设置当前上下文环境，此方法由spring自动装配
         */
        @Override
        public void setApplicationContext(ApplicationContext arg0)
                throws BeansException {
            applicationContext = arg0;
        }

        /**
         * 从当前IOC获取bean
         * @param id
         * @param bean的id
         * @return
         */
        public static Object getObject(String id) {
            Object object = null;
            object = applicationContext.getBean(id);
            return object;
        }
}
