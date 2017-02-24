package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IEmployeeTitleService;

/**
 * drp_bas_m04-员工职称维护作业
 * @author YangJian
 * @date 2017-02-17
 *
 */
public class EmployeeTitleService implements IEmployeeTitleService {

	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询员工职称列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getEmployeeTitleList(Map<String, Object> param, Integer startPage, Integer pageSize)
			throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseApplicationCategoryCodesSettingMapper.BasEmployeeTitleCount", 
				"dao.BaseApplicationCategoryCodesSettingMapper.BasEmployeeTitleLimit", param, startPage, pageSize);
		result.put("data", data);
		result.put("successValue", true);
		result.put("description", "根据预设条件查询员工职称列表（分页）");
		return result;
	}

	/**
	 * 修改员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyEmployeeTitle(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("acc acc_code and language cannot be null!");
		}
		int count = 0;
		Map<String, Object> profile = DWServiceContext.getContext().getProfile();
		Object userId = profile.get("UserId");
				
		param.put("data_modified_by", userId);
		param.put("last_modified_date", new Date());
		count += this.dao.update("dao.BaseApplicationCategoryCodesSettingMapper.modifyEmployeeTitle", param);
		if (count>0) {
			result.put("successValue", true);
			result.put("description", "修改员工职称"+count+"笔，成功");
		}else{
			result.put("successValue", false);
			result.put("description", "修改员工职称"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 删除员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteEmployeeTitle(List<Map<String, Object>> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("acc")) || StringUtils.isEmpty(map.get("acc_code")) || 
					StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("acc acc_code and language cannot be null!");
			}
			count += this.dao.delete("dao.BaseApplicationCategoryCodesSettingMapper.deleteEmployeeTitle", map);
		}
		if (count>0) {
			result.put("successValue", true);
			result.put("description", "删除员工职称"+count+"笔，成功");
		}else{
			result.put("successValue", false);
			result.put("description", "删除员工职称"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 审核员工职称
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditEmployeeTitle(List<Map<String, Object>> param,String status_code) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		Date date = new Date();
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("acc")) || StringUtils.isEmpty(map.get("acc_code")) || 
					StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("acc acc_code and language cannot be null!");
			}
			map.put("status_code",status_code);
			Map<String, Object> profile = DWServiceContext.getContext().getProfile();
			Object userId = profile.get("UserId");
					
			map.put("data_modified_by",userId);
			map.put("last_modified_date", date);
			count += this.dao.update("dao.BaseApplicationCategoryCodesSettingMapper.auditEmployeeTitle", map);
		}
		if (count>0) {
			result.put("successValue", true);
			result.put("description", "审核员工职称"+count+"笔，成功");
		}else{
			result.put("successValue", false);
			result.put("description", "审核员工职称"+count+"笔，失败");
		}
		return result;
	}

	/**
	 * 新增员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addEmployeeTitle(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("acc acc_code and language cannot be null!");
		}
		param.put("status_code", "Y");
		int count = 0;
		List<Map<String,Long>> id = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.judgeEmployeeTitle", param);
		Map<String, Long> firstRow = id.get(0);
		Long totalCount = firstRow.entrySet().iterator().next().getValue();
		if (totalCount!=0) {
			result.put("successValue", true);
			result.put("description", "该职工职称已存在，不要重复插入");
		}else{
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
			count += this.dao.insert("dao.BaseApplicationCategoryCodesSettingMapper.addEmployeeTitle", param);
			if (count>0) {
				result.put("successValue", true);
				result.put("description", "新增员工职称"+count+"笔，成功");
			}else{
				result.put("successValue", false);
				result.put("description", "新增员工职称"+count+"笔，失败");
			}
		}
		return result;
	}

	/**
	 * 判断员工职称是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object judgeEmployeeTitle(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("acc acc_code and language cannot be null!");
		}
		List<Map<String,Long>> id = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.judgeEmployeeTitle", param);
		Map<String, Long> firstRow = id.get(0);
		Long totalCount = firstRow.entrySet().iterator().next().getValue();
		if (totalCount!=0) {
			result.put("successValue", true);
			result.put("description", "该职工职称已存在，不要重复插入");
		}else{
			result.put("successValue", false);
			result.put("description", "该职工职称不存在");
		}
		return result;
	}

	/**
	 * 根据主键查询员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getEmployeeTitle(Map<String, Object> param) throws Exception {
		Map<String,Object> result = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("acc_code")) || 
				StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("acc acc_code and language cannot be null!");
		}
		
		Object data = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.getEmployeeTitle", param);
		if (data!=null) {
			result.put("data", data);
			result.put("successValue", true);
			result.put("description", "根据主键查询员工职称");
		}
		return result;
	}

}
