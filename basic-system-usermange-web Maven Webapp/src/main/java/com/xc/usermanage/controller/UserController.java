package com.xc.usermanage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xc.houserental.controller.CommonCotroller;
import com.xc.system_usermanage_core.service.UserAccountService;
import com.xc.system_usermanage_core.service.UserService;
@Controller
@RequestMapping("/admin/user")
public class UserController extends CommonCotroller {
	static Logger log = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService ;
	private UserAccountService userAccountService;
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
	@RequestMapping(value="/checkpasswd",method=RequestMethod.GET)
	public void findcheckpasswd(String useAccountid,String oldpasswd,HttpServletResponse response) throws IOException{
		String equStr ="true";
		if(!userAccountService.checkoldPasswd(useAccountid, oldpasswd)){
			equStr ="false";
		}
		this.responseJson(equStr, response);
	}
}
