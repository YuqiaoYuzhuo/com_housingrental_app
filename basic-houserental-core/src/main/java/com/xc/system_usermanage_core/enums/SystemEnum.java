package com.xc.system_usermanage_core.enums;

/**
 * <p>Title:用户枚举类 </p>
 * <p>Description:用户枚举类 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月28日
 */
public enum SystemEnum {
	//菜单类型
	MENU_TYPE_BACK("系统后台菜单",1);
	private String name;
	private Integer value;
	private SystemEnum(String name, Integer value) {
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
