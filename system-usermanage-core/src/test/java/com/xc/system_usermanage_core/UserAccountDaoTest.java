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
import com.xc.system_usermanage_core.dao.UserAccountDao;
import com.xc.system_usermanage_core.model.UserAccount;


/**
 * <p>Title:用户账号测试类 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2018年1月27日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:/beans.xml")
public class UserAccountDaoTest {
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
		@Autowired
		private UserAccountDao userAccountDao;
		
		public void adduserAccount(){
			String securityPassd = null;
			try {
				 securityPassd = SecurityUtil.md5("1223339488484","1qaz!QAZ");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			UserAccount userAccount = new UserAccount();
			userAccount.setUserAccountUuid(UUIDGenerator.createUUID());
			userAccount.setUserAccountName("李四");
			userAccount.setUserAccountStaus(0);
			userAccount.setUserAccountType("1");
			userAccount.setUserAccUserUuid(UUIDGenerator.createUUID());
			userAccount.setUaserAccountNum("1223339488484");
			userAccount.setUserAccountCode("122233");
			userAccount.setUserAccountPassword(securityPassd);
			userAccount.setErrorNum(0);
			userAccount.setUserAccountCode("2333444");
			userAccount.setUserAccUserUuid(UUIDGenerator.createUUID());
			userAccountDao.add(userAccount);
		}
		
		public void findUserAccountByUseruuid(){
		  System.out.println(userAccountDao.findUserAccountByUseruuid("e26cb68e80104a23b7385dac7a1f1fae"));	
		}
		@Test
		public void findUserAccountByUserAccountAndPasswd(){
			System.out.println(userAccountDao.findUserAccountByUserAccountAndPasswd("1223339488484", "1qaz!QAZ"));	
		}
}
