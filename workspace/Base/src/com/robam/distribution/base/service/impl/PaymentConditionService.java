package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IPaymentConditionService;

/**
 * drp_bas_m31 付款条件维护作业
 * @author lusy
 * @since 2017-02-14
 *
 */

public class PaymentConditionService implements IPaymentConditionService{

	@Autowired
	private Dao dao;
	@Override
	public Map<String, Object> getPaymentConditionList(Map<String, Object> param, int startPage, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> profile = new HashMap<String, Object>();
		param.put("language", "zh_CN");
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseBasPaymentConditionSettingMapper.selectCount", "dao.BaseBasPaymentConditionSettingMapper.selectLimit", param, startPage, pageSize);
		profile.put("successValue", true);
		profile.put("description", "");
		profile.put("data", result);
		return profile;
	}

	@Override
	public Map<String, Object> modifyPaymentCondition(Map<String,Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("payment_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("payment_term and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		int count=this.dao.update("dao.BaseBasPaymentConditionSettingMapper.modifyPaymentCondition",param);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("successValue", true);
			map.put("description", "修改资料成功");
		}else {
			map.put("successValue", false);
			map.put("description", "修改资料失败");
		}
		return map;
	}

	@Override
	public Map<String, Object> deletePaymentCondition(List<Map<String,Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		int count = 0;
		for (Map<String, Object> map : param) {
		     map.put("language", "zh_CN");
		if (map.get("payment_term")==null || map.get("payment_term")==""
			|| map.get("language")==null || map.get("language")=="") 
		{
			throw new Exception("payment_term and language cannot be null!");
		} else {
			count += dao.delete("dao.BaseBasPaymentConditionSettingMapper.deletePaymentCondition", map);
		}
	  }
		Map<String, Object> profile = new HashMap<String, Object>();
		if (count > 0) {
			profile.put("successValue", true);
			profile.put("description", "删除成功");
		} else {
			profile.put("successValue", false);
			profile.put("description", "删除失败");
		}
		return profile;
	}

	@Override
	public Map<String, Object> auditPaymentCondition(List<Map<String,Object>> param, String status_code)
			throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		Map<String, Object> result = new HashMap<String, Object>();
		if (!status_code.isEmpty()) {
			int count = 0;
			for (Map<String, Object> map : param) {
				map.put("language", "zh_CN");
				if (map.get("payment_term")==null || map.get("payment_term")==""
						|| map.get("language")==null || map.get("language")=="") 
				{
					throw new Exception("payment_term and language cannot be null!");
				} else {
					Map<String,Object> information=DWServiceContext.getContext().getProfile();
					Object userId = information.get("UserId");
					map.put("last_modified_date", new Date());
					map.put("data_modified_by",userId);
					map.put("status_code", status_code);
					count += dao.update("dao.BaseBasPaymentConditionSettingMapper.auditPaymentCondition",map);
				}
			}
			if (count > 0) {
				result.put("successValue", true);
				result.put("description", "审核成功");
			} else {
				result.put("successValue", false);
				result.put("description", "审核失败");
			}
		}else {
			throw new Exception("status_code cannot be null!");
		}
		return result;
	}

	@Override
	public Map<String, Object> addPaymentCondition(Map<String,Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("payment_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("payment_term and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasPaymentConditionSettingMapper.judgePaymentCondition", param);
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.size() > 0 && data.get(0) > 0){
			result.put("successValue", false);
			result.put("description", "存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			Date date = new Date();
			param.put("last_modified_date", date);
			param.put("data_created_date",date);
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			Object deptId = information.get("DeptId");
			param.put("data_owner",userId);
			param.put("data_owned_department",deptId);
			param.put("data_created_by",userId);
			param.put("data_created_department",deptId);
			param.put("data_modified_by",userId);
			param.put("status_code", "Y");
			this.dao.insert("dao.BaseBasPaymentConditionSettingMapper.addPaymentCondition",param);
			result.put("successValue", true);
			result.put("description", "不存在此笔记录");
		}
		return result;
	}

	@Override
	public Map<String, Object> judgePaymentCondition(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("payment_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("payment_term and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasPaymentConditionSettingMapper.judgePaymentCondition", param);
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.size() > 0 && data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			result.put("successValue", false);
			result.put("description", "不存在此笔记录");
		}
		return result;
	}
	
	@Override
	public Map<String, Object> getPaymentCondition(Map<String, Object> param)
			throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("payment_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("payment_term and language cannot be null!");
		}
		List<Map<String,Object>> data = this.dao.query("dao.BaseBasPaymentConditionSettingMapper.getPaymentConditionOne", param);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("successValue", true);
		result.put("description", "存在此笔记录");
		result.put("data", data!=null?data.get(0):null);
		return result;
	}
}
