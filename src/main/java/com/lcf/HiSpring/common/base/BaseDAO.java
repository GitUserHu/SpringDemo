package com.lcf.HiSpring.common.base;

import java.io.Serializable;

public interface BaseDAO<T extends BaseTo> {

	T findById(int id);
	
	Serializable save(T entity);
	
	void delete(T entity);
}
