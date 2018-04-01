package com.xc.systemmanage_core.model;
import java.io.Serializable;
    /*
     *系统角色菜单关联关系表
     *
     */
public class RoleMenuRel implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *关联标示
     *
     */
    private String roleMenuRelUuid;
    /**
     *角色代码
     *
     */
    private String roleCode;
    /**
     *菜单标示
     *
     */
    private String menuUuid;

    public String getRoleMenuRelUuid(){
        return roleMenuRelUuid;
    }
    
    public void setRoleMenuRelUuid(String roleMenuRelUuids){
        this.roleMenuRelUuid = roleMenuRelUuids;
    }

    public String getRoleCode(){
        return roleCode;
    }
    
    public void setRoleCode(String roleCodes){
        this.roleCode = roleCodes;
    }

    public String getMenuUuid(){
        return menuUuid;
    }
    
    public void setMenuUuid(String menuUuids){
        this.menuUuid = menuUuids;
    }
    public RoleMenuRel(){
     	super();
	}
	@Override
	public String toString() {
		return "RoleMenuRel ["+""
		 + "roleMenuRelUuid="+roleMenuRelUuid+","
		 + "roleCode="+roleCode+","
		 + "menuUuid="+menuUuid+","
		  + "]";
	}
}