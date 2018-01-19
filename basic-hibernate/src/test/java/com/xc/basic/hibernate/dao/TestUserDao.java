package com.xc.basic.hibernate.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.xc.basic.hibernate.model.User;
import com.xc.basic.model.Pager;
import com.xc.basic.model.SystemContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/beans.xml")
public class TestUserDao {
       @Inject
	private SessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));

       }
	@After
	public void tearDown() throws Exception {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
	} 
	@Inject
	private IUserDao userDao;
	@Test
	public void testADD(){
		User u = new User();
		u.setName("张飞");
		System.out.println(userDao.add(u));
	}
	
	public void testDel(){
		userDao.delete("4028b88159890e0f0159890e11d10000");
	}
	
	public void testUp(){
		User u = new User();
		u.setId("4028b881598912b001598912b2960000");
		u.setName("张飞1");
		userDao.update(u);
	}
	
	public void testload(){
		System.out.println(userDao.load("4028b881598912b001598912b2960000"));
	}
	public void testListByags(){
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		List <User> users = userDao.listUserByhqlWithParams("from User where name like ?", new Object[]{"%张%"});
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
	
	public void testListByagsAndails(){
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		Map<String,Object> ails = new HashMap<String,Object>();
		ails.put("id","%4028b881598912%");
		List <User> users = userDao.listUserByhqlWithAliasAndParams("from User where name like ? and id like:id", new Object[]{"%张%"},ails);
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
	
	public void testFindByags(){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(5);
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		Pager<User> page = userDao.findUserByhqlWithParams(" from User where name like ? ", new Object[]{"%张%"});
		List<User> users = page.getDatas();
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
	
	public void testFindByagsAndails(){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(1);
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		Map<String,Object> ails = new HashMap<String, Object>();
		ails.put("id","%4028b881598912%");
		Pager<User> page = userDao.findUserByHqlWithParamsAndalias("from User where name like ? and id like:id", new Object[]{"%张%"},ails);
		List<User> users = page.getDatas();
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
	
	public void testListsqlByags(){
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		List <User> users = userDao.listUserBysqlWithParams("select * from user where name like ? and id like? ", new Object[]{"%张%","%4028b881598912%"},User.class,true);
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
	
	public void testListsqlByagsAndails(){
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		Map<String,Object> ails = new HashMap<String, Object>();
		ails.put("id","%4028b881598912%");
		List <User> users = userDao.listUserBysqlWithParamsAndalias("select * from user where name like ? and id like:id ",  new Object[]{"%张%"},ails,User.class,true);
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
	
	public void testfindsqltByags(){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(2);
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		Pager<User> page = userDao.findUserBysqlWithParams("select * from user where name like ? and id like ? ", new Object[]{"%张%","%4028b881598912%"},User.class,true);
		List<User> users = page.getDatas();
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
	
	public void testfindsqlByagsAndails(){
		SystemContext.setPageOffset(0);
		SystemContext.setPageSize(12);
		SystemContext.setOrder("id");
		SystemContext.setSort("desc");
		Map<String,Object> ails = new HashMap<String, Object>();
		ails.put("id","%4028b881598912%");
		Pager<User> page = userDao.findUserBysqlWithParamsAndalias("select * from user where name like ? and id like:id ",  new Object[]{"%张%"},ails,User.class,true);
		List<User> users = page.getDatas();
		System.out.println(users.size());
		for(User u:users){
			System.out.println(u);
		}
	}
}
