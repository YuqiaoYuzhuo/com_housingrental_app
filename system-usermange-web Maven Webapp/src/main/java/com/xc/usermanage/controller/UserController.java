package com.xc.usermanage.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xc.houserental.controller.CommonCotroller;
@Controller
@RequestMapping("/admin/user")
public class UserController extends CommonCotroller {
	static Logger log = Logger.getLogger(UserController.class);
	@RequestMapping("/users")
	public String findUserPage(){
		return "/admin/user/userlist";
	}
	
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String findprofile(){
		return "/admin/user/profile";
	}
	@RequestMapping(value="/updatepasswd",method=RequestMethod.GET)
	public String findupdatepasswd(){
		return "/admin/user/updatepassd";
	}
}
