package com.xc.system_usermanage_core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.basic.exception.BusinessException;
import com.xc.basic.model.Pager;
import com.xc.basic.util.UUIDGenerator;
import com.xc.system_usermanage_core.dao.UserDao;
import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.model.UserInfo;
import com.xc.system_usermanage_core.model.UserInofAndAccountQm;
import com.xc.system_usermanage_core.service.UserAccountService;
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
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserAccountService userAccountService;
	@SuppressWarnings("null")
	@Override
	public void addRegister(UserAccount userAccount) {
		if(null!=userAccount){
			throw new BusinessException("注册失败!用户账号信息不能为空！");
		}
		//赋值用户账号信息
		String userUuid = UUIDGenerator.createUUID();
		userAccount.setUserAccountUuid(UUIDGenerator.createUUID());
		userAccount.setUserAccUserUuid(userUuid);
		userAccount.setErrorNum(0);
		userAccount.setUserAccountStaus(1);
		//赋值用户信息
		UserInfo userInfo = new UserInfo();
		userInfo.setUserUuid(userUuid);
		//增加用户信息
		userDao.add(userInfo);
		//增加用户账号信息
		userAccountService.addUserAccount(userAccount);
	}

	@Override
	public void delete(String id) {
		//先删除用户信息
		userDao.delete(id);
		//在删除用户账号信息
		userAccountService.deleteUserAccountByUserId(id);
	}

	@Override
	public void update(UserInfo userInfo, UserAccount userAccount) {
		//更新用户信息
		userDao.update(userInfo);
		//更新用户账号信息
		userAccountService.updateUserAccount(userAccount);
	}
	@Override
	public void update(UserInfo userInfo) {
		userDao.update(userInfo);
	}

	@Override
	public Pager<UserInfo> findUserListByPage(Pager<UserInfo> pager) {
		return userDao.findUserListByPage(pager);
	}

	@Override
	public UserInfo loadUser(String uid) {
		return userDao.load(uid);
	}

	@SuppressWarnings("null")
	@Override
	public UserInofAndAccountQm getLogin(String username, String password) {
		UserInofAndAccountQm uaqm = new UserInofAndAccountQm();
		UserAccount userAccount = null;
		userAccount = userAccountService.findUserAccountByUserAccountAndPasswd(username, password);
		if(null!=userAccount){
			throw new BusinessException("账号或密码错误!");
		}
		//登录后获取用户信息
		UserInfo userIfno = this.loadUser(userAccount.getUserAccUserUuid());
		if(null == userIfno){
			throw new BusinessException("获取用户信息错误!");
		}
		uaqm.setUserInfo(userIfno);
		uaqm.setUserAcc(userAccount);
		return uaqm;
	}

	@Override
	public UserInfo getCurentLoginUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
