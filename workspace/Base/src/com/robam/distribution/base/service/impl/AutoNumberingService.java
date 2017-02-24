package com.robam.distribution.base.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IAutoNumberingService;

/**
 * drp_sys_m03 自动编码设置维护作业规格
 * @author YangJian
 * @date 2017-02-21
 */
public class AutoNumberingService implements IAutoNumberingService {

	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询自动编码设置列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getAutoNumberingList(Map<String, Object> param, Integer startPage, Integer pageSize)
			throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseBasAutoNumberingSettingMapper.selectAutoNumberingCount",
				"dao.BaseBasAutoNumberingSettingMapper.selectAutoNumberingLimit", param, startPage, pageSize);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "根据预设条件查询自动编码设置列表（分页）");
		return result;
	}

	/**
	 * 修改自动编码设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyAutoNumbering(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("rule_number")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("rule_number and language cannot be null!");
		}
		int count =0;
		int mcount = 0;
		List<Map<String,Object>> item_list = (List<Map<String,Object>>) param.get("item_list");
		if (item_list!=null) {
			count += this.dao.delete("dao.BaseBasAutoNumberingSettingMapper.deleteAutoNumbering", param);
			if (count>0) {
				for (Map<String,Object> map : item_list) {
					map.put("status_code", "Y");
					Date date = new Date();
					map.put("last_modified_date", date);
					map.put("data_created_date", date);
					map.put("language", "zh_CN");
					Map<String, Object> profile = DWServiceContext.getContext().getProfile();
					Object userId = profile.get("UserId");
					Object deptId = profile.get("DeptId");
					param.put("data_owner", userId);
					param.put("data_owned_department", deptId);
					param.put("data_created_by", userId);
					param.put("data_created_department", deptId);
					map.put("rule_number", param.get("rule_number"));
					map.put("rule_number_description", param.get("rule_number_description"));
					map.put("program_no", param.get("program_no"));
					map.put("pragram_name", param.get("pragram_name"));
					map.put("total_numbering_length", param.get("total_numbering_length"));
					map.put("numbering_result", param.get("numbering_result"));
					map.put("table_no", param.get("table_no"));
					map.put("table_name", param.get("table_name"));
					map.put("note", param.get("note"));
					map.put("numbering_field_no", param.get("numbering_field_no"));
					map.put("numbering_field_name", param.get("numbering_field_name"));
					mcount += this.dao.update("dao.BaseBasAutoNumberingSettingMapper.addAutoNumbering", map);
				}
			}
		}
		if (mcount>0) {
			result.put("description", "修改自动编码设置，成功");
			result.put("successValue", true);
		}else{
			result.put("description", "修改自动编码设置,失败");
			result.put("successValue", false);
		}
		return result;
	}

	/**
	 * 删除自动编码设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteAutoNumbering(List<Map<String, Object>> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count=0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("rule_number")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("rule_number and language cannot be null!");
			}
			count += this.dao.delete("dao.BaseBasAutoNumberingSettingMapper.deleteAutoNumbering", map);
		}

		if (count>0) {
			result.put("successValue", true);
			result.put("description", "删除自动编码设置"+count+"笔，成功");
		}else {
			result.put("successValue", false);
			result.put("description", "删除自动编码设置"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 审核自动编码设置
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditAutoNumbering(List<Map<String, Object>> param, String status_code) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		Date date = new Date();
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("rule_number")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("rule_number and language cannot be null!");
			}
			map.put("status_code", status_code);
			Map<String, Object> profile = DWServiceContext.getContext().getProfile();
			Object userId = profile.get("UserId");
					
			map.put("data_modified_by",userId);
			map.put("last_modified_date", date);
			count += this.dao.update("dao.BaseBasAutoNumberingSettingMapper.auditAutoNumbering", map);
		}
		if (count>0) {
			result.put("successValue", true);
			result.put("description", "审核自动编码设置"+count+"笔，成功");
		}else {
			result.put("successValue", false);
			result.put("description", "审核自动编码设置"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 新增自动编码设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addAutoNumbering(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("rule_number")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("rule_number and language cannot be null!");
		}
		
		int count = 0;
		List<Map<String,Long>> data = this.dao.query("dao.BaseBasAutoNumberingSettingMapper.getAutoNumbering1", param);
		Long totalCount = data.get(0).get("count");
		if (totalCount != 0) {
			result.put("successValue", true);
			result.put("description", "该自动编码已存在,请勿重复添加");
		}else {
			List<Map<String,Object>> item_list = (List<Map<String, Object>>) param.get("item_list");
			if (item_list!=null) {
				for (Map<String, Object> map : item_list) {
					map.put("status_code", "Y");
					Date date = new Date();
					map.put("last_modified_date", date);
					map.put("data_created_date", date);
					Map<String, Object> profile = DWServiceContext.getContext().getProfile();
					Object userId = profile.get("UserId");
					Object deptId = profile.get("DeptId");
					param.put("data_owner", userId);
					param.put("data_owned_department", deptId);
					param.put("data_created_by", userId);
					param.put("data_created_department", deptId);
					map.put("language", "zh_CN");
					map.put("rule_number", param.get("rule_number"));
					map.put("rule_number_description", param.get("rule_number_description"));
					map.put("program_no", param.get("program_no"));
					map.put("pragram_name", param.get("pragram_name"));
					map.put("total_numbering_length", param.get("total_numbering_length"));
					map.put("numbering_result", param.get("numbering_result"));
					map.put("table_no", param.get("table_no"));
					map.put("table_name", param.get("table_name"));
					map.put("note", param.get("note"));
					map.put("numbering_field_no", param.get("numbering_field_no"));
					map.put("numbering_field_name", param.get("numbering_field_name"));
					count += this.dao.insert("dao.BaseBasAutoNumberingSettingMapper.addAutoNumbering", map);
				}
			}
			if (count>0) {
				result.put("successValue", true);
				result.put("description", "新增门店导购员"+count+"笔，成功");
			}else {
				result.put("successValue", false);
				result.put("description", "新增门店导购员"+count+"笔，失败");
			}
		}
		return result;
	}

	/**
	 * 根据主键获取记录（判断自动编码设置是否存在）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getAutoNumbering(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("rule_number")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("rule_number and language cannot be null!");
		}
		
		List<Map<String,Object>> data = this.dao.query("dao.BaseBasAutoNumberingSettingMapper.getAutoNumbering1", param);
		Long totalCount = (Long) data.get(0).get("count");
		List<Map<String,Object>> item_list = this.dao.query("dao.BaseBasAutoNumberingSettingMapper.getAutoNumbering2", param);
		
		for (Map<String, Object> map : data) {
			map.put("item_list", item_list);
		}
		if (totalCount != 0) {
			result.put("data", data.get(0));
			result.put("successValue", true);
			result.put("description", "该导购员已存在,请勿重复添加");
		}else {
			result.put("successValue", false);
			result.put("description", "该导购员不存在");
		}
		return result;
	}

}
