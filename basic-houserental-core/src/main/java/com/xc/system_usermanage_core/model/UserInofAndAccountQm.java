package com.xc.system_usermanage_core.model;


/**
 * <p>Title:用户信息和用户账号的查询实体类 </p>
 * <p>Description:查询用户信息和账号信息 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月27日
 */
public class UserInofAndAccountQm {
	/**
	 * 用户账号信息
	 */
	private UserAccount userAcc;
	/**
	 * 用户信息
	 */
	private UserInfo userInfo;
	public UserAccount getUserAcc() {
		return userAcc;
	}
	public void setUserAcc(UserAccount userAcc) {
		this.userAcc = userAcc;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserInofAndAccountQm(UserAccount userAcc, UserInfo userInfo) {
		super();
		this.userAcc = userAcc;
		this.userInfo = userInfo;
	}
	@Override
	public String toString() {
		return "UserInofAndAccountQm [userAcc=" + userAcc + ", userInfo="
				+ userInfo + "]";
	}
	public UserInofAndAccountQm() {
		super();
	}
	
	
}
