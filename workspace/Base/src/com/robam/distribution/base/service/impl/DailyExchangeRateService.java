package com.robam.distribution.base.service.impl;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IDailyExchangeRateService;

/**
 * drp_bas_m17 日汇率维护作业
 * @author gejc
 * @since 2017-02-16
 **/ 
 
public class DailyExchangeRateService implements IDailyExchangeRateService {
	@Autowired
	private Dao dao;
	
	
	/**
	 * 根据预设条件查询日汇率列表（分页）
	 * @param param
	 * @return Object
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object getDailyExchangeRateList(Map<String, Object> param,int startPage, int pageSize
			) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseBasDailyExchangeRateSettingMapper.getDailyExchangeRateListCount", "dao.BaseBasDailyExchangeRateSettingMapper.getDailyExchangeRateList", param, startPage, pageSize);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile;
	}

	
	/**
	 * 修改日汇率
	 * @param param
	 * @return Object
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object modifyDailyExchangeRate(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no"))||
				StringUtils.isEmpty(param.get("base_currency"))||
				StringUtils.isEmpty(param.get("date"))||
				StringUtils.isEmpty(param.get("transaction_currency"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no,base_currency,date,transaction_currency and language cannot be null!");
		}
		int count=this.dao.update("dao.BaseBasDailyExchangeRateSettingMapper.modifyDailyExchangeRate", param);
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "修改数据"+str);
		return profile;
	}
	
	
	/**
	 * 批量删除日汇率
	 * @param param
	 * @return Object
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object deleteDailyExchangeRate(List<Map<String, Object>> param)
			throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no"))||
					StringUtils.isEmpty(map.get("base_currency"))||
					StringUtils.isEmpty(map.get("date"))||
					StringUtils.isEmpty(map.get("transaction_currency"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no,base_currency,date,transaction_currency and language cannot be null!");
			}
			count += dao.delete("dao.BaseBasDailyExchangeRateSettingMapper.deleteDailyExchangeRate", map);
		}
		if(count!=param.size()){
			throw new Exception("delete fail!");
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count==param.size());
		String str=count==param.size()?"成功":"失败";
		profile.put("description", "删除数据"+str);		
		return profile;
	}

	
	/**
	 * 批量审核日汇率
	 * @param param
	 * @return Object
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object auditDailyExchangeRate(List<Map<String, Object>> param,
			String status_code) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		if(status_code==null){
			throw new Exception("status_code cannot be null!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no"))||
					StringUtils.isEmpty(map.get("base_currency"))||
					StringUtils.isEmpty(map.get("date"))||
					StringUtils.isEmpty(map.get("transaction_currency"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no,base_currency,date,transaction_currency and language cannot be null!");
			}
			map.put("status_code", status_code);
			map.put("data_modified_by", userId);
			map.put("last_modified_date", modifydate);
			count += dao.update("dao.BaseBasDailyExchangeRateSettingMapper.auditDailyExchangeRate", map);
		}
		if(count!=param.size()){
			throw new Exception("audit fail!");
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue",count==param.size());
		String str=count==param.size()?"成功":"失败";
		profile.put("description", "审批数据"+str);
		return profile;
	}

	
	/**
	 * 新增日汇率
	 * @param param
	 * @return Object
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object addDailyExchangeRate(Map<String, Object> param)
			throws Exception {
		
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param==null){
			throw new Exception("param cannot be null!");
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
		if(StringUtils.isEmpty(param.get("reference_table_no"))||
				StringUtils.isEmpty(param.get("base_currency"))||
				StringUtils.isEmpty(param.get("date"))||
				StringUtils.isEmpty(param.get("transaction_currency"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no,base_currency,date,transaction_currency and language cannot be null!");
		}	
		List<Object> li=this.dao.query("dao.BaseBasDailyExchangeRateSettingMapper.getDailyExchangeRate",param );
		if(li!=null&&li.size()>0){
			profile.put("successValue",false);
			profile.put("description", "新增数据失败！该编号数据已存在！");
		}else{
			param.put("status_code", "Y");
			int count= this.dao.insert("dao.BaseBasDailyExchangeRateSettingMapper.addDailyExchangeRate", param);
			profile.put("successValue", count>0);
			String str=count>0?"成功":"失败";
			profile.put("description", "新增数据"+str);
		}
		return profile;
	}
	
	/**
	 * 判断日汇率是否存在
	 * @param param
	 * @return Object
	 * @throws Exception
	 * @author gejc
	 */
	@Override
	public Object judgeDailyExchangeRate(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no"))||
				StringUtils.isEmpty(param.get("base_currency"))||
				StringUtils.isEmpty(param.get("date"))||
				StringUtils.isEmpty(param.get("transaction_currency"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no,base_currency,date,transaction_currency and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasDailyExchangeRateSettingMapper.getDailyExchangeRate",param );
		Map<String,Object> profile=new HashMap<String,Object>();
		if(li!=null&&li.size()>0){
			profile.put("successValue", true);
			profile.put("description", "存在该数据");	
		}else{
			profile.put("successValue", false);
			profile.put("description", "不存在该数据");	
		}
		return profile;
	}


	/**
	 * 根据主键查询日汇率
	 * @param param
	 * @return Object
	 * @throws Exception
	 * @author liaogz
	 */
	@Override
	public Object getDailyExchangeRate(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no"))||
				StringUtils.isEmpty(param.get("base_currency"))||
				StringUtils.isEmpty(param.get("date"))||
				StringUtils.isEmpty(param.get("transaction_currency"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no,base_currency,date,transaction_currency and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasDailyExchangeRateSettingMapper.getDailyExchangeRate", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}
}
