package com.xc.houserental.web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;


public class InitServlet extends HttpServlet {
	static Logger log = Logger.getLogger(InitServlet.class);
	private static final long serialVersionUID = 1L;
	private static WebApplicationContext wc;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
//		//初始化spring的工厂
//		log.info("------------------------初始化spring工厂:-----------------------------");
//		wc = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//		log.info("------------------------初始化权限信息:-----------------------------");
//		//初始化权限信息
//		Map<String,Set<String>> auths = AuthUtil.initAuth("com.wanglei.graempinf.controller");
//		this.getServletContext().setAttribute("allAuths", auths);
//		this.getServletContext().setAttribute("baseInfo", BaseInfoUtil.getInstacne().read());
//		log.info("------------------------系统初始化成功:"+auths+"-----------------------------");
	}
	
	public static WebApplicationContext getWc() {
		return wc;
	}

}
