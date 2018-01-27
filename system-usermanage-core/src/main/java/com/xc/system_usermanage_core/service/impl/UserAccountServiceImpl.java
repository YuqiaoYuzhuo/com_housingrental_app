package com.xc.system_usermanage_core.service.impl;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xc.basic.exception.BusinessException;
import com.xc.basic.util.SecurityUtil;
import com.xc.system_usermanage_core.dao.UserAccountDao;
import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.service.UserAccountService;
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {
	private static Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class.getName());  
	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public void updatePwd(String uid, String oldPwd, String newPwd) {
		UserAccount temUacc  = userAccountDao.findUserAccountByUseruuid(uid);
		//如果用户不存在不能更新
		if(null==temUacc){
			logger.debug("用户不存在不能修改密码");
			throw new BusinessException("用户不存在不能修改密码!");
		}
		String securityPassd = null;
		String securityNewPassd = null;
		//密码加密
		try {
		   securityPassd = SecurityUtil.md5(temUacc.getUaserAccountNum(),oldPwd);
		   securityNewPassd = SecurityUtil.md5(temUacc.getUaserAccountNum(),newPwd);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		}
		if(!securityPassd.equals(temUacc.getUserAccountPassword())){
			logger.debug("和原密码不一致，不能修改!");
			throw new BusinessException("和原密码不一致，不能修改!");
		}
		temUacc.setUserAccountPassword(securityNewPassd);
		userAccountDao.update(temUacc);
	}

	@Override
	public void updateStatus(String uid, Integer status) {
		UserAccount temUacc  = userAccountDao.findUserAccountByUseruuid(uid);
		//如果用户不存在不能更新
		if(null==temUacc){
			throw new BusinessException("用户不存在不能更改状态!");
		}
		temUacc.setUserAccountStaus(status);
		userAccountDao.update(temUacc);
	}

	@Override
	public void addUserAccount(UserAccount useAccount) {
		userAccountDao.add(useAccount);
	}

	@Override
	public UserAccount findUserAccountByUserUuid(String userUuid) {
		return userAccountDao.findUserAccountByUseruuid(userUuid);
	}

	@Override
	public UserAccount findUserAccountByUserAccountAndPasswd(String acount,
			String passswd) {
		String securityPassd = null;
		//密码加密
		try {
		   securityPassd = SecurityUtil.md5(acount,passswd);
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage());
		}
		return userAccountDao.findUserAccountByUserAccountAndPasswd(acount, securityPassd);
	}

	@Override
	public void deleteUserAccount(String userAccountuid) {
		userAccountDao.delete(userAccountuid);
	}

	@Override
	public void deleteUserAccountByUserId(String userUuid) {
		UserAccount temUacc  = userAccountDao.findUserAccountByUseruuid(userUuid);
		userAccountDao.delete(temUacc.getUserAccountUuid());
	}

	@Override
	public void updateUserAccount(UserAccount userAccount) {
		userAccountDao.update(userAccount);
	}

}
