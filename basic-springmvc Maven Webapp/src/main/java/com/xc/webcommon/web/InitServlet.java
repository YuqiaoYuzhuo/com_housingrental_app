package com.xc.webcommon.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xc.basic.util.SystemPropertiesUtil;


public class InitServlet extends HttpServlet {
	static Logger log = Logger.getLogger(InitServlet.class);
	private static final long serialVersionUID = 1L;
	private static WebApplicationContext wc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//初始化spring的工厂
		log.info("------------------------初始化spring工厂:-----------------------------");
		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		log.info("------------------------初始化系统配置文件:-----------------------------");
		//初始化系统配置文件
		SystemPropertiesUtil.loadPropertiesInit(this.getServletContext().getInitParameter("systemPropertiesFileName"));
		//放到ServletContext()容器里
		this.getServletContext().setAttribute("SysPro", SystemPropertiesUtil.getAllpropsValue());
		System.out.println(this.getServletContext().getAttribute("SysPro"));
		log.info("------------------------化系统配置文件初始化成功:-----------------------------");
	}
	
	public static WebApplicationContext getWc() {
		return wc;
	}

}
