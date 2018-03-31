package com.xc.houserental.excepthandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.xc.basic.exception.BusinessException;

/**
 * <p>Title:系统公共异常处理类 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月24日
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
	 private static final Logger logger = Logger.getLogger(MyExceptionHandler.class); 
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
 		 logger.error("发生错误啦!",ex);   
		//如果是业务异常则在前台提示业务异常信息 如果是系统系统则前台提示系统异常
         if(ex instanceof BusinessException){
        	 if(this.isAjaxRequest(request)){
        		 ModelAndView mv = new ModelAndView();  
                 /*  使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常   */  
                 FastJsonJsonView view = new FastJsonJsonView();  
                 Map<String, Object> attributes = new HashMap<String, Object>();  
            	 attributes.put("msg", ex.getMessage()); 
            	 attributes.put("error","false");
            	 view.setAttributesMap(attributes);  
                 mv.setView(view);   
                 return mv;  
        	 }else{
        		 return new ModelAndView("error").addObject("businessEx",ex.getMessage());  
        	 }
         }
         return new ModelAndView("error").addObject("exception","系统异常!"); 
	}
	/**
	 * <p>Description:判断请求是否为ajax请求<p>
	 * @param request 请求
	 * @return
	 * @author wanglei 2018年3月10日
	 */
	private boolean isAjaxRequest(HttpServletRequest request){  
	    String header = request.getHeader("X-Requested-With");  
	    boolean isAjax = "XMLHttpRequest".equals(header) ? true:false;  
	    return isAjax;  
	}  
}
