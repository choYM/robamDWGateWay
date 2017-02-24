package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ISitePaymentTypeService;

/**
 * drp_bas_f10 款别依据点设置服务
 * @author YangJian
 * @since 2017-02-14
 *
 */
public class SitePaymentTypeService implements ISitePaymentTypeService {

	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询缴款优惠条件维护列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getSitePaymentTypeList(Map<String, Object> param, Integer startPage, Integer pageSize)
			throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		Object data =this.dao.executePagination("dao.BaseBasSitePaymentTypeSettingMapper.BasSitePaymentTypeSelectCount", 
				"dao.BaseBasSitePaymentTypeSettingMapper.BasSitePaymentTypeSelectLimit", param, startPage, pageSize);
		profile.put("data", data);
		profile.put("successValue", true);
		profile.put("description", "根据预设条件查询缴款优惠条件维护列表（分页）");
		return profile;
	}

	/**
	 * 修改款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifySitePaymentType(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language","zh_CN");
		if (StringUtils.isEmpty(param.get("operation_organization")) || StringUtils.isEmpty(param.get("payment_type")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("operation_organization payment_type and language cannot be null!");
		}
		//条件判断数值是否为空，为空设置为0
		if(param.get("collection_poundage_rate")==null || "".equals(param.get("collection_poundage_rate"))){
			param.put("collection_poundage_rate", 0);
		}else if(param.get("collection_poundage_money")==null || "".equals(param.get("collection_poundage_money"))){
			param.put("collection_poundage_money",0);
		}else if(param.get("entryno_minimum_length")==null || "".equals(param.get("entryno_minimum_length"))){
			param.put("entryno_minimum_length",0);
		}else if(param.get("standard_poundage_rate")==null || "".equals(param.get("standard_poundage_rate"))){
			param.put("standard_poundage_rate",0);
		}else if(param.get("tax_deduction_sequence")==null || "".equals(param.get("tax_deduction_sequence"))){
			param.put("tax_deduction_sequence",0);
		}else if(param.get("card_ceilling_money")==null || "".equals(param.get("card_ceilling_money"))){
			param.put("card_ceilling_money",0);
		}else if(param.get("ceilling_poundage_money")==null || "".equals(param.get("ceilling_poundage_money"))){
			param.put("ceilling_poundage_money",0);
		}
		int count = 0;
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		count += this.dao.update("dao.BaseBasSitePaymentTypeSettingMapper.modifySitePaymentType", param);
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "修改款别依据点设置"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "修改款别依据点设置"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 删除款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteSitePaymentType(List<Map<String,Object>> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count=0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("operation_organization")) || StringUtils.isEmpty(map.get("payment_type")) || 
					StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("operation_organization payment_type and language cannot be null!");
			}
			count += this.dao.delete("dao.BaseBasSitePaymentTypeSettingMapper.deleteSitePaymentType", map);
		}
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "删除款别依据点设置"+count+"笔，成功");
		}else {
			profile.put("successValue", false);
			profile.put("description", "删除款别依据点设置"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 审核款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditSitePaymentType(List<Map<String,Object>> param,String status_code) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("operation_organization")) || StringUtils.isEmpty(map.get("payment_type")) || 
					StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("operation_organization payment_type and language cannot be null!");
			}
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			map.put("last_modified_date", new Date());
			map.put("data_modified_by",userId);
			map.put("status_code", status_code);
			count +=this.dao.update("dao.BaseBasSitePaymentTypeSettingMapper.auditSitePaymentType", map);
		}
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "审核款别依据点设置"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "审核款别依据点设置"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 新增款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addSitePaymentType(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("operation_organization")) || StringUtils.isEmpty(param.get("payment_type")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("operation_organization payment_type and language cannot be null!");
		}
		param.put("status_code", "Y");
		int count=0;
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasSitePaymentTypeSettingMapper.selectPaymentId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if(totalCount != 0){
			profile.put("successValue", false);
			profile.put("description", "已存在此笔记录");
		}else {
			Date date = new Date();
			param.put("last_modified_date", date);
			param.put("data_created_date",date);
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			Object deptId = information.get("DeptId");
			param.put("data_owner",userId);
			param.put("data_owned_department",deptId);
			param.put("data_created_by",userId);
			param.put("data_created_department",deptId);
			param.put("data_modified_by",userId);
			count += this.dao.insert("dao.BaseBasSitePaymentTypeSettingMapper.addSitePaymentType", param);
			if (count>0) {
				profile.put("successValue", true);
				profile.put("description", "新增款别依据点设置"+count+"笔，成功");
			}else{
				profile.put("successValue", false);
				profile.put("description", "新增款别依据点设置"+count+"笔，失败");
			}
		}
		return profile;
	}

	/**
	 * 判断款别依据点设置是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeSitePaymentType(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("operation_organization")) || StringUtils.isEmpty(param.get("payment_type")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("operation_organization payment_type and language cannot be null!");
		}
		List<Map<String, Long>> id = this.dao.query("dao.BaseBasSitePaymentTypeSettingMapper.selectPaymentId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		if(totalCount != 0){
			profile.put("successValue", true);
			profile.put("description", "该款别依据点设置已存在");
		}else{
			profile.put("successValue", false);
			profile.put("description", "该款别依据点设置不存在");
		}
		return profile;
	}
	
	@Override
	public Object getSitePaymentType(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("operation_organization")) || StringUtils.isEmpty(param.get("payment_type")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("operation_organization payment_type and language cannot be null!");
		}
		List<Map<String, Object>> li = this.dao.query("dao.BaseBasSitePaymentTypeSettingMapper.getPaymentOne", param);
		profile.put("successValue", li!=null);
		profile.put("data", li!=null?li.get(0):null);
		profile.put("description", "查询数据"+li!=null?"成功":"失败");
		return profile;
	}
}
