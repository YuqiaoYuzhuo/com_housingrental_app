package com.xc.houserental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.xc.basic.model.UserSession;
import com.xc.system_usermanage_core.model.UserInofAndAccountQm;

/**
 * <p>Title:权限验证方法 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月14日
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = Logger.getLogger(AuthInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		/*
		 * 如果使用uploadify进行文件的上传，由于flash的bug问题，会产生一个新的session，此时验证失败
		 * 所以必须在此处获取一个原有的session，然后重置session信息
		 */
		String sid = request.getParameter("sid");
		if(sid!=null&&!"".equals(sid.trim())) {
			//当sid有值，就表示是通过uploadify上传文件，此时就应该获取原有的session
			session = ProjectSessionContext.getSession(sid);
		}
		HandlerMethod hm = (HandlerMethod)handler;
		UserInofAndAccountQm user = (UserInofAndAccountQm)session.getAttribute("loginUser");
		if(user==null) {
			request.setAttribute("logginTimeOut", true);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			return false;
		}
//		} else {
//			boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
//			if(!isAdmin) {
//				//不是超级管理人员，就需要判断是否有权限访问某些功能
//				Set<String> actions = (Set<String>)session.getAttribute("allActions");
//				String aname = hm.getBean().getClass().getName()+"."+hm.getMethod().getName();
//				if(!actions.contains(aname)) {
//				logger.debug("--------------用户：["+user.getUserAcc().getUaserAccountNum()+"]访问资源"+aname+"受到权限限制!----------");
//				throw new BusinessException("没有权限访问该功能，请联系管理员");};
//			}
			String ip = request.getHeader("x-forwarded-for");
		       if(ip == null || ip.length() == 0|| "unknown".equalsIgnoreCase(ip)) {
		           ip = request.getHeader("Proxy-Client-IP");
		       }
		       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		           ip = request.getHeader("WL-Proxy-Client-IP");
		       }
		       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		           ip = request.getRemoteAddr();
		          
		       }
		     session.setAttribute("ip", ip);
			 UserSession.set("userSession", session);
		     UserSession.set("loginUser", user);
//		}
		return super.preHandle(request, response, handler);
	}
}
