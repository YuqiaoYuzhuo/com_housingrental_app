package com.xc.generatorcode.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.xc.basic.util.SystemPropertiesUtil;

public class PropertiesUtils {
	 private final static Logger logger  = LoggerFactory.getLogger(SystemPropertiesUtil.class.getName());    
	    private static Properties props = null;    
	    private static String file_name  = null;    
	    //文件上传临时路径
	    private static final String templatepath ="templatepath";
	    //数据库驱动
	    private static final String driver ="driver";
	    //数据库路径
	    private static final String url ="url";
	    //数据库 用户名
	    private static final String name ="name";
	    //数据库 密码
	    private static final String password ="password";
	    public static String getTemplatepath(){
	        return getPropertyValue(templatepath);
	    }
	    
	    public static String getFile_name() {
			return file_name;
		}

		public static void setFile_name(String file_name) {
			PropertiesUtils.file_name = file_name;
		}

		public static Logger getLogger() {
			return logger;
		}

		public static String getDriver() {
			return getPropertyValue(driver);
		}

		public static String getUrl() {
			return getPropertyValue(url);
		}

		public static String getName() {
			return getPropertyValue(name);
		}

		public static String getPassword() {
			return getPropertyValue(password);
		}

		public static void setProps(Properties props) {
			PropertiesUtils.props = props;
		}

		/**
	     * 初始化system.propeties
	     * <p>Description:<p>
	     * @author wanglei 2016-6-29
	     */
	    public static void loadPropertiesInit(String propertiesfileName){  
	        file_name = propertiesfileName;
	        props = new Properties();  
	            try {  
	                props=PropertiesLoaderUtils.loadAllProperties(file_name);  
	                for(Object key:props.keySet()){  
	                    logger.debug(key+":");  
	                    logger.debug(props.get(key).toString());  
	                }  
	                logger.info("system.properties load success over.......");
	            } catch (IOException e) {  
	                logger.error(e.getMessage());
	            }               
	     }
	    
	    public static Properties getProps(){
	        return props;
	    }
	    
		/**
		 * <p>Description:获取属性值<p>
		 * @param key
		 * @return
		 * @author wanglei 2018年1月21日
		 */
		public static String getPropertyValue(String key){
	        if(props.containsKey(key)){
	            return props.getProperty(key);
	        }else{
	            logger.warn(" key ["+key+"]  not in system.properties file ......." );
	            return null;
	        }          
	    }
	    
}
