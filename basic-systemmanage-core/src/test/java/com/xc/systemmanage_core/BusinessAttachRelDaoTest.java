package com.xc.systemmanage_core;

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

import com.xc.systemmanage_core.dao.BusinessAttchmentRelDao;


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
public class BusinessAttachRelDaoTest {
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
		private BusinessAttchmentRelDao businessAttchmentRelDao;
		@Test
		public void testbusinessAttchmentRelDaoDelByUuid(){
			businessAttchmentRelDao.deleteByUuids("1,2,3,4");
		}
}
