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
import com.robam.distribution.base.service.ICurrencyService;

/**
 * drp_bas_m15 币种资料服务
 * @author gelf
 * @since 2017-02-14
 *
 */

public class CurrencyService implements ICurrencyService {
	
	@Autowired
	private  Dao dao;
	
	/**
	 * 根据预设条件查询币种列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	@Override
	public Object getCurrencyList(Map<String,Object> param, int startPage, int pageSize) throws Exception {
		param.put("language", "zh_CN");
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseBasCurrencySettingMapper.selectCount", "dao.BaseBasCurrencySettingMapper.getCurrencyList", param, startPage, pageSize);
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
	 * 修改币种详细资料
	 * @param param
	 * @return
	 */
	@Override
	public Object modifyBaseCurrencyInfo(Map<String,Object> param) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("currency")) || StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("currency and language cannot be null!");
		}
		
		
		int count = this.dao.update("dao.BaseBasCurrencySettingMapper.updateBaseCurrencyInfo", param);
		
		return this.getResult(count);
	}

	/**
	 * 删除币种资料
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public Object deleteBaseCurrencyInfo(List<String> param) throws Exception {
		
		if(param == null || param.size() == 0){
			throw new Exception("Pls select at least one data!");
		}
		
		int count = 0;
		
		for(String currency : param){
			
			if(!currency.isEmpty()){
				Map<String,Object> deleteInfo = new HashMap<String,Object>();
				deleteInfo.put("language", "zh_CN");
				deleteInfo.put("currency",currency);
				count += this.dao.delete("dao.BaseBasCurrencySettingMapper.deleteBaseCurrencyInfo", deleteInfo);
			}else{
				throw new Exception("currency is null !");
			}
			
		}
		
		return this.getResult(count);
	}

	/**
	 * 审核币种资料
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public Object auditCurrency(List<String> param,String status_code) throws Exception {
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
		
		for(String currency : param){
			
			if(!currency.isEmpty()){
				Map<String,Object> auditInfo = new HashMap<String,Object>();
				auditInfo.put("language", "zh_CN");
				auditInfo.put("currency",currency);
				auditInfo.put("status_code", status_code);
				auditInfo.put("data_modified_by", userId);
				auditInfo.put("last_modified_date", modifydate);
				
				count += this.dao.update("dao.BaseBasCurrencySettingMapper.auditCurrency", auditInfo);
			}else{
				throw new Exception("currency is null !");
			}
		}
		
		return this.getResult(count);
	}

	/**
	 * 新增币种资料
	 * @param param
	 * @return
	 */
	@Override
	public Object addCurrency(Map<String,Object> param) throws Exception {
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
		
		if(StringUtils.isEmpty(param.get("currency")) || StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("currency and language cannot be null!");
		}
		
		List<Integer> data = this.dao.query("dao.BaseBasCurrencySettingMapper.judgeCurrency", param);
		
		int count = 0;
		
		if(data.size() > 0 && data.get(0) == 0){
			
			count = this.dao.insert("dao.BaseBasCurrencySettingMapper.addCurrency", param);
		
		}
		
		return this.getResult(count);
	}
	
	/**
	 * 判断币种是否存在记录
	 * @param param
	 * @return
	 */
	@Override
	public Object judgeCurrency(Map<String, Object> param) throws Exception {
		
		//赋值语言别信息
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("currency")) || StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("currency and language cannot be null!");
		}
		
		List<Integer> data = this.dao.query("dao.BaseBasCurrencySettingMapper.judgeCurrency", param);
		
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

	@Override
	public Object getCoinsKind() throws Exception {
//		Map<String,Object> parameter = new HashMap<String,Object>();
//		parameter.put("language", "CN");
//		List<Integer> data = this.dao.query("dao.BaseBasCurrencySettingMapper.getCoinsKind", parameter);
//		return this.getResult(data);
		return null;
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
	public Object getCurrency(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("currency")) || StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("currency and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasCurrencySettingMapper.getCurrency", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}

}
