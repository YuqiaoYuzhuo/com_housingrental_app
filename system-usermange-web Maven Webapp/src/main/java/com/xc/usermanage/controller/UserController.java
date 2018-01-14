package com.xc.usermanage.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.houserental.controller.CommonCotroller;
@Controller
@RequestMapping("/admin/user")
public class UserController extends CommonCotroller {
	static Logger log = Logger.getLogger(UserController.class);
	@RequestMapping("/users")
	public String findUserPage(){
		return "/user/userlist";
	}
}
