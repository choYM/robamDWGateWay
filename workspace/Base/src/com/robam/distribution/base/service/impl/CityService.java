package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.app.service.DWLoginResult;
import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ICityService;

/**
 * drp_bas_m08 城市资料维护作业
 * @author yangjian
 * @since 2017-02-14
 **/

public class CityService implements ICityService {
	
	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询城市列表（分页）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCityList(int startPage, int pageSize, Map<String,Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language","zh_CN");
		DWPaginationQueryResult data = this.dao.executePagination("dao.BaseBasCitySettingMapper.selectCount", "dao.BaseBasCitySettingMapper.selectLimit", param, startPage, pageSize);
		profile.put("successValue",true);
		profile.put("description", "根据预设条件查询城市列表（分页）");
		profile.put("data", data);
		DWLoginResult<Object> result = new DWLoginResult<Object>(profile, profile);
		return result;
	}

	/**
	 * 修改城市资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyCity(Map<String,Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		int count = 0;
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language","zh_CN");
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region province city and language cannot be null!");
		}
		count += this.dao.update("dao.BaseBasCitySettingMapper.updateCity", param);
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "修改城市资料 "+count+"笔,成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "修改城市资料 "+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 删除城市资料档
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Object deleteCity(List<Map<String,Object>> param) throws Exception {
		Map<String,Object> profile=new HashMap<String, Object>();
		int count = 0;
		if (param == null || param.size() ==0) {
			throw new Exception("Pls select at least one data!");
		}
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			
			if (StringUtils.isEmpty(map.get("country_region")) || StringUtils.isEmpty(map.get("province")) || 
					StringUtils.isEmpty(map.get("city")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("country_region province city and language cannot be null!");
			}
			
			count += this.dao.delete("dao.BaseBasCitySettingMapper.deleteCity", map);
			this.dao.delete("dao.BaseBasCitySettingMapper.deleteCounty", map);
			this.dao.delete("dao.BaseBasCitySettingMapper.deleteStreet", map);
		}
		
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "删除城市资料档"+count+"笔,成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "删除城市资料档"+count+"笔，失败");
		}
		
		return profile;
	}

	/**
	 * 审核城市资料档
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditCity(List<Map<String,Object>> param,String status_code) throws Exception {
		Map<String,Object> profile=new HashMap<String, Object>();
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		int count = 0;
		if (param == null || param.size() ==0) {
			throw new Exception("Pls select at least one data!");
		}
		
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			map.put("status_code", status_code);
			map.put("data_modified_by", userId);
			map.put("last_modified_date", modifydate);
			
			if (StringUtils.isEmpty(map.get("country_region")) || StringUtils.isEmpty(map.get("province")) || 
					StringUtils.isEmpty(map.get("city")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("country_region province city and language cannot be null!");
			}
			
			count += this.dao.delete("dao.BaseBasCitySettingMapper.auditCity", map);
		}
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "审核城市资料档"+count+"笔,成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "审核城市资料档"+count+"笔，失败");
		}
		
		return profile;
	}

	/**
	 * 新增城市资料档
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addCity(Map<String,Object> param) throws Exception {
		Map<String,Object> profile=new HashMap<String, Object>();
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
		
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region province city and language cannot be null!");
		}
		
		param.put("status_code", "Y");
		
		
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasCitySettingMapper.queryCountId", param);
		Map<String, Long> firstRow = id.get(0);
		int count=0;
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if(totalCount !=0){
			profile.put("successValue", false);
			profile.put("description","新增城市资料档失败，原因：该城市编号已存在，不允许重复插入");
		}else{
			count += this.dao.insert("dao.BaseBasCitySettingMapper.addCity", param);
			if (count>0) {
				profile.put("successValue", true);
				profile.put("description", "新增城市资料档成功");
			}else{
				profile.put("successValue", false);
				profile.put("description", "新增城市资料档失败");
			}
		}
		return profile;
	}

	/**
	 * 判断城市资料是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeCity(Map<String, Object> param) throws Exception {
		Map<String,Object> profile=new HashMap<String, Object>();
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region province city and language cannot be null!");
		}
		List<Map<String, Long>> id =this.dao.query("dao.BaseBasCitySettingMapper.queryCountId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if (totalCount!=0) {
			profile.put("successValue", true);
			profile.put("description", "城市资料存在");
		}else{
			profile.put("successValue", false);
			profile.put("description", "城市资料不存在");
		}
		return profile;
	}

	/**
	 * 根据主键查询城市资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCity(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("country_region")) || StringUtils.isEmpty(param.get("province")) 
				||StringUtils.isEmpty(param.get("city")) || StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region province city and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasCitySettingMapper.getCity", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}
}
