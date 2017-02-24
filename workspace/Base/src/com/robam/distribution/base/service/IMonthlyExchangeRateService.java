package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m18 月汇率维护作业
 * @author liaogz
 * @since 2017-02-14
 *
 */
public interface IMonthlyExchangeRateService extends DWService{
	/**
	 * 根据预设条件查询月汇率列表（分页）
	 * @param param查询条件 
	 * @param startPage开始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	public Object getMonthlyExchangeRateList(Map<String, Object> param,int startPage,int pageSize) throws Exception;

	/**
	 * 修改月汇率
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object modifyMonthlyExchangeRate(Map<String, Object> param) throws Exception;
	
	/**
	 * 删除月汇率
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteMonthlyExchangeRate(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核月汇率
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	public Object auditMonthlyExchangeRate(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增月汇率
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object addMonthlyExchangeRate(Map<String, Object> param) throws Exception;
	
	/**
	 * 判断月汇率是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeMonthlyExchangeRate(Map<String,Object> param) throws Exception;
	
	
	/**
	 * 根据主键查询月汇率
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getMonthlyExchangeRate(Map<String,Object> param) throws Exception;
}
