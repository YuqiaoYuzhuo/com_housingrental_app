package com.xc.systemmanage_core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.systemmanage_core.dao.SystemMenuDao;
import com.xc.systemmanage_core.model.SystemMenu;
import com.xc.systemmanage_core.service.SystemMenuService;
@Service("systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService{
	@Autowired
	private SystemMenuDao systemMenuDao;
	@Override
	public List<SystemMenu> findSystemMenuByRoleCodeAndType(String roleCode,
			Integer menuType) {
		return systemMenuDao.findSystemMenuByRoleCode(roleCode, menuType);
	}

}
