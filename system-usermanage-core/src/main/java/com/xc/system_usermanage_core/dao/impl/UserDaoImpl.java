package com.xc.system_usermanage_core.dao.impl;

import org.springframework.stereotype.Repository;

import com.xc.basic.hibernate.dao.BaseDao;
import com.xc.system_usermanage_core.dao.UserDao;
import com.xc.system_usermanage_core.model.UserInfo;
/**
 * <p>Title: 用户信息数据库持久接口实现</p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月25日
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao<UserInfo> implements UserDao {

}
