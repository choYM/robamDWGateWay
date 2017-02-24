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
import com.robam.distribution.base.service.IBrandService;

/**
 * drp_bas_s02 商品品牌 服务模块
 * @author gelf
 * @since 2017-02-14
 */
 
public class BrandService implements IBrandService {

	@Autowired
	private  Dao dao;
	
	/**
	 * 根据预设条件查询商品品牌列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	@Override
	public Object getBrandList(Map<String, Object> param, int startPage, int pageSize) throws Exception {
		param.put("language", "zh_CN");
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseApplicationCategoryCodesSettingMapper.selectBrandCount", "dao.BaseApplicationCategoryCodesSettingMapper.getBrandList", param, startPage, pageSize);
		Map<String,Object> response = new HashMap<String,Object>();
		if(result.getDatas().size() >= 0){
			response.put("successValue", true);
			response.put("description", "查询成功");
			response.put("data", result);
		}else{
			response.put("successValue", false);
			response.put("description", "查询失败");
		}
		return response;
	}

	/**
	 * 修改商品品牌
	 * @param param
	 * @return
	 */
	@Override
	public Object modifyBrand(Map<String, Object> param) throws Exception {
		
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		Map<String, Object> profile = DWServiceContext.getContext().getProfile();
		Object userId = profile.get("UserId");
				
		param.put("data_modified_by", userId);
		param.put("last_modified_date", new Date());
		int count = this.dao.update("dao.BaseApplicationCategoryCodesSettingMapper.updateBrand", param);
		
		return this.getResult(count);
	}

	/**
	 * 删除商品品牌
	 * @param param
	 * @return
	 */
	@Override
	@Transactional
	public Object deleteBrand(List<Map<String,Object>> param) throws Exception{
		
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
			
			count += dao.delete("dao.BaseApplicationCategoryCodesSettingMapper.deleteBrand", map);
		}
		
		return this.getResult(count);
	}

	/**
	 * 审核商品品牌
	 * @param param
	 * @param status_code
	 * @return
	 */
	@Override
	@Transactional
	public Object auditBrand(List<Map<String,Object>> param, String status_code) throws Exception{
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
			
			if(StringUtils.isEmpty(map.get("acc")) || StringUtils.isEmpty(map.get("acc_code")) 
					|| StringUtils.isEmpty(map.get("language")) ){
				throw new Exception("acc acc_code and language cannot be null!");
			}
			
			Map<String, Object> profile = DWServiceContext.getContext().getProfile();
			Object userId = profile.get("UserId");
					
			map.put("data_modified_by",userId);
			map.put("last_modified_date", date);
			map.put("status_code", status_code);
			map.put("last_modified_date", new Date());
			count = this.dao.update("dao.BaseApplicationCategoryCodesSettingMapper.auditBrand", map);
		}
		
		return this.getResult(count);
	}
	
	/**
	 * 新增商品品牌
	 * @param param
	 * @return
	 */
	@Override
	public Object addBrand(Map<String, Object> param) throws Exception{
		//判断商品品牌是否存在此笔记录
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		
		int count = 0;
		List<Integer> data = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.judgeBrand", param);
		
		if(data.size() > 0 && data.get(0) == 0){
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
			count = this.dao.insert("dao.BaseApplicationCategoryCodesSettingMapper.addBrand", param);
		}
		
		return this.getResult(count);
	}
	
	/**
	 * 判断商品品牌是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeBrand(Map<String, Object> param) throws Exception {
		
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		
		List<Integer> data = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.judgeBrand", param);
		
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
	private Object getResult(int count){
		
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
	 * 根据主键查询商品品牌
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getBrand(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		
		if(StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) 
				|| StringUtils.isEmpty(param.get("language")) ){
			throw new Exception("acc acc_code and language cannot be null!");
		}
		
		Object data = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.getBrand", param);
		if (data!=null) {
			result.put("data", data);
			result.put("successValue", true);
			result.put("description", "执行成功");
		}
		return result;
	}

}
