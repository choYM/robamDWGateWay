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
import com.robam.distribution.base.service.IInvoiceTypeService;

/**
 * drp_bas_f12 发票类型维护作业
 * @author yangjian
 * @since 2017-02-14
 *
 */
 
public class InvoiceTypeService implements IInvoiceTypeService {
	
	@Autowired
	private Dao dao;
	/**
	 * 根据预设条件查询发票类型列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getInvoiceTypeList(Map<String, Object> param, Integer startPage, Integer pageSize)
			throws Exception {
		Map<String, Object> profile = new HashMap<String,Object>();
		DWPaginationQueryResult datas = this.dao.executePagination("dao.BaseBasInvoiceTypeSettingMapper.selectInvoiceTypeCount", "dao.BaseBasInvoiceTypeSettingMapper.selectInvoiceTypeLimit", param, startPage, pageSize);
		if(datas!=null){
			profile.put("data", datas);
			profile.put("successValue",true);
			profile.put("description", "根据预设条件查询发票类型列表（分页） 成功");
		}else{
			profile.put("successValue",true);
			profile.put("description", "根据预设条件查询发票类型列表（分页） 数据为空");
		}
		return profile;
	}
	
	/**
	 * 修改发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyInvoiceType(Map<String,Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("transaction_tax_area")) || StringUtils.isEmpty(param.get("invoice_type")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("transaction_tax_area invoice_type and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		int count = this.dao.update("dao.BaseBasInvoiceTypeSettingMapper.modifyInvoiceType", param);
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

	/**
	 * 删除发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteInvoiceType(List<Map<String,Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		int count = 0;
		for (Map<String, Object> map : param) {
			     map.put("language", "zh_CN");
			if (map.get("transaction_tax_area")==null || map.get("transaction_tax_area")==""
				|| map.get("invoice_type")==null || map.get("invoice_type")==""
				|| map.get("language")==null || map.get("language")=="") 
			{
				throw new Exception("transaction_tax_area invoice_type and language cannot be null!");
			} else {
				count += dao.delete("dao.BaseBasInvoiceTypeSettingMapper.deleteInvoiceType", map);
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

	/**
	 * 审核发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditInvoiceType(List<Map<String,Object>> param,String status_code) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		Map<String, Object> result = new HashMap<String, Object>();
		if (!status_code.isEmpty()) {
			int count = 0;
			for (Map<String, Object> map : param) {
				map.put("language", "zh_CN");
				if (map.get("transaction_tax_area")==null || map.get("transaction_tax_area")==""
						|| map.get("invoice_type")==null || map.get("invoice_type")==""
						|| map.get("language")==null || map.get("language")=="") 
				{
					throw new Exception("transaction_tax_area invoice_type and language cannot be null!");
					
					
				} else {
					Map<String,Object> information=DWServiceContext.getContext().getProfile();
					Object userId = information.get("UserId");
					map.put("last_modified_date", new Date());
					map.put("data_modified_by",userId);
					map.put("status_code", status_code);
					count += dao.update("dao.BaseBasInvoiceTypeSettingMapper.auditInvoiceType",map);
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

	/**
	 * 新增发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addInvoiceType(Map<String,Object> param) throws Exception {
		param.put("language", "zh_CN");
		param.put("status_code", "Y");
		if (StringUtils.isEmpty(param.get("transaction_tax_area")) || StringUtils.isEmpty(param.get("invoice_type")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("transaction_tax_area invoice_type and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasInvoiceTypeSettingMapper.judgeInvoiceType", param);
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.size() > 0 && data.get(0) > 0){
			result.put("successValue", false);
			result.put("description", "新增发票类型失败，原因：该编号已存在，不允许重复插入");
		}else if(data.size() > 0 && data.get(0) == 0){
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
			this.dao.insert("dao.BaseBasInvoiceTypeSettingMapper.addInvoiceType", param);
			result.put("successValue", true);
			result.put("description", "新增发票类型 成功");
		}
		return result;
	}

	@Override
	public Object judgeInvoiceType(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("transaction_tax_area")) || StringUtils.isEmpty(param.get("invoice_type")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("transaction_tax_area invoice_type and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasInvoiceTypeSettingMapper.judgeInvoiceType", param);
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
	public Object getInvoiceType(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("transaction_tax_area")) || StringUtils.isEmpty(param.get("invoice_type")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("transaction_tax_area invoice_type and language cannot be null!");
		}
		List<Map<String,Object>> data = this.dao.query("dao.BaseBasInvoiceTypeSettingMapper.getInvoiceTypeOne", param);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("successValue", data!=null);
		result.put("description", "查询数据"+data!=null?"成功":"失败");
		result.put("data", data!=null?data.get(0):null);
		return result;
	}
}
