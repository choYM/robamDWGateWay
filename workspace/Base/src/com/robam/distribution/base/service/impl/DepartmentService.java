package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IDepartmentService;

/**
 * drp-bas-m02 部门资料维护作业
 * @author YangJian
 * @date by 2017-02-20
 * 
 */
public class DepartmentService implements IDepartmentService {

	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询部门列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getDepartmentList(Map<String, Object> param, Integer startPage, Integer pageSize) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseBasDepartmentSettingMapper.SelectBasDepartmentCount",
				"dao.BaseBasDepartmentSettingMapper.SelectBasDepartmentLimit", param, startPage, pageSize);
		profile.put("data", data);
		profile.put("successValue", true);
		profile.put("description", "根据预设条件查询部门列表（分页）");
		return profile;
	}

	/**
	 * 修改部门(包含审核部门)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyDepartment(List<Map<String, Object>> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count =0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("department")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("department and language cannot be null!");
			}
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			map.put("last_modified_date", new Date());
			map.put("data_modified_by",userId);
			count += this.dao.update("dao.BaseBasDepartmentSettingMapper.modifyDepartment", map);
		}
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "修改部门(包含审核部门)"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "修改部门(包含审核部门)"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 删除部门
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteDepartment(List<Map<String, Object>> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count =0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if (StringUtils.isEmpty(map.get("department")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("department and language cannot be null!");
			}
			count += this.dao.delete("dao.BaseBasDepartmentSettingMapper.deleteDepartment", map);
		}
		if (count>0) {
			profile.put("successValue", true);
			profile.put("description", "删除部门"+count+"笔，成功");
		}else{
			profile.put("successValue", false);
			profile.put("description", "删除部门"+count+"笔，失败");
		}
		return profile;
	}

	/**
	 * 新增部门
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addDepartment(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("department")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("department and language cannot be null!");
		}
		param.put("status_code", "Y");
		int count = 0;
		List<Map<String,Long>> data = this.dao.query("dao.BaseBasDepartmentSettingMapper.getDepartment", param);
		Long totalCount = data.get(0).get("count");
		if (totalCount != 0) {
			profile.put("successValue", true);
			profile.put("description", "该部门已存在,请勿重复添加");
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
			count += this.dao.insert("dao.BaseBasDepartmentSettingMapper.addDepartment", param);
			if (count>0) {
				profile.put("successValue", true);
				profile.put("description", "新增部门"+count+"笔，成功");
			}else {
				profile.put("successValue", false);
				profile.put("description", "新增部门"+count+"笔，失败");
			}
		}
		return profile;
	}

	/**
	 * 根据部门主键获取相关记录(判断部门是否存在)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getDepartment(Map<String, Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("department")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("department and language cannot be null!");
		}
		List<Map<String,Long>> data = this.dao.query("dao.BaseBasDepartmentSettingMapper.getDepartment", param);
		Long totalCount = data.get(0).get("count");
		if (totalCount!=0) {
			profile.put("data", data);
			profile.put("successValue", true);
			profile.put("description", "该部门已存在");
		}else {
			profile.put("successValue", false);
			profile.put("description", "该部门不存在");
		}
		return profile;
	}

}
