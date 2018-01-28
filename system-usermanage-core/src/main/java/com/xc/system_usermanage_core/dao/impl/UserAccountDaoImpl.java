package com.xc.system_usermanage_core.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xc.basic.exception.BusinessException;
import com.xc.basic.hibernate.dao.BaseDao;
import com.xc.system_usermanage_core.dao.UserAccountDao;
import com.xc.system_usermanage_core.enums.UserEnum;
import com.xc.system_usermanage_core.model.UserAccount;

/**
 * <p>Title:用户账号数据库操作接口实现类</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月27日
 */
@Repository("userAccountDao")
public class UserAccountDaoImpl extends BaseDao<UserAccount> implements
		UserAccountDao {

	@Override
	public UserAccount findUserAccountByUseruuid(String userUuid) {
		String hql = this.getHqlByHqlName("findUserAccByuserid");
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("userUuid", userUuid);
		return (UserAccount) this.queryObjectByHqlWithParamsAndaials(hql, alias);
	}

	@Override
	public UserAccount findUserAccountByUserAccountAndPasswd(String acount,
			String passswd) {
		String hql = this.getHqlByHqlName("findUserAccByuserAccountAndPass");
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("acount", acount);
		alias.put("passswd", passswd);
		UserAccount uc = (UserAccount) this.queryObjectByHqlWithParamsAndaials(hql, alias);
		if(uc!=null){
			//如果禁止登陆则登录失败
			if(uc.getUserAccountStaus()==UserEnum.USER_STATUS_LIMIT.getValue()){
				throw new BusinessException("该账号已经被禁止登陆请联系管理员！");
			}
		}
		return uc;
	}

	@Override
	public UserAccount findUserAccountByUserAccNum(String accNum) {
		String hql = this.getHqlByHqlName("findUserAccByuserAccount");
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("acount", accNum);
		return (UserAccount) this.queryObjectByHqlWithParamsAndaials(hql, alias);
	}

}
