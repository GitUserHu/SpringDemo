package com.lcf.HiSpring.User.DAO;

import java.util.List;

import org.hibernate.Session;

import com.lcf.HiSpring.User.to.User;
import com.lcf.HiSpring.common.base.BaseDAO;

public interface UserDAO extends BaseDAO<User>{
	
	//User get(Integer id);
	List<User> getUserByName(User user);
	
	Session getCurrentSession();
	
	void delete(User entity);
}
