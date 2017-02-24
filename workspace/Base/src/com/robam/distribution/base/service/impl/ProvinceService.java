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
import com.robam.distribution.base.service.IProvinceService;
/**
 * drp_bas_m07 省别资料维护作业
 * @author gejc
 * @since 2017-02-14
 **/ 

public class ProvinceService implements IProvinceService {
	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询省别列表（分页）
	 * @author gejc
	 * @param startPage,pageSize,param
	 * @return Object
	 * @throws Exception
	 */
	@Override
	public Object getProvinceList(int startPage, int pageSize,
			Map<String,Object> param) throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseBasProvinceSettingMapper.getProvinceListCount", "dao.BaseBasProvinceSettingMapper.getProvinceList", param, startPage, pageSize);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile; 
	}
	
	/**
	 * 新增省别信息
	 * @author gejc
	 * @param param
	 * @return Object
	 * @throws Exception
	 */
	@Override
	public Object addProvince(Map<String,Object> param) throws Exception {
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
		if(StringUtils.isEmpty(param.get("country_region"))||
				StringUtils.isEmpty(param.get("province"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region,province and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasProvinceSettingMapper.getProvince",param );
		Map<String,Object> profile=new HashMap<String,Object>();
		if(li!=null&&li.size()>0){
			profile.put("successValue",false);
			profile.put("description", "新增数据失败！该编号数据已存在！");
		}else{
			param.put("status_code", "Y");
			int count= this.dao.insert("dao.BaseBasProvinceSettingMapper.addProvince", param);
			profile.put("successValue", count>0);
			String str=count>0?"成功":"失败";
			profile.put("description", "新增数据"+str);
		}
		return profile;
	}
	
	/**
	 * 修改省别信息
	 * @author gejc
	 * @param param
	 * @return Object
	 * @throws Exception
	 */
	@Override
	public Object modifyProvince(Map<String,Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("country_region"))||
				StringUtils.isEmpty(param.get("province"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region,province and language cannot be null!");
		}
		int count= this.dao.update("dao.BaseBasProvinceSettingMapper.updateProvince", param);
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "修改数据"+str);
		return profile;
	}
	
	/**
	 * 批量审批省别信息
	 * @author gejc
	 * @param param,status_code
	 * @return Object
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object auditProvince(List<Map<String,Object>> param,String status_code) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		if(status_code==null){
			throw new Exception("status_code cannot be null!");
		}
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("country_region"))||
					StringUtils.isEmpty(map.get("province"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("country_region,province and language cannot be null!");
			}
			map.put("status_code", status_code);
			map.put("data_modified_by", userId);
			map.put("last_modified_date", modifydate);
			count += dao.update("dao.BaseBasProvinceSettingMapper.auditProvince", map);
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
	 * 批量删除省别信息
	 * @author gejc
	 * @param param
	 * @return Object
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object deleteProvince(List<Map<String,Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("country_region"))||
					StringUtils.isEmpty(map.get("province"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("country_region,province and language cannot be null!");
			}
			count += dao.delete("dao.BaseBasProvinceSettingMapper.deleteProvince", map);
			dao.delete("dao.BaseBasProvinceSettingMapper.deleteCity", map);
			dao.delete("dao.BaseBasProvinceSettingMapper.deleteCounty", map);
			dao.delete("dao.BaseBasProvinceSettingMapper.deleteStreet", map);
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
	 * 判断省别资料是否存在
	 * @author gejc
	 * @param param
	 * @return Object
	 * @throws Exception
	 */
	@Override
	public Object judgeProvince(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("country_region"))||
				StringUtils.isEmpty(param.get("province"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region,province and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasProvinceSettingMapper.getProvince",param );
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
	 * 根据主键查询省别资料
	 * @author liaogz
	 * @param param
	 * @return Object
	 * @throws Exception
	 */
	@Override
	public Object getProvince(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("country_region"))||
				StringUtils.isEmpty(param.get("province"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("country_region,province and language cannot be null!");
		}
		Object data = this.dao.query("dao.BaseBasProvinceSettingMapper.getProvince", param);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("successValue", true);
		result.put("description", "");
		result.put("data", data);
		return result;
	}
}
