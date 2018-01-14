package com.xc.basic.hibernate.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xc.basic.hibernate.dao.BaseDao;
import com.xc.basic.hibernate.model.User;
import com.xc.basic.model.Pager;
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public List<User> listUserByhqlWithParams(String string, Object[] objects) {
		// TODO Auto-generated method stub
		return super.listByhqlWithParams(string, objects);
	}

	@Override
	public List<User> listUserByhqlWithAliasAndParams(String string, Object[] objects, Map<String, Object> ails) {
		// TODO Auto-generated method stub
		return super.listByhqlWithAliasAndParams(string, objects, ails);
	}

	@Override
	public Pager<User> findUserByhqlWithParams(String string, Object[] objects) {
		// TODO Auto-generated method stub
		return super.findByhqlWithParams(string, objects);
	}

	@Override
	public Pager<User> findUserByHqlWithParamsAndalias(String string, Object[] objects, Map<String, Object> ails) {
		// TODO Auto-generated method stub
		return super.findByHqlWithParamsAndalias(string, objects, ails);
	}

	@Override
	public List<User> listUserBysqlWithParams(String string, Object[] objects, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return super.listBysqlWithParams(string, objects, class1, b);
	}

	@Override
	public List<User> listUserBysqlWithParamsAndalias(String string, Object[] objects, Map<String, Object> ails, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return super.listBysqlWithParamsAndalias(string, objects, ails, class1, b);
	}

	@Override
	public Pager<User> findUserBysqlWithParams(String string, Object[] objects, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return findBysqlWithParams(string, objects, class1, b);
	}

	@Override
	public Pager<User> findUserBysqlWithParamsAndalias(String string, Object[] objects, Map<String, Object> ails, Class<User> class1, boolean b) {
		// TODO Auto-generated method stub
		return super.findBysqlWithParamsAndalias(string, objects, ails, class1, b);
	}

}
