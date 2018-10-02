package com.lcf.HiSpring.User.DAO;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.lcf.HiSpring.User.to.User;
import com.lcf.HiSpring.common.base.BaseDAO;
import com.lcf.HiSpring.common.base.BaseDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/spring-context.xml")
public class UserDAOImplTest {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	SessionFactory sessionfactory;
	
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}

	public void addUser() {
		User user =new User();
		user.setUserName("HCH");
		user.setPassword("0999");
		userDAO.save(user);
	}
	
	@Test
	public void testRollback() {
		User user =new User();
		user.setId(15);
		userDAO.delete(user);
	}
	
	@Test
	public void test() {
		//fail("Not yet implemented");
		//user.setUserName("LCF");
		User user=userDAO.findById(9);
		User user1=userDAO.findById(9);
		System.out.println(user==user1);
//		List<User>  users=userDAO.getUserByName(user);
//		for(User user2 :users) {
		
//		System.out.println(user2);}
//		
		//userDAO.getUserByName(user);
	}
	@Test
	public void testSessionSame() {
		Session session=userDAO.getCurrentSession();
		Session session2=userDAO.getCurrentSession();
		System.out.println("session:"+(session==session2));
	}
	@Test
	public void testEntitySame() {
		
//		Session session=sessionfactory.openSession();
//		User user=session.get(User.class, 9);
//		User user2=session.get(User.class, 9);
//		System.out.println(user==user2);
		Session session=	sessionfactory.openSession();
		User user =new User();
		user.setId(7);
		/*User user=session.get(User.class, 9);
		Session session2 =  sessionfactory.getCurrentSession();
		User user2=session2.get(User.class, 9);
		System.out.println(user==user2);*/
		session.delete(user);
		session.beginTransaction().commit();
		
//		
//		
//		System.out.println(session==session2);
	}
	

}
