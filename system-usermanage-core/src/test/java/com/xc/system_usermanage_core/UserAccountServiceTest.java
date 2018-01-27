package com.xc.system_usermanage_core;

import java.security.NoSuchAlgorithmException;

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

import com.xc.basic.util.SecurityUtil;
import com.xc.basic.util.UUIDGenerator;
import com.xc.system_usermanage_core.model.UserAccount;
import com.xc.system_usermanage_core.service.UserAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/beans.xml")
public class UserAccountServiceTest {
	@Autowired
	private UserAccountService userAccountService;
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
	public void testaddUserAccount(){
		String securityPassd = null;
		try {
			 securityPassd = SecurityUtil.md5("1223339488484","1qaz!QAZ");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		UserAccount userAccount = new UserAccount();
		userAccount.setUserAccountUuid(UUIDGenerator.createUUID());
		userAccount.setUserAccountName("张三");
		userAccount.setUserAccountStaus(0);
		userAccount.setUserAccountType("1");
		userAccount.setUserAccUserUuid(UUIDGenerator.createUUID());
		userAccount.setUaserAccountNum("12543239488484");
		userAccount.setUserAccountCode("122233");
		userAccount.setUserAccountPassword(securityPassd);
		userAccount.setErrorNum(0);
		userAccount.setUserAccountCode("2333444");
		userAccount.setUserAccUserUuid(UUIDGenerator.createUUID());
		userAccountService.addUserAccount(userAccount);
	}

	public void testUpPassd(){
		userAccountService.updatePwd("3a13bf401968418d9b2e0a92a7ac1a13", "1qaz!QAZ", "2wsx@WSX");
	}
	public void testUpStaus(){
		userAccountService.updateStatus("3a13bf401968418d9b2e0a92a7ac1a13", 1);
	}
	@Test
	public void testfindUserAccountByUserAccountAndPasswd(){
		System.out.println(userAccountService.findUserAccountByUserAccountAndPasswd("1223329488484", "1qaz!QAZ"));
	}
}
