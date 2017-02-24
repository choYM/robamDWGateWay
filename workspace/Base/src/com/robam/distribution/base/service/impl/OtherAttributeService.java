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
import com.robam.distribution.base.service.IOtherAttributeService;

/**
 * drp_bas_s04 商品-属性维护作业
 * drp_bas_s06 门店属性维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 

public class OtherAttributeService implements IOtherAttributeService{
	@Autowired
	private Dao dao;


	/**
	 * @param param查询条件对象
	 * @param startPage起始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getOtherAttributeList(Map<String, Object> param, int startPage, int pageSize)
			throws Exception {
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseApplicationCategoryCodesSettingMapper.selectOtherAttributeCount", "dao.BaseApplicationCategoryCodesSettingMapper.selectOtherAttributeLimit", param, startPage, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "");
		map.put("data", data);
		return map;
	}

	/**
	 * @param param需要修改的内容
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> modifyOtherAttribute(Map<String,Object> param) throws Exception {
		
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		Map<String, Object> profile = DWServiceContext.getContext().getProfile();
		Object userId = profile.get("UserId");
				
		param.put("data_modified_by", userId);
		param.put("last_modified_date", new Date());
		int count = this.dao.update("dao.BaseApplicationCategoryCodesSettingMapper.updateOtherAttribute",param);
		
		return this.getResult(count);
		
	}

	/**
	 * @param param前端传的对象数组
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Map<String, Object> deleteOtherAttribute(List<Map<String,Object>> param) throws Exception {
		
		if(param == null || param.size() == 0){
			throw new Exception("Pls select at least one data!");
		}
		
		int count = 0;
		
		for(Map<String,Object> map : param){
			
			map.put("language", "zh_CN");
			
			if(StringUtils.isEmpty(map.get("acc")) || StringUtils.isEmpty(map.get("acc_code")) 
					|| StringUtils.isEmpty(map.get("language")) ){
				throw new Exception("acc acc_code and language cannot be null!");
			}
			
			count += this.dao.delete("dao.BaseApplicationCategoryCodesSettingMapper.deleteOtherAttribute",map);
			
		}
		
		return this.getResult(count);
	}

	/**
	 * @param param前端传的要审核的关于主键的对象数组
	 * @param status_code状态码
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional
	public Map<String, Object> auditOtherAttribute(List<Map<String,Object>> param, String status_code)
			throws Exception {
		
		if(param == null || param.size() == 0){
			throw new Exception("Pls select at least one data!");
		}
		
		if(StringUtils.isEmpty(status_code) || status_code.length() != 1){
			throw new Exception("status_code wrong format !");
		}
		
		int count = 0;
		
		Date date = new Date();
		for(Map<String,Object> map : param){
			
			map.put("language", "zh_CN");
			
			map.put("status_code", status_code);
			if(StringUtils.isEmpty(map.get("acc")) || StringUtils.isEmpty(map.get("acc_code")) 
					|| StringUtils.isEmpty(map.get("language")) ){
				throw new Exception("acc acc_code and language cannot be null!");
			}
			Map<String, Object> profile = DWServiceContext.getContext().getProfile();
			Object userId = profile.get("UserId");
					
			map.put("data_modified_by",userId);
			map.put("last_modified_date", date);

			count += this.dao.update("dao.BaseApplicationCategoryCodesSettingMapper.auditOtherAttribute",map);
			
		}
		
		return this.getResult(count);
	}

	/**
	 * @param param要新增的资料对象
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> addOtherAttribute(Map<String,Object> param) throws Exception {
		
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.judgeOtherAttribute", param);

		int count = 0;
		
		if (data.size() >= 0 && data.get(0) == 0) {
			param.put("status_code", "Y");
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
			count = this.dao.insert("dao.BaseApplicationCategoryCodesSettingMapper.addOtherAttribute",param);
		
		}
		
		return this.getResult(count);
	}
	/**
	 * 判断主键是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> judgeOtherAttribute(Map<String, Object> param) throws Exception {
		
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		
		List<Integer> data = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.judgeOtherAttribute", param);
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		if(data.get(0) > 0){
			//存在此笔记录
			result.put("successValue", true);
			result.put("description", "执行成功");
		}else{
			//不存在此笔记录，可以添加
			result.put("successValue", false);
			result.put("description", "执行成功");
		}
		
		return result;
	}
	
	
	/**
	 * 将执行的结果封装成标准输出
	 * @param data
	 * @return
	 */
	private Map<String,Object> getResult(int count){
		
		Map<String,Object> result = new HashMap<String,Object>();
		
		if(count > 0){
			result.put("successValue", true);
			result.put("description", "执行成功");
		}else{
			result.put("successValue", false);
			result.put("description", "执行失败");
		}
		
		return result;
	}

	/**
	 * 根据主键查询商品其他属性
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getOtherAttribute(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		
		Object data = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.getOtherAttribute", param);
		if (data!=null) {
			result.put("data", data);
			result.put("successValue", true);
			result.put("description", "执行成功");
		}
		return result;
	}


}
