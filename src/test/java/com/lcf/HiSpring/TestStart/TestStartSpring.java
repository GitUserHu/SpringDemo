package com.lcf.HiSpring.TestStart;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lcf.HiSpring.User.to.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class TestStartSpring {
//	@Autowired
//	private User user;
	@Autowired
	private SessionFactory sf;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		//fail("Not yet implemented");
//		user.setPassword("1006");
//		System.err.println(user.toString());
	}
	@Test
	public void testHibernate() {
//		Session session=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
	//System.out.println("session is null? "+session2==null);
	Session session2= sf.openSession();
	System.out.println("");
	User user=session2.get(User.class,9);
	System.out.println(user.toString());
	user.setUserName("CCC");
	//session2.beginTransaction().commit();
	session2.close();
	}

}
