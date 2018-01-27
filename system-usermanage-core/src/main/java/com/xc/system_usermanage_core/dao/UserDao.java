package com.xc.system_usermanage_core.dao;

import com.xc.basic.hibernate.dao.IBaseDao;
import com.xc.basic.model.Pager;
import com.xc.system_usermanage_core.model.UserInfo;

/**
 * <p>Title:用户信息数据库操作接口 </p>
 * <p>Description: 包含用户信息的增删改查 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月25日
 */
public interface UserDao extends IBaseDao<UserInfo>{
	/**
	 * <p>Description:<p>
	 * @return
	 * @author wanglei 2018年1月27日
	 */
	Pager<UserInfo> findUserListByPage(Pager<UserInfo> pager);
}
