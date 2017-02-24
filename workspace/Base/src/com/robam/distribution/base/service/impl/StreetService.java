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
import com.robam.distribution.base.service.IStreetService;

/**
 * drp_bas_m10 街道资料维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 
 
public class StreetService implements IStreetService{

	@Autowired
	private Dao dao;

	@Override
	public Map<String, Object> getStreetList(Map<String, Object> param,int startPage, int pageSize) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.put("language", "CN");
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseBasStreetSettingMapper.selectCount", "dao.BaseBasStreetSettingMapper.selectLimit", param, startPage, pageSize);
		profile.put("successValue", true);
		profile.put("description", "");
		profile.put("data", result);
		return profile;
	
	}

	@Override
	public Map<String, Object> modifyStreet(Map<String,Object> param) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "CN");
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) || StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("county_district")) || StringUtils.isEmpty(param.get("street")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region province city county_district street and language cannot be null!");
		}
		int count = this.dao.update("dao.BaseBasStreetSettingMapper.modifyStreet", param);
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
	public Map<String, Object> deleteStreet(List<Map<String, Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		int count = 0;
		for (Map<String, Object> map : param) {
			     map.put("language", "CN");
			if (map.get("country_region")==null || map.get("country_region")==""
				|| map.get("province")==null || map.get("province")==""
				|| map.get("city")==null || map.get("city")==""
				|| map.get("county_district")==null || map.get("county_district")==""
				|| map.get("street")==null || map.get("street")==""
				|| map.get("language")==null || map.get("language")=="") 
			{
				throw new Exception("country_region province city county_district street and language cannot be null!");
			} else {
				count += dao.delete("dao.BaseBasStreetSettingMapper.deleteStreet", map);
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
	public Map<String, Object> auditStreet(List<Map<String, Object>> param,String status_code) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		Map<String, Object> result = new HashMap<String, Object>();
		if (!status_code.isEmpty()) {
			int count = 0;
			for (Map<String, Object> map : param) {
				map.put("language", "CN");
				if (map.get("country_region")==null || map.get("country_region")==""
						|| map.get("province")==null || map.get("province")==""
						|| map.get("city")==null || map.get("city")==""
						|| map.get("county_district")==null || map.get("county_district")==""
						|| map.get("street")==null || map.get("street")==""
						|| map.get("language")==null || map.get("language")=="") 
				{
					throw new Exception("country_region province city county_district street and language cannot be null!");
					
					
				} else {
					map.put("status_code", status_code);
					map.put("data_modified_by", userId);
					map.put("last_modified_date", modifydate);
					count += dao.update("dao.BaseBasStreetSettingMapper.auditStreet",map);
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
	public Map<String, Object> addStreet(Map<String,Object> param) throws Exception {
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
		param.put("language", "CN");
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) || StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("county_district")) || StringUtils.isEmpty(param.get("street")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region province city county_district street and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasStreetSettingMapper.judgeStreet", param);
		Map<String,Object> map = new HashMap<String,Object>();
		if(data.size() > 0 && data.get(0) > 0){
			map.put("successValue", false);
			map.put("description", "存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			this.dao.insert("dao.BaseBasStreetSettingMapper.addStreet",param);
			map.put("successValue", true);
			map.put("description", "资料新增成功");
		}
		return map;
	}

	@Override
	public Map<String, Object> judgeStreet(Map<String, Object> param) throws Exception {
		param.put("language", "CN");
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) || StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("county_district")) || StringUtils.isEmpty(param.get("street")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region province city county_district street and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasStreetSettingMapper.judgeStreet", param);
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
	public Map<String, Object> getStreet(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) || StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("county_district")) || StringUtils.isEmpty(param.get("street")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region province city county_district street and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasStreetSettingMapper.getStreet", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}

}
