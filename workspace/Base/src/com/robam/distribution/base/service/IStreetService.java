package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m10 街道资料维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 
public interface IStreetService extends DWService{
	/**
	 * 分頁查詢
	 * @param pageNumber 查詢的頁次
	 * @param  传过来的查询条件
	 * @return 分頁查詢結果
	 * @throws Exception 異常
	 */
	public Map<String, Object> getStreetList(Map<String, Object> param,int startPage,int pageSize) throws Exception;

	/**
	 * 
	 * @param param前端传进的要修改的对象
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> modifyStreet(Map<String,Object> param) throws Exception;
	
	/**
	 * 
	 * @param param前端传的要删除的关于主键的对象数组
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deleteStreet(List<Map<String, Object>> param) throws Exception;
	
	/**
	 * 
	 * @param param前端传的要审核的关于主键的对象数组
	 * @param status_code状态码
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> auditStreet(List<Map<String, Object>> param,String status_code) throws Exception;
	
	/**
	 * 
	 * @param param要新增的资料对象
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addStreet(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断街道资料是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> judgeStreet(Map<String, Object> param) throws Exception;

	/**
	 * 根据主键查询街资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getStreet(Map<String, Object> param) throws Exception;
}
