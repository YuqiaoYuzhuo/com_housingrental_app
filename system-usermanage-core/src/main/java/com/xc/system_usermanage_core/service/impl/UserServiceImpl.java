package com.xc.system_usermanage_core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xc.basic.model.Pager;
import com.xc.system_usermanage_core.dao.UserDao;
import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.model.UserInfo;
import com.xc.system_usermanage_core.service.UserService;

/**
 * <p>Title:用户service业务接口实现 </p>
 * <p>Description: 包含用户信息的最基本的增删改查</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月25日
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	@Override
	public void add(UserInfo userInfo, UserAccount userAccount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserInfo userInfo, UserAccount userAccount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatus(String uid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePwd(String uid, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pager<UserInfo> findUserListByPage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo loadUser(String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo getCurentLoginUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
