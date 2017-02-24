package com.robam.distribution.sys.dao.impl;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 2016-11-15 DWDemoAP Mybatis 資料存取物件
 * 20170214 DWLogin
 * @author falcon
 *
 */
public class LoginMybatisDao {

	/**
	 * Mybatis session factory
	 */
	@Autowired
	private SqlSessionFactoryBean sessionFactoryBean;
	
	/**
	 * Mybatis session factory
	 */
	private SqlSessionFactory sessionFactory;

	/**
	 * 取得 session factory
	 * @return session factory
	 * @throws Exception 異常
	 */
	private SqlSessionFactory getSessionFactory() throws Exception {
		
		if (this.sessionFactory == null) {
			
			this.initSessionFactory();
		}
		
		return this.sessionFactory;
	}
	
	/**
	 * 初始化 session factory
	 * @throws Exception 
	 */
	private void initSessionFactory() throws Exception {

		if (this.sessionFactory == null) {
		
			this.sessionFactory = sessionFactoryBean.getObject();
		}
	}
	
	/**
	 * 執行
	 * @param sqlId MyBatis SQL 編號
	 * @param parameter 參數
	 * @return 結果
	 * @throws Exception 異常
	 */
	public <T> List<T> execute(String sqlId, Object parameter) throws Exception {

		List<T> result = null;
		try (SqlSession session = this.getSessionFactory().openSession()) {
			
			result = session.selectList(sqlId, parameter); 
		}
		
		return result;
	}
}
