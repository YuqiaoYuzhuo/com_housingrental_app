package com.xc.usermanage.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.model.UserInfo;
import com.xc.system_usermanage_core.service.UserAccountService;
import com.xc.system_usermanage_core.service.UserService;
import com.xc.webcommon.controller.CommonCotroller;
/**
 * <p>Title:用户信息管理controller </p>
 * <p>Description: 主要负责用户信息管理路由跳转</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年3月10日
 */
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
	
	/**
	 * <p>Description:获取用户信息<p>
	 * @param model 
	 * @return
	 * @author wanglei 2018年3月10日
	 */
	@RequestMapping(value="/profile",method=RequestMethod.GET)
	public String findprofile(Model model){
		String useAccountid = userService.getCurentLoginUser().getUserInfo().getUserUuid();
		 UserInfo userinf =  userService.loadUser(useAccountid);
		 model.addAttribute("uif", userinf);
		return "/admin/user/profile";
	}
	/**
	 * <p>Description:修改密码<p>
	 * @return
	 * @author wanglei 2018年3月10日
	 */
	@RequestMapping(value="/updatepasswd",method=RequestMethod.GET)
	public String findupdatepasswd(){
		return "/admin/user/updatepassd";
	}
	/**
	 * <p>Description:校验原密码<p>
	 * @param oldpasswd 旧密码
	 * @param response 
	 * @throws IOException
	 * @author wanglei 2018年3月10日
	 */
	@RequestMapping(value="/checkpasswd",method=RequestMethod.POST)
	public void findcheckpasswd(String oldpasswd,HttpServletResponse response) throws IOException{
		String equStr ="true";
		String useAccountid = userService.getCurentLoginUser().getUserAcc().getUserAccountUuid();
		if(!userAccountService.checkoldPasswd(useAccountid, oldpasswd)){
			equStr ="false";
		}
		this.responseJson(equStr, response);
	}
	/**
	 * <p>Description:修改密码保存<p>
	 * @param newpassword 新密码
	 * @param oldpasswd 旧密码
	 * @param response 
	 * @throws IOException
	 * @author wanglei 2018年3月10日
	 */
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
	/**
	 * <p>Description:用户注册<p>
	 * @param userAccount 用户账号信息
	 * @param response
	 * @throws IOException
	 * @author wanglei 2018年3月10日
	 */
	@RequestMapping(value="/addRegisterHouseOwner",method=RequestMethod.POST)
	public String addRegisterHouseOwner(UserAccount userAccount,HttpServletResponse response,Model model) throws IOException{
		String msg = "恭喜您,注册成功！欢迎登录！";
		userService.addPcRegister(userAccount);
		model.addAttribute("regmsg", msg);
		return "/login";
	}
	@RequestMapping(value="/toUpdateProfile",method=RequestMethod.GET)
	public String toUpdateProfile(Model model){
		 String useAccountid = userService.getCurentLoginUser().getUserInfo().getUserUuid();
		 UserInfo userinf =  userService.loadUser(useAccountid);
		 model.addAttribute("uif", userinf);
		return "/admin/user/editprofile";
	}
	@RequestMapping(value="/saveProfile",method=RequestMethod.POST)
	public void saveProfile(UserInfo userInfo,HttpServletResponse response) throws IOException{
		 userService.update(userInfo);
		this.responseJson(true, "修改信息成功!", response);
	}
	
}
