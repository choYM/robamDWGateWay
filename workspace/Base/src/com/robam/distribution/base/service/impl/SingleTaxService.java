package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ISingleTaxService;

/**
 * drp_bas_m28 单一税别设置作业
 * @author YangJian
 * @since 2017-02-14
 *
 */
 
public class SingleTaxService implements ISingleTaxService {

	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询单一税别列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getSingleTaxList(Map<String, Object> param, Integer startPage, Integer pageSize) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseBasSingleTaxSettingMapper.BasSingleTaxSelectCount",
				"dao.BaseBasSingleTaxSettingMapper.BasSingleTaxSelectLimit", param, startPage, pageSize);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "根据预设条件查询单一税别列表（分页）");
		return result;
	}

	/**
	 * 修改单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifySingleTax(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if(param.get("tax_rate")==null || "".equals(param.get("tax_rate"))){
			param.put("tax_rate", 0);
		}
		if(param.get("ke_tax")==null || "".equals(param.get("ke_tax"))){
			param.put("ke_tax", 0);
		}
		if(param.get("fixed_tax")==null || "".equals(param.get("fixed_tax"))){
			param.put("fixed_tax", 0);
		}
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("tax_code")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no tax_code and language cannot be null!");
		}
		int count=0;
		Map<String, Object> profile = DWServiceContext.getContext().getProfile();
		Object userId = profile.get("UserId");
				
		param.put("data_modified_by", userId);
		param.put("last_modified_date", new Date());
		count+=this.dao.update("dao.BaseBasSingleTaxSettingMapper.modifySingleTax", param);
		if (count>0) {
			result.put("successValue", true);
			result.put("description", "修改单一税别"+count+"笔，成功");
		}else{
			result.put("successValue", false);
			result.put("description", "修改单一税别"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 删除单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteSingleTax(List<Map<String,Object>> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no")) || StringUtils.isEmpty(map.get("tax_code")) || 
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no tax_code and language cannot be null!");
			}
			
			count += this.dao.delete("dao.BaseBasSingleTaxSettingMapper.deleteSingleTax", map);
		}
		
		if (count>0) {
			result.put("successValue", true);
			result.put("description", "删除单一税别"+count+"笔，成功");
		}else{
			result.put("successValue", false);
			result.put("description", "删除单一税别"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 审核单一税别
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditSingleTax(List<Map<String,Object>> param, String status_code) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		
		int count = 0;
		Date date = new Date();
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no")) || StringUtils.isEmpty(map.get("tax_code")) || 
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no tax_code and language cannot be null!");
			}
			map.put("status_code", status_code);
			Map<String, Object> profile = DWServiceContext.getContext().getProfile();
			Object userId = profile.get("UserId");
					
			map.put("data_modified_by",userId);
			map.put("last_modified_date", date);
			count +=this.dao.update("dao.BaseBasSingleTaxSettingMapper.auditSingleTax", map);
		}
		
		if (count>0) {
			result.put("successValue", true);
			result.put("description", "审核单一税别"+count+"笔，成功");
		}else{
			result.put("successValue", false);
			result.put("description", "审核单一税别"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 新增单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addSingleTax(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("tax_code")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no tax_code and language cannot be null!");
		}
		param.put("status_code", "Y");
		int count = 0;
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasSingleTaxSettingMapper.selectTaxId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if(totalCount != 0){
			result.put("successValue", false);
			result.put("description", "已存在此笔记录");
		}else{
			Date date = new Date();
			param.put("last_modified_date", date);
			param.put("data_created_date",date);
			Map<String, Object> profile = DWServiceContext.getContext().getProfile();
			Object userId = profile.get("UserId");
			Object deptId = profile.get("DeptId");
			param.put("data_owner", userId);
			param.put("data_owned_department", deptId);
			param.put("data_created_by", userId);
			param.put("data_created_department", deptId);
			count += this.dao.insert("dao.BaseBasSingleTaxSettingMapper.addSingleTax", param);
			if (count>0) {
				result.put("successValue", true);
				result.put("description", "新增单一税别成功");
			}else{
				result.put("successValue", false);
				result.put("description", "新增单一税别失败");
			}
		}
		return result;
	}

	/**
	 * 判断单一税别是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeSingleTax(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("tax_code")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no tax_code and language cannot be null!");
		}
		
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasSingleTaxSettingMapper.selectTaxId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if(totalCount != 0){
			result.put("successValue", true);
			result.put("description", "该单一税别已存在");
		}else{
			result.put("successValue", false);
			result.put("description", "该单一税别不存在");
		}
		return result;
	}

	/**
	 * 根据主键查询单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getSingleTax(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no")) || StringUtils.isEmpty(param.get("tax_code")) || 
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no tax_code and language cannot be null!");
		}
		
		Object data = this.dao.query("dao.BaseBasSingleTaxSettingMapper.getSingleTax", param);
		if (data!=null) {
			result.put("data", data);
			result.put("successValue", true);
			result.put("description", "根据主键查询单一税别");
		}
		return result;
	}

}
