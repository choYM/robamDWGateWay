package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ICurrencyUsedService;

/**
 * drp_bas_m16 使用币种维护作业
 * @author gelf
 * @since 2017-02-14
 *
 */

public class CurrencyUsedService implements ICurrencyUsedService {
	
	@Autowired
	private  Dao dao;
	
	/**
	 * 根据预设条件查询使用币别设定列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	@Override
	public Object getCurrencyUsedList(Map<String,Object> param, int startPage, int pageSize) throws Exception {
		param.put("language", "zh_CN");
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseBasCurrencyUsedSettingMapper.selectCount", "dao.BaseBasCurrencyUsedSettingMapper.getCurrencyList", param, startPage, pageSize);
		Map<String,Object> response = new HashMap<String,Object>();
		if(result.getDatas().size() >= 0){
			response.put("successValue", true);
			response.put("description", "查询成功");
			response.put("data", result);
		}else{
			response.put("successValue", false);
			response.put("description", "查询失败");
		}
		return response;
	}

	/**
	 * 修改使用币别设定
	 * @param param
	 * @return
	 */
	@Override
	public Object modifyCurrencyUsed(Map<String,Object> param) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("language")) 
				|| StringUtils.isEmpty(param.get("currency_used"))){
			throw new Exception("reference_table_no currency_used and language cannot be null!");
		}
		
		
		int count = this.dao.update("dao.BaseBasCurrencyUsedSettingMapper.updateBaseCurrencyInfo", param);

		return this.getResult(count);
	}

	/**
	 * 删除使用币别设定
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public Object deleteCurrencyUsed(List<Map<String,Object>> param) throws Exception {
		
		if(param == null || param.size() == 0){
			throw new Exception("Pls select at least one data!");
		}
		
		int count = 0;
		
		for(Map<String,Object> map : param){
			map.put("language", "zh_CN");
			
			if(StringUtils.isEmpty(map.get("reference_table_no")) || StringUtils.isEmpty(map.get("currency_used")) 
					|| StringUtils.isEmpty(map.get("language")) ){
				throw new Exception("reference_table_no currency_used and language cannot be null!");
			}
			
			count += this.dao.delete("dao.BaseBasCurrencyUsedSettingMapper.deleteBaseCurrencyInfo", map);
			
		}
		
		return this.getResult(count);
	}

	/**
	 * 审核使用币别设定
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public Object auditCurrencyUsed(List<Map<String,Object>> param,String status_code) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		if(param == null || param.size() == 0){
			throw new Exception("Pls select at least one data!");
		}
		if(StringUtils.isEmpty(status_code) || status_code.length() != 1){
			throw new Exception("status_code wrong format !");
		}
		
		int count = 0;
		
		for(Map<String,Object> map : param){
			map.put("language", "zh_CN");
			
			map.put("status_code", status_code);
			
			if(StringUtils.isEmpty(map.get("reference_table_no")) || StringUtils.isEmpty(map.get("currency_used")) 
					|| StringUtils.isEmpty(map.get("language")) ){
				throw new Exception("reference_table_no currency_used and language cannot be null!");
			}
			
			//最后修改日期
			map.put("data_modified_by", userId);
			map.put("last_modified_date", modifydate);
			
			count += this.dao.update("dao.BaseBasCurrencyUsedSettingMapper.auditCurrency", map);
		}
		
		return this.getResult(count);
	}

	/**
	 * 新增使用币别设定
	 * @param param
	 * @return
	 */
	@Override
	public Object addCurrencyUsed(Map<String,Object> param) throws Exception {
		//赋值语言别信息
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Object deptId = information.get("DeptId");
		Date createdate = new Date();
		param.put("data_owner", userId);
		param.put("data_owned_department", deptId);
		param.put("data_created_by", userId);
		param.put("data_created_department", deptId);
		param.put("data_created_date", createdate);
		param.put("data_modified_by", userId);
		param.put("last_modified_date", createdate);
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("currency_used")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("reference_table_no currency_used and language cannot be null!");
		}
		
		int count = 0;
		
		List<Integer> data = this.dao.query("dao.BaseBasCurrencyUsedSettingMapper.judgeCurrencyUsed", param);
		
		if(data.size() > 0 && data.get(0) == 0){
			
			count = this.dao.insert("dao.BaseBasCurrencyUsedSettingMapper.addCurrencyUsed", param);
			
		}
		
		return this.getResult(count);
	}
	
	/**
	 * 判断使用币种是否存在记录
	 * @param param
	 * @return
	 */
	@Override
	public Object judgeCurrencyUsed(Map<String, Object> param) throws Exception {
		
		//赋值语言别信息
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("currency_used")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("reference_table_no currency_used and language cannot be null!");
		}
		
		List<Integer> data = this.dao.query("dao.BaseBasCurrencyUsedSettingMapper.judgeCurrencyUsed", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		if(data.size() > 0 && data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			result.put("successValue", false);
			result.put("description", "添加成功");
		}
		
		return result;
	}
	
	
	/**
	 * 将执行的结果封装成标准输出
	 * @param data
	 * @return
	 */
	private Object getResult(int count){
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		if(count > 0){
			result.put("successValue", true);
			result.put("description", "执行成功");
		}else{
			result.put("successValue", false);
			result.put("description", "执行失败");
		}
		
		return result;
	}

	@Override
	public Object getCurrencyUsed(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("currency_used")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("reference_table_no currency_used and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasCurrencyUsedSettingMapper.getCurrencyUsed", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}

}
