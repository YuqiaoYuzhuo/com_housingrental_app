package com.xc.system_usermanage_core.service;

import com.xc.basic.model.Pager;
import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.model.UserInfo;

/**
 * <p>Title:用户信息的Service接口 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月25日
 */
public interface UserService {
	public void add(UserInfo userInfo ,UserAccount userAccount);
	/**
	 * <p>Description:删除用户<p>
	 * @param id 用户id
	 * @author WangLei 2018-1-25
	 */
	public void delete(String id);
	/**
	 * <p>Description:更新用户信息，如果rids的角色在用户中已经存在不做操作，
	 * 如果rids在用户中不存在就要添加角色，如果用户的角色不存在于Rids中则要删除
	 * 用户组同理<p>
	 * @param user 用户
	 * @param rids 角色信息
	 * @param gids 用户id
	 * @author WangLei 2018-1-25
	 */
	public void update(UserInfo userInfo ,UserAccount userAccount);
	/**
	 * <p>Description:更新用户状态。如果开启则停用如果停用则开启<p>
	 * @param uid 用户id
	 * @author WangLei 2018-1-25
	 */
	
	public void updateStatus(String uid);
	/**
	 * 更新密码方法
	 * @param uid 用户标示
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
       * @author WangLei 2018-1-25
	 */
	public void updatePwd(String uid,String oldPwd,String newPwd);
	public void update(UserInfo userInfo) ;
	/**
	 * <p>Description:查询用户列表<p>
	 * @return 分页
	 * @author WangLei 2018-1-25
	 */
	public Pager<UserInfo> findUserListByPage();
	public UserInfo loadUser(String uid);
	
	/**
	 * <p>Description:用户登录<p>
	 * @param username 用户名
	 * @param password 用户密码
	 * @return
	 * @author WangLei 2017年2月5日
	 */
	public UserInfo login(String username, String password);
	/**
	 * <p>Description:获取当前登录用户<p>
	 * @return
	 * @author WangLei 2017年2月11日
	 */
	public UserInfo getCurentLoginUser();
}
