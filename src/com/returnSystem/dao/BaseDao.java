package com.returnSystem.dao;

import java.util.List;

public interface BaseDao {

	List<?> findByZJHM(String ZJHM,String KSXM);
	
	List<?> findUser(String ZJHM);
	
	List<?> findRequireUser(String sql);
	
	List<?> search(String KSXM, String ZJHM);
	
	boolean findByinfo(String ZJHM,String KSXM);
	
	boolean abandonExam(String Sql);
	
	boolean checkExam(String Sql);
	
	boolean update(String sql);
}
