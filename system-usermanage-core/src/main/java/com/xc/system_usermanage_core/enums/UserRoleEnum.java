package com.xc.system_usermanage_core.enums;

/**
 * <p>Title:用户角色信息枚举 </p>
 * <p>Description:用户角色信息枚举 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月28日
 */
public enum UserRoleEnum {
	//系统管理员
	ROLE_ADMIN("管理员用户","R00001"),
	//房主
	ROLE_USER_HOUSE_OWNER("房主用户","R00002"),
	//租住房客
	ROLE_RENTING_USER("租客用户","R00003");
	private String roleName;
	private String roleCode;
	
	private UserRoleEnum(String roleName,String roleCode){
		this.roleName=roleName;
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
}
