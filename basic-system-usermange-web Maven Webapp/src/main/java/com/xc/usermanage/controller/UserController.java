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
	@Autowired
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
	@RequestMapping(value="/checkpasswd",method=RequestMethod.POST)
	public void findcheckpasswd(String oldpasswd,HttpServletResponse response) throws IOException{
		String equStr ="true";
		String useAccountid = userService.getCurentLoginUser().getUserAcc().getUserAccountUuid();
		if(!userAccountService.checkoldPasswd(useAccountid, oldpasswd)){
			equStr ="false";
		}
		this.responseJson(equStr, response);
	}
	@RequestMapping(value="/updatepasswdsave",method=RequestMethod.POST)
	public void updatepasswdsave(String newpassword,String oldpasswd,HttpServletResponse response) throws IOException{
		String msg = "恭喜你！修改密码成功！";
		String useAccountid = userService.getCurentLoginUser().getUserAcc().getUserAccountUuid();
		try {
			userAccountService.updatePwd(useAccountid, oldpasswd, newpassword);
		} catch (Exception e) {
			msg = e.getMessage();
			log.debug(e.getMessage());
		}
		this.responseJson(msg, response);
	}
}
