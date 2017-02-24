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
import com.robam.distribution.base.service.ICountryDistrictService;

/**
 * drp_bas_m09 县区资料服务
 * @author xiongjh
 * @since 2017-02-14
 */

public class CountryDistrictService implements ICountryDistrictService{
	private String FLanguage="zh_CN";

	@Autowired
	private Dao dao;

	/**
	 * 分頁查詢
	 * @param pageNumber 查詢的頁次
	 * @param  BasCountryDistrict传过来的查询条件
	 * @return 分頁查詢結果
	 * @throws Exception 異常
	 */
	@Override
	public Object getCountryDistrictList(Map<String,Object> param,int startPage, int pageSize) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.put("language", FLanguage);
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseBasCountryDistrictSettingMapper.selectCount", "dao.BaseBasCountryDistrictSettingMapper.selectLimit", param, startPage, pageSize);
		profile.put("successValue", true);
		profile.put("description", "查询县区资料");
		profile.put("data", result);
		return profile;
	
	}

	/**
	 * 修改县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyCountryDistrict(Map<String,Object> param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", FLanguage);
		int count = 0;
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language")) || StringUtils.isEmpty(param.get("county_district"))){
			throw new Exception("country_region province city county_district and language cannot be null!");
		}
		count += this.dao.update("dao.BaseBasCountryDistrictSettingMapper.updateBasCountryDistrict",param);
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "修改县区资料"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "修改县区资料"+count+"笔，失败");
		}
		
		return profile;
	}

	/**
	 * 删除县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Object deleteCountryDistrict(List<Map<String,Object>> param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", FLanguage);
			
			if(StringUtils.isEmpty(map.get("country_region")) || StringUtils.isEmpty(map.get("province")) 
					||StringUtils.isEmpty(map.get("city")) || StringUtils.isEmpty(map.get("language")) || StringUtils.isEmpty(map.get("county_district"))){
				throw new Exception("country_region province city county_district and language cannot be null!");
			}
			
			count += this.dao.delete("dao.BaseBasCountryDistrictSettingMapper.deleteBasCountryDistrict",map);
			this.dao.delete("dao.BaseBasCountryDistrictSettingMapper.deleteBasStreet",map);
		}

		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "删除县区资料"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "删除县区资料"+count+"笔，失败");
		}
		
		return profile;
	}

	/**
	 * 审核县区资料
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditCountryDistrict(List<Map<String,Object>> param, String status_code) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();

		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", FLanguage);
			
			if(StringUtils.isEmpty(map.get("country_region")) || StringUtils.isEmpty(map.get("province")) 
					||StringUtils.isEmpty(map.get("city")) || StringUtils.isEmpty(map.get("language")) || StringUtils.isEmpty(map.get("county_district"))){
				throw new Exception("country_region province city county_district and language cannot be null!");
			}
			map.put("data_modified_by", userId);
			map.put("last_modified_date", modifydate);
			map.put("status_code", status_code);
			count += this.dao.update("dao.BaseBasCountryDistrictSettingMapper.auditBasCountryDistrict",map);
		}
		
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "审核县区资料"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "审核县区资料"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 新增县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addCountryDistrict(Map<String,Object> param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
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
		param.put("status_code", "Y");
		param.put("language", FLanguage);
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language")) || StringUtils.isEmpty(param.get("county_district"))){
			throw new Exception("country_region province city county_district and language cannot be null!");
		}
		int count = 0;
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasCountryDistrictSettingMapper.selectRepeat",param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if(totalCount !=0){
			profile.put("successValue", false);
			profile.put("description","新增县区资料档失败，原因：该县区编号已存在，不允许重复插入");
		}else{
			count += this.dao.insert("dao.BaseBasCountryDistrictSettingMapper.addBasCountryDistrict",param);
			if (count>0) {
				profile.put("successValue", true);
				profile.put("description", "新增县区资料成功");
			}else{
				profile.put("successValue", false);
				profile.put("description", "失败");
			}
		}
		
		return profile;
	}

	/**
	 * 判断县区资料是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeCountryDistrict(Map<String, Object> param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.put("language", FLanguage);
		
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language")) || StringUtils.isEmpty(param.get("county_district"))){
			throw new Exception("country_region province city county_district and language cannot be null!");
		}
		
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasCountryDistrictSettingMapper.selectRepeat", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if (totalCount!=0) {
			profile.put("successValue", true);
			profile.put("description", "县区资料存在");
		}else{
			profile.put("successValue", false);
			profile.put("description", "县区资料不存在");
		}
		return profile;
	}

	/**
	 * 根据主键查询县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCountryDistrict(Map<String, Object> param) throws Exception {
		param.put("language", FLanguage);
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language")) || StringUtils.isEmpty(param.get("county_district"))){
			throw new Exception("country_region province city county_district and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasCountryDistrictSettingMapper.getCountryDistrict", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}
	
}
