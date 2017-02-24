package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IMonthlyExchangeRateService;

/**
 * drp_bas_m18 月汇率维护作业
 * @author liaogz
 * @since 2017-02-14
 *
 */
 
public class MonthlyExchangeRateService implements IMonthlyExchangeRateService{
	@Autowired
	private Dao dao;

	/**
	 * 根据预设条件查询月汇率列表（分页）
	 * @param param查询条件 
	 * @param startPage开始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getMonthlyExchangeRateList(Map<String, Object> param, int startPage, int pageSize)
			throws Exception {
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseBasMonthlyExchangeRateSettingMapper.selectMonthlyExchangeRateCount", "dao.BaseBasMonthlyExchangeRateSettingMapper.selectMonthlyExchangeRateLimit", param, startPage, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "");
		map.put("data", data);
		return map;
	}

	/**
	 * 修改月汇率
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> modifyMonthlyExchangeRate(Map<String, Object> param) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (param.get("bank_buying_exchrate") == null || "".equals(param.get("bank_buying_exchrate"))) {
			param.put("bank_buying_exchrate", "0.0");
		}
		if (param.get("bank_selling_exchrate") == null || "".equals(param.get("bank_selling_exchrate"))) {
			param.put("bank_selling_exchrate", "0.0");
		}
		if (param.get("bank_average_exchrate") == null || "".equals(param.get("bank_average_exchrate"))) {
			param.put("bank_average_exchrate", "0.0");
		}
		if (param.get("customs_selling_rate") == null || "".equals(param.get("customs_selling_rate"))) {
			param.put("customs_selling_rate", "0.0");
		}
		if (param.get("customs_selling_rate") == null || "".equals(param.get("customs_selling_rate"))) {
			param.put("customs_selling_rate", "0.0");
		}
		if (param.get("closing_foreign_exchrate") == null || "".equals(param.get("closing_foreign_exchrate"))) {
			param.put("closing_foreign_exchrate", "0.0");
		}
		if (param.get("reevaluation_exchange_rate") == null || "".equals(param.get("reevaluation_exchange_rate"))) {
			param.put("reevaluation_exchange_rate", "0.0");
		}
		if (param.get("transaction_currency_lot") == null || "".equals(param.get("transaction_currency_lot"))) {
			param.put("transaction_currency_lot", "0.0");
		}
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("base_currency")) || 
				StringUtils.isEmpty(param.get("period")) || StringUtils.isEmpty(param.get("transaction_currency")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no base_currency period transaction_currency and language cannot be null!");
		}
		int count =0;
		count += this.dao.update("dao.BaseBasMonthlyExchangeRateSettingMapper.modifyMonthlyExchangeRate", param);
		
		if (count>0) {
			map.put("successValue", true);
			map.put("description", "修改资料成功"+count+"笔");
		}else{
			map.put("successValue", false);
			map.put("description", "修改资料失败"+count+"笔");
		}
		
		return map;
	}

	/**
	 * 删除月汇率
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> deleteMonthlyExchangeRate(List<Map<String, Object>> param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		
		int count=0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no")) || StringUtils.isEmpty(map.get("base_currency")) || 
					StringUtils.isEmpty(map.get("period")) || StringUtils.isEmpty(map.get("transaction_currency")) || 
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no base_currency period transaction_currency and language cannot be null!");
			}
			count += this.dao.delete("dao.BaseBasMonthlyExchangeRateSettingMapper.deleteMonthlyExchangeRate", map);
		}

		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "删除资料成功"+count+"笔");
		}else{
			profile.put("successValue", false);
			profile.put("description", "删除资料失败"+count+"笔");
		}
		return profile;
	}

	/**
	 * 审核月汇率
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> auditMonthlyExchangeRate(List<Map<String, Object>> param, String status_code)
			throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		int count=0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no")) || StringUtils.isEmpty(map.get("base_currency")) || 
					StringUtils.isEmpty(map.get("period")) || StringUtils.isEmpty(map.get("transaction_currency")) || 
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no base_currency period transaction_currency and language cannot be null!");
			}
			map.put("status_code", status_code);
			map.put("data_modified_by", userId);
			map.put("last_modified_date", modifydate);
			count += this.dao.update("dao.BaseBasMonthlyExchangeRateSettingMapper.auditMonthlyExchangeRate", map);
		}
		
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "审核成功"+count+"笔");
		}else{
			profile.put("successValue", false);
			profile.put("description", "审核失败"+count+"笔");
		}
		return profile;
	}

	/**
	 * 新增月汇率
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> addMonthlyExchangeRate(Map<String, Object> param) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (param.get("bank_buying_exchrate") == null || "".equals(param.get("bank_buying_exchrate"))) {
			param.put("bank_buying_exchrate", "0.0");
		}
		if (param.get("bank_selling_exchrate") == null || "".equals(param.get("bank_selling_exchrate"))) {
			param.put("bank_selling_exchrate", "0.0");
		}
		if (param.get("bank_average_exchrate") == null || "".equals(param.get("bank_average_exchrate"))) {
			param.put("bank_average_exchrate", "0.0");
		}
		if (param.get("customs_selling_rate") == null || "".equals(param.get("customs_selling_rate"))) {
			param.put("customs_selling_rate", "0.0");
		}
		if (param.get("customs_selling_rate") == null || "".equals(param.get("customs_selling_rate"))) {
			param.put("customs_selling_rate", "0.0");
		}
		if (param.get("closing_foreign_exchrate") == null || "".equals(param.get("closing_foreign_exchrate"))) {
			param.put("closing_foreign_exchrate", "0.0");
		}
		if (param.get("reevaluation_exchange_rate") == null || "".equals(param.get("reevaluation_exchange_rate"))) {
			param.put("reevaluation_exchange_rate", "0.0");
		}
		if (param.get("transaction_currency_lot") == null || "".equals(param.get("transaction_currency_lot"))) {
			param.put("transaction_currency_lot", "0.0");
		}
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
		param.put("status_code", "Y");
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("base_currency")) || 
				StringUtils.isEmpty(param.get("period")) || StringUtils.isEmpty(param.get("transaction_currency")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no base_currency period transaction_currency and language cannot be null!");
		}
		int count =0;
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasMonthlyExchangeRateSettingMapper.selectId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if (totalCount != 0) {
			map.put("successValue", false);
			map.put("description", "已存在此笔记录");
		}else {
			count += this.dao.insert("dao.BaseBasMonthlyExchangeRateSettingMapper.addMonthlyExchangeRate", param);
			if (count>0) {
				map.put("successValue", true);
				map.put("description", "数据插入成功");
			}else{
				map.put("successValue", false);
				map.put("description", "数据插入失败");
			}
		}
		return map;
	}
	
	/**
	 * 判断月汇率是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeMonthlyExchangeRate(Map<String, Object> param) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("base_currency")) || 
				StringUtils.isEmpty(param.get("period")) || StringUtils.isEmpty(param.get("transaction_currency")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no base_currency period transaction_currency and language cannot be null!");
		}
		
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasMonthlyExchangeRateSettingMapper.selectId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if (totalCount!=0) {
			map.put("successValue", true);
			map.put("description", "月汇率存在");
		}else{
			map.put("successValue", false);
			map.put("description", "该笔月汇率不存在");
		}
		return map;
	}

	@Override
	public Object getMonthlyExchangeRate(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("base_currency")) || 
				StringUtils.isEmpty(param.get("period")) || StringUtils.isEmpty(param.get("transaction_currency")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no base_currency period transaction_currency and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasMonthlyExchangeRateSettingMapper.getMonthlyExchangeRate", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}

}
