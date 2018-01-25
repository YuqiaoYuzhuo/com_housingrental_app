package com.xc.basic.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


public class SystemPropertiesUtil
{

    private final static Logger logger  = LoggerFactory.getLogger(SystemPropertiesUtil.class.getName());    
    private static Properties props = null;    
    private static String file_name  = null;    
    private static Map<String,String> allpropsValue = null;
  //文件上传临时路径
    private static final String system_upload_temp_dir ="system_upload_temp_dir";
    /**
     * 文件上传路径
     */
    private static final String system_upload_dir ="system_upload_dir";
    /**
     * 文件下载临时路径
     */
    private static final String system_download_temp_dir ="system_download_temp_dir";
    /**
     * 系统名称
     */
    private static final String system_name ="system_name";
    /**
     * 系统静态资源路径
     */
    private static final String system_static_sourceurl_prefix ="system_static_sourceurl_prefix";
    /**
     * 系统版权
     */
    private static final String system_copyright ="system_copyright";
    /**
     * 系统css后缀
     */
    private static final String system_static_sourceurl_csssuffix ="system_static_sourceurl_csssuffix";
    
    /**
     * 初始化system.propeties
     * <p>Description:<p>
     * @author wanglei 2018-1-24
     */
    public static void loadPropertiesInit(String propertiesfileName){  
        file_name = propertiesfileName;
        props = new Properties();  
            try {  
            	 EncodedResource encodedResource = new EncodedResource(new ClassPathResource(propertiesfileName), "UTF-8");
                props=PropertiesLoaderUtils.loadProperties(encodedResource); 
                allpropsValue = new HashMap<String, String>();
                for(Object key:props.keySet()){  
                    logger.debug(key+":");  
                    logger.debug(props.get(key).toString());  
                    allpropsValue.put(key.toString(), props.get(key).toString());
                }  
                logger.info("system.properties load success over.......");
            } catch (IOException e) {  
                logger.error(e.getMessage());
            }               
     }
    
    public static Properties getProps(){
        return props;
    }
    
    
    public static String getSystemName() {
		return getPropertyValue(system_name);
	}

	public static String getSystemStaticSourceurlPrefix() {
		return getPropertyValue(system_static_sourceurl_prefix);
	}

	public static String getSystemCopyright() {
		return getPropertyValue(system_copyright);
	}

	public static String getSystemStaticSourceurlCsssuffix() {
		return getPropertyValue(system_static_sourceurl_csssuffix);
	}
	
	public static String getSystemUploadTempDir() {
		return getPropertyValue(system_upload_temp_dir);
	}
	 public static String getDownloadTempPathPropertyValue(){
	        return getPropertyValue(system_download_temp_dir);
	    }
	    public static String getUploadTempPathPropertyValue(){
	        return getPropertyValue(system_upload_temp_dir);
	    }
	    
	    public static String getUploadPathPropertyValue(){
	        return getPropertyValue(system_upload_dir);
	    }
	public static String getPropertyValue(String key){
        if(props.containsKey(key)){
            return props.getProperty(key);
        }else{
            logger.warn(" key ["+key+"]  not in system.properties file ......." );
            return null;
        }          
    }

	public static String getFile_name() {
		return file_name;
	}

	public static Map<String, String> getAllpropsValue() {
		return allpropsValue;
	}
    
    
}
