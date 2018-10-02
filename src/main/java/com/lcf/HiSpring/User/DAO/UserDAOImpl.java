package com.lcf.HiSpring.User.DAO;


import java.sql.SQLDataException;
import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lcf.HiSpring.User.to.User;
import com.lcf.HiSpring.common.base.BaseDAOImpl;

@Repository("userDao")
@Transactional
public class UserDAOImpl extends BaseDAOImpl<User>implements UserDAO {

	@Autowired
	public UserDAOImpl(SessionFactory sessionFactory) {
		super(sessionFactory,User.class);
	}
	
	public List<User> getUserByName(User user) {
		Query query=getCurrentSession().createQuery("from com.lcf.HiSpring.User.to.User where userName = :userName");
		query.setString("userName", user.getUserName());
		
		return  query.list();
		
	}
	
	public void delete(User user) {
		super.delete(user);
		//throw new SQLDataException("手动抛出异常，用于验证事务rollback");
		throw new RuntimeException("手动抛出异常，用于验证事务rollback");
	
	}

}
