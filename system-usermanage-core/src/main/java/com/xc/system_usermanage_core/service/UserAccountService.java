package com.xc.system_usermanage_core.service;

import com.xc.system_usermanage_core.model.UserAccount;

/**
 * <p>Title: 用户账号实现接口</p>
 * <p>Description: 实现用户账号业务操作 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月27日
 */
public interface UserAccountService {
	/**
	 * <p>Description:用户注册<p>
	 * @param useAccount 用户账号
	 * @author wanglei 2018年1月27日
	 */
	public void addUserAccount(UserAccount useAccount);
	/**
	 * 更新密码方法
	 * @param uid 用户标示
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
       * @author WangLei 2018-1-25
	 */
	public void updatePwd(String uid,String oldPwd,String newPwd);
	/**
	 * <p>Description:更新用户状态<p>
	 * @param uid 用户标示
	 * @param status 状态
	 * @author wanglei 2018年1月27日
	 */
	public void updateStatus(String uid,Integer status);
	/**
	 * <p>Description:删除用户账号信息<p>
	 * @param useruid 用户账号标示
	 * @author wanglei 2018年1月27日
	 */
	public void deleteUserAccount(String userAccountuid);
	/**
	 * <p>Description:根据用户标示查询用户账号信息<p>
	 * @param userUuid 用户标示
	 * @author wanglei 2018年1月27日
	 */
	public UserAccount findUserAccountByUserUuid(String userUuid);
	/**
	 * <p>Description:根据用户账号和密码查询用户账号信息<p>
	 * @param acount 用户账号
	 * @param passswd 密码
	 * @return 用户账号信息
	 * @author wanglei 2018年1月27日
	 */
	public UserAccount findUserAccountByUserAccountAndPasswd(String acount,String passswd);
	/**
	 * <p>Description:根据用户标示删除用户账号信息<p>
	 *  @param userUuid 用户标示
	 * @author wanglei 2018年1月27日
	 */
	public void deleteUserAccountByUserId(String userUuid);
	/**
	 * <p>Description:更新用户账号信息<p>
	 * @param userAccount 用户账号
	 * @author wanglei 2018年1月27日
	 */
	public void updateUserAccount(UserAccount userAccount);
	/**
	 * <p>Description:校验原始密码是否正确<p>
	 * @param useaccountrid 用户id
	 * @param oldPassd 旧密码
	 * @return
	 * @author wanglei 2018年1月31日
	 */
	public boolean checkoldPasswd(String useaccountrid,String oldPassd);
}
