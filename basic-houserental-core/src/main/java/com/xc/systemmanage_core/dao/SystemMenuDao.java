package com.xc.systemmanage_core.dao;

import java.util.List;

import com.xc.basic.hibernate.dao.IBaseDao;
import com.xc.systemmanage_core.model.SystemMenu;
/**
 * <p>Title:菜单dao </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年4月1日
 */
public interface SystemMenuDao extends IBaseDao<SystemMenu> {
	/**
	 * <p>Description:根据角色和菜单类型获取菜单<p>
	 * @param roleCode 角色代码
	 * @param menuType 菜单类型
	 * @return
	 * @author wanglei 2018年4月1日
	 */
	public List<SystemMenu> findSystemMenuByRoleCode(String roleCode,Integer menuType);
}
