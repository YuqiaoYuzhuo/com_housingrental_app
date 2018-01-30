package com.xc.housingrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xc.houserental.controller.CommonCotroller;
/**
 * <p>Title:后台管理系统的首页controller </p>
 * <p>Description: 后台管理系统的首页controller</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月30日
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends CommonCotroller {
	/**
	 * <p>Description:系统后台首页<p>
	 * @return
	 * @author wanglei 2018年1月30日
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		return "/admin/index";
	}
	@RequestMapping(value="/welcomeindex",method=RequestMethod.GET)
	public String welcomeIndex(){
		return "/admin/index_v1";
	}
}
