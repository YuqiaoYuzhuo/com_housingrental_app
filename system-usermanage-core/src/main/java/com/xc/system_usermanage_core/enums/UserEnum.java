package com.xc.system_usermanage_core.enums;

/**
 * <p>Title:用户枚举类 </p>
 * <p>Description:用户枚举类 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月28日
 */
public enum UserEnum {
	//用户状态正常
	USER_STATUS_NOEMAL("正常",1),
	//用户状态禁止登陆
	USER_STATUS_LIMIT("禁止登陆",2),
	//用户性别-男
	USER_GENDER_MALE("男",1),
	//用户性别-女
	USER_GENDER_FEMALE("女",2);
	private String name;
	private Integer value;
	private UserEnum(String name, Integer value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
