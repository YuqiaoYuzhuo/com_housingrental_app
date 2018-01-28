package com.xc.system_usermanage_core;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.xc.basic.model.Pager;
import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.model.UserInfo;
import com.xc.system_usermanage_core.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/beans.xml")
public class UserServiceTest {
	@Autowired
	private UserService userService;
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
	
	public void testaddPcRegister(){
		UserAccount userAccount =new UserAccount ();
		userAccount.setUaserAccountNum("18890234758");
		userAccount.setUserAccountPassword("1qaz!QAZ");
		userService.addPcRegister(userAccount);
	}
	public void testaddWxRegister(){
		UserAccount userAccount =new UserAccount ();
		userAccount.setUaserAccountNum("188345566");
		userAccount.setUserAccountPassword("1qaz!QAZ");
		userService.addWxRegister(userAccount);
	}
	
	public void testaddAdminRegister(){
		UserAccount userAccount =new UserAccount ();
		userAccount.setUaserAccountNum("1883455676");
		userAccount.setUserAccountPassword("1qaz!QAZ");
		userService.addAdminRegister(userAccount);
	}
	@Test
	public void testfindUserListByPage(){
		Pager<UserInfo> pager = new Pager<UserInfo>();
		System.out.println(userService.findUserListByPage(pager).getDatas().size());
	}

	public void testgetLogin(){
		System.out.println(userService.getLogin("18890234758","1qaz!QAZ"));
	}
}
