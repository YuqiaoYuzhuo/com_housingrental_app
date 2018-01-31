package com.xc.system_usermanage_core.service;

import com.xc.basic.model.Pager;
import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.model.UserInfo;
import com.xc.system_usermanage_core.model.UserInofAndAccountQm;

/**
 * <p>Title:用户信息的Service接口 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月25日
 */
public interface UserService {
	/**
	 * <p>Description:pc端用户注册<p>
	 * @param userAccount 用户账号
	 * @author wanglei 2018年1月27日
	 */
	public void addPcRegister(UserAccount userAccount);
	/**
	 * <p>Description:微信端用户注册<p>
	 * @param userAccount 用户账号信息
	 * @author wanglei 2018年1月28日
	 */
	public void addWxRegister(UserAccount userAccount);
	/**
	 * <p>Description:后台管理员添加<p>
	 * @param userAccount 用户账号
	 * @author wanglei 2018年1月28日
	 */
	public void addAdminRegister(UserAccount userAccount);
	/**
	 * <p>Description:删除用户<p>
	 * @param id 用户id
	 * @author WangLei 2018-1-25
	 */
	public void delete(String id);
	/**
	 * <p>Description:更新用户状态。如果开启则停用如果停用则开启<p>
	 * @param uid 用户id
	 * @author WangLei 2018-1-25
	 */
	public void update(UserInfo userInfo) ;
	/**
	 * <p>Description:查询用户列表<p>
	 * @return 分页
	 * @author WangLei 2018-1-25
	 */
	public Pager<UserInfo> findUserListByPage(Pager<UserInfo> pager);
	/**
	 * <p>Description:根据主键查询用户信息<p>
	 * @param uid 用户主键
	 * @return 用户信息
	 * @author wanglei 2018年1月27日
	 */
	public UserInfo loadUser(String uid);
	
	/**
	 * <p>Description:用户登录<p>
	 * @param username 用户名
	 * @param password 用户密码
	 * @return 用户信息和账号信息
	 * @author WangLei 2017年2月5日
	 */
	public UserInofAndAccountQm getLogin(String username, String password);
	/**
	 * <p>Description:获取当前登录用户<p>
	 * @return 用户信息
	 * @author WangLei 2017年2月11日
	 */
	public UserInofAndAccountQm getCurentLoginUser();

}
