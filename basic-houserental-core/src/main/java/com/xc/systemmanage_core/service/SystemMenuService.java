package com.xc.systemmanage_core.service;

import java.util.List;

import com.xc.systemmanage_core.model.SystemMenu;

/**
 * <p>Title:系统菜单接口</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年4月1日
 */
public interface SystemMenuService {
	/**
	 * <p>Description:根据角色编码和菜单类型获取菜单列表<p>
	 * @param roleCode 角色编码
	 * @param menuType 菜单类型
	 * @return 菜单列表
	 * @author wanglei 2018年4月1日
	 */
	public List<SystemMenu> findSystemMenuByRoleCodeAndType(String roleCode,Integer menuType);
}
