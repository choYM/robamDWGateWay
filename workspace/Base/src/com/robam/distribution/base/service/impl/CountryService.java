package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ICountryService;

/**
 * drp_bas_m06 国家资料维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 
 
public class CountryService implements ICountryService{
	@Autowired
	private Dao dao;
	
	@Override
	public Map<String, Object> getCountryList(Map<String, Object> param,int startPage, int pageSize) throws Exception {
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseBasCountrySettingMapper.selectCount", "dao.BaseBasCountrySettingMapper.selectLimit", param, startPage, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "");
		map.put("data", data);
		return map;
	}

	@Override
	public Map<String, Object> modifyCountry(Map<String,Object> param) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region and language cannot be null!");
		}
		int count = this.dao.update("dao.BaseBasCountrySettingMapper.modifyCountry", param);
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

	@Transactional
	@Override
	public Map<String, Object> deleteCountry(List<String> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		int count = 0;
		for (String country_region : param) {
			if (!country_region.isEmpty()) {
				Map<String, Object> deleteInfo = new HashMap<String, Object>();
				deleteInfo.put("language", "zh_CN");
				deleteInfo.put("country_region", country_region);
				count += dao.delete("dao.BaseBasCountrySettingMapper.deleteCountry", deleteInfo);
				this.dao.delete("dao.BaseBasCountrySettingMapper.deleteProvince", deleteInfo);
				this.dao.delete("dao.BaseBasCountrySettingMapper.deleteCity", deleteInfo);
				this.dao.delete("dao.BaseBasCountrySettingMapper.deleteCounty", deleteInfo);
				this.dao.delete("dao.BaseBasCountrySettingMapper.deleteStreet", deleteInfo);
			} else {
				throw new Exception("country_region cannot be null!");
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("successValue", true);
			map.put("description", "删除资料成功");
		}else {
			map.put("successValue", false);
			map.put("description", "删除资料失败");
		}
		return map;
	}

	
	@Override
	public Map<String, Object> auditCountry(List<String> param, String status_code) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		Map<String, Object> map = new HashMap<String, Object>();
		if (!status_code.isEmpty()) {
			int count = 0;
			for (String country_region : param) {
				if (!country_region.isEmpty()) {
					Map<String, Object> deleteInfo = new HashMap<String, Object>();
					deleteInfo.put("language", "zh_CN");
					deleteInfo.put("status_code", status_code);
					deleteInfo.put("country_region", country_region);
					deleteInfo.put("data_modified_by", userId);
					deleteInfo.put("last_modified_date", modifydate);
					count += dao.update("dao.BaseBasCountrySettingMapper.auditCountry", deleteInfo);
				} else {
					throw new Exception("country_region cannot be null!");
				}
			}
			if (count > 0) {
				map.put("successValue", true);
				map.put("description", "审核成功");
			} else {
				map.put("successValue", false);
				map.put("description", "审核失败");
			}
		}else {
			throw new Exception("status_code cannot be null!");
		}
		return map;
	}

	@Override
	public Map<String, Object> addCountry(Map<String,Object> param) throws Exception {
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
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasCountrySettingMapper.judgeCountry", param);
		Map<String, Object> map = new HashMap<String, Object>();
		if (data.size() > 0 && data.get(0) > 0) {
			map.put("successValue", false);
			map.put("description", "已存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			param.put("status_code", "Y");
			this.dao.insert("dao.BaseBasCountrySettingMapper.addCountry", param);
			map.put("successValue", true);
			map.put("description", "数据插入成功");
		}
		return map;
	}

	@Override
	public Map<String, Object> judgeCountry(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasCountrySettingMapper.judgeCountry", param);
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
	public Map<String, Object> getCountry(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("country_region and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasCountrySettingMapper.getCountry", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}

}
