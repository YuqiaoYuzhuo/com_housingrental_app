package com.xc.systemmanage_core.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xc.basic.hibernate.dao.BaseDao;
import com.xc.systemmanage_core.dao.SystemMenuDao;
import com.xc.systemmanage_core.model.SystemMenu;
@Repository("systemMenuDao")
public class SystemMenuDaoImpl extends BaseDao<SystemMenu> implements SystemMenuDao {
	@Override
	public List<SystemMenu> findSystemMenuByRoleCode(String roleCode,Integer menuType) {
		String hql = this.getHqlByHqlName("findByRoleCodeAndType");
		Map<String,Object> alias = new HashMap<>();
		alias.put("roleCode", roleCode);
		alias.put("menuType", menuType);
		return this.listByhqlWithAlias(hql, alias);
	}

}
