package com.xc.system_usermanage_core.dao;

import com.xc.basic.hibernate.dao.IBaseDao;
import com.xc.system_usermanage_core.model.UserAccount;

/**
 * <p>Title:用户账号数据库操作接口 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月27日
 */
public interface UserAccountDao extends IBaseDao<UserAccount> {
	/**
	 * <p>Description:根据用户标示查询用户账号信息<p>
	 * @param userUuid 用户标示
	 * @return 用户账号信息
	 * @author wanglei 2018年1月27日
	 */
	public UserAccount findUserAccountByUseruuid(String userUuid);
	/**
	 * <p>Description:根据用户账号和密码查询用户账号信息<p>
	 * @param acount 用户账号
	 * @param passswd 密码
	 * @return 用户账号信息
	 * @author wanglei 2018年1月27日
	 */
	public UserAccount findUserAccountByUserAccountAndPasswd(String acount,String passswd);
}
