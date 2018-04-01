package com.xc.systemmanage_core.model;
import java.io.Serializable;
import java.sql.Timestamp;
    /*
     *系统菜单
     *
     */
public class SystemMenu implements Serializable{
    /**
	 * 自动生成 serialVersionUID
	 */
 private static final long serialVersionUID = 1L;
 
    /**
     *菜单标示
     *
     */
    private String menuUuid;
    /**
     *菜单名称
     *
     */
    private String menuName;
    /**
     *菜单类型
     *
     */
    private Integer menuType;
    /**
     *菜单路径
     *
     */
    private String menuUrl;
    /**
     *父级菜单标示
     *
     */
    private String menuParentUuid;
    /**
     *创建人标示
     *
     */
    private String createUserUuid;
    /**
     *创建人
     *
     */
    private String createUserName;
    /**
     *创建时间
     *
     */
    private Timestamp createTime;
    /**
     *排序
     *
     */
    private Integer menuOrder;
    /**
     *菜单状态
     *
     */
    private Integer menuStaus;
    /**
     *菜单的图标
     *
     */
    private String menuRemark;

    public String getMenuUuid(){
        return menuUuid;
    }
    
    public void setMenuUuid(String menuUuids){
        this.menuUuid = menuUuids;
    }

    public String getMenuName(){
        return menuName;
    }
    
    public void setMenuName(String menuNames){
        this.menuName = menuNames;
    }

    public Integer getMenuType(){
        return menuType;
    }
    
    public void setMenuType(Integer menuTypes){
        this.menuType = menuTypes;
    }

    public String getMenuUrl(){
        return menuUrl;
    }
    
    public void setMenuUrl(String menuUrls){
        this.menuUrl = menuUrls;
    }

    public String getMenuParentUuid(){
        return menuParentUuid;
    }
    
    public void setMenuParentUuid(String menuParentUuids){
        this.menuParentUuid = menuParentUuids;
    }

    public String getCreateUserUuid(){
        return createUserUuid;
    }
    
    public void setCreateUserUuid(String createUserUuids){
        this.createUserUuid = createUserUuids;
    }

    public String getCreateUserName(){
        return createUserName;
    }
    
    public void setCreateUserName(String createUserNames){
        this.createUserName = createUserNames;
    }

    public Timestamp getCreateTime(){
        return createTime;
    }
    
    public void setCreateTime(Timestamp createTimes){
        this.createTime = createTimes;
    }

    public Integer getMenuOrder(){
        return menuOrder;
    }
    
    public void setMenuOrder(Integer menuOrders){
        this.menuOrder = menuOrders;
    }

    public Integer getMenuStaus(){
        return menuStaus;
    }
    
    public void setMenuStaus(Integer menuStauss){
        this.menuStaus = menuStauss;
    }

    public String getMenuRemark(){
        return menuRemark;
    }
    
    public void setMenuRemark(String menuRemarks){
        this.menuRemark = menuRemarks;
    }
    public SystemMenu(){
     	super();
	}
    
	public SystemMenu(String menuUuid) {
		super();
		this.menuUuid = menuUuid;
	}

	@Override
	public String toString() {
		return "SystemMenu ["+""
		 + "menuUuid="+menuUuid+","
		 + "menuName="+menuName+","
		 + "menuType="+menuType+","
		 + "menuUrl="+menuUrl+","
		 + "menuParentUuid="+menuParentUuid+","
		 + "createUserUuid="+createUserUuid+","
		 + "createUserName="+createUserName+","
		 + "createTime="+createTime+","
		 + "menuOrder="+menuOrder+","
		 + "menuStaus="+menuStaus+","
		 + "menuRemark="+menuRemark+","
		  + "]";
	}
}