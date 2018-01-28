package com.xc.system_usermanage_core.enums;

/**
 * <p>Title:用户类型枚举 </p>
 * <p>Description:用户类型枚举 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月28日
 */
public enum UserTypeEnum {
	//后台管理员用户
	USER_TYEP_BACKSTAGE_ADMIN("后台管理员用户","backStageAdmin"),
	//后台房主用户
	USER_TYEP_BACKSTAGE_HOUSEOWNER("后台房主用户","backStageHouseOwner"),
	//后台租住用户
	USER_TYEP_BACKSTAGE_RENTINGUSER("后台租住用户","backStageRentingUser"),
	//微信租住用户
	USER_TYEP_WX_RENTINGUSER("微信租住用户","wxRentingUser");
	private String userTypeName;
	private String userTypeCode;
	private UserTypeEnum(String userTypeName, String userTypeCode) {
		this.userTypeName = userTypeName;
		this.userTypeCode = userTypeCode;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getUserTypeCode() {
		return userTypeCode;
	}
	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

}
