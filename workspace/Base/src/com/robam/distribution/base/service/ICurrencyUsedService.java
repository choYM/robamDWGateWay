package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m16 使用币种维护作业
 * @author gelf
 * @since 2017-02-14
 *
 */
public interface ICurrencyUsedService extends DWService{
	/**
	 * 根据预设条件查询使用币别设定列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	
	Object getCurrencyUsedList(Map<String,Object> param,int startPage,int pageSize) throws Exception;
	
	/**
	 * 修改使用币别设定
	 * @param param
	 * @return
	 */
	Object modifyCurrencyUsed(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除使用币别设定
	 * @param param
	 * @return
	 */
	Object deleteCurrencyUsed(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核使用币别设定
	 * @param param
	 * @return
	 */
	Object auditCurrencyUsed(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 判断使用币种是否存在记录
	 * @param param
	 * @return
	 */
	Object judgeCurrencyUsed(Map<String,Object> param) throws Exception;
	
	/**
	 * 新增使用币别设定
	 * @param param
	 * @return
	 */
	Object addCurrencyUsed(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查询使用币别设定
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getCurrencyUsed(Map<String,Object> param) throws Exception;
}
