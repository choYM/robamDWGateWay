package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m06 国家资料维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 
 
public interface ICountryService extends DWService{
	/**
	 * 
	 * @param startPage页码
	 * @param pageSize每页多少笔数据
	 * @param param国家资料的查询条件的对象
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getCountryList(Map<String, Object> param,int startPage,int pageSize) throws Exception;

	/**
	 * 
	 * @param param要修改的内容
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> modifyCountry(Map<String,Object> param) throws Exception;
	
	/**
	 * 
	 * @param param前端传过来的国家编号数组
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deleteCountry(List<String> param) throws Exception;
	
	/**
	 * 
	 * @param param前端传过来的国家编号数组
	 * @param status_code 状态码
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> auditCountry(List<String> param,String status_code) throws Exception;
	
	/**
	 * 
	 * @param param国家资料对象
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addCountry(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断国家资料是否为空
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> judgeCountry(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查询国家资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getCountry(Map<String,Object> param) throws Exception;
}
