package com.lcf.HiSpring.common.base;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
@Repository("baseDAO")
@Transactional
public class BaseDAOImpl<E extends BaseTo>  implements BaseDAO<E>{
	
	private Class<E> type;
	@Autowired
	private SessionFactory sessionFactory;
	/**
	 * 
	 * @param sessionFactory: 注入Hibernate的SessionFactory.
	 * @param type : Entity
	 */
	
	public BaseDAOImpl(SessionFactory sessionFactory, Class<E> type){
		this.sessionFactory=sessionFactory;
		this.type=type;
	}
	
	@Transactional()
	public E findById(int id) {
		
		return getCurrentSession().get(type, id);
	}

	public Serializable save(E entity) {	
		// TODO Auto-generated method stub
		return getCurrentSession().save(entity);
	}

	public void delete(E entity) {
		getCurrentSession().delete(entity);
		
	}
	
	public Session getCurrentSession() {
		//这里获取的Session不是同一个session
		Session session=sessionFactory.getCurrentSession();
		return session;
	}

}
