package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IEmployeeGuideService;

/**
 * drp_bas_m99 门店导购员维护作业
 * @author YangJian
 * @date 2017-02-20
 */
public class EmployeeGuideService implements IEmployeeGuideService {

	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询门店导购员列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getEmployeeGuideList(Map<String, Object> param, Integer startPage, Integer pageSize)
			throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "CN");
		Object data = this.dao.executePagination("dao.BaseBasEmployeeGuideSettingMapper.SelectBasEmployeeCount",
				"dao.BaseBasEmployeeGuideSettingMapper.SelectBasEmployeeLimit", param, startPage, pageSize);
		profile.put("data", data);
		profile.put("successValue", true);
		profile.put("description", "根据预设条件查询门店导购员列表（分页）");
		return profile;
	}

	/**
	 * 修改门店导购员(包含审核门店导购员)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyEmployeeGuide(List<Map<String, Object>> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count =0;
		for (Map<String, Object> map : param) {
			map.put("language", "CN");
			if (StringUtils.isEmpty(map.get("employee_no")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("employee_no and language cannot be null!");
			}
			map.put("last_modified_date", new Date());
			count += this.dao.update("dao.BaseBasEmployeeGuideSettingMapper.modifyEmployeeGuide", map);
		}
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "修改门店导购员(包含审核门店导购员)"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "修改门店导购员(包含审核门店导购员)"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 删除门店导购员
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteEmployeeGuide(List<Map<String, Object>> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count =0;
		for (Map<String, Object> map : param) {
			map.put("language", "CN");
			if (StringUtils.isEmpty(map.get("employee_no")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("employee_no and language cannot be null!");
			}
			count += this.dao.delete("dao.BaseBasEmployeeGuideSettingMapper.deleteEmployeeGuide", map);
		}
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "删除门店导购员"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "删除门店导购员"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 新增门店导购员
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addEmployeeGuide(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "CN");
		if (StringUtils.isEmpty(param.get("employee_no")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("employee_no and language cannot be null!");
		}
		param.put("status_code", "Y");
		int count = 0;
		List<Map<String,Long>> data = this.dao.query("dao.BaseBasEmployeeGuideSettingMapper.getEmployeeGuide", param);
		Long totalCount = data.get(0).get("count");
		if (totalCount != 0) {
			profile.put("successValue", true);
			profile.put("description", "该导购员已存在,请勿重复添加");
		}else {
			Date date = new Date();
			param.put("last_modified_date", date);
			param.put("data_created_date",date);
			
			count += this.dao.insert("dao.BaseBasEmployeeGuideSettingMapper.addEmployeeGuide", param);
			if (count>0) {
				profile.put("successValue", true);
				profile.put("description", "新增门店导购员"+count+"笔，成功");
			}else {
				profile.put("successValue", false);
				profile.put("description", "新增门店导购员"+count+"笔，失败");
			}
		}
		return profile;
	}

	/**
	 * 根据门店导购员(判断门店导购员是否存在)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getEmployeeGuide(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "CN");
		if (StringUtils.isEmpty(param.get("employee_no")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("employee_no and language cannot be null!");
		}
		List<Map<String,Long>> data = this.dao.query("dao.BaseBasEmployeeGuideSettingMapper.getEmployeeGuide", param);
		Long totalCount = data.get(0).get("count");
		if (totalCount != 0) {
			profile.put("data", data);
			profile.put("successValue", true);
			profile.put("description", "该导购员已存在,请勿重复添加");
		}else {
			profile.put("successValue", false);
			profile.put("description", "该导购员不存在");
		}
		return profile;
	}

}
