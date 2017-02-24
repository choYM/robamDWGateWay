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
import com.robam.distribution.base.service.IAccContrastService;
/**
 * drp_bas_m36-应用分类对照表维护作业
 * @author liaogz
 * @since 2017-02-20
 *
 */
public class AccContrastService implements IAccContrastService{
	
	@Autowired
	private Dao dao;

	/**
	 * 根据预设条件查询应用分类对照表列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getAccContrastList(Map<String, Object> param, int startPage, int pageSize)
			throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.put("language", "zh_CN");
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseBasAccContrastSettingMapper.selectAccContrastCount", "dao.BaseBasAccContrastSettingMapper.selectAccContrastLimit", param, startPage, pageSize);
		profile.put("successValue", true);
		profile.put("description", "");
		profile.put("data", result);
		return profile;
	}

	/**
	 * 修改应用分类对照表(包含审核应用分类对照表)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> modifyAccContrast(List<Map<String, Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		Map<String, Object> result = new HashMap<String, Object>();
			int count = 0;
			for (Map<String, Object> map : param) {
				map.put("language", "zh_CN");
				Map<String,Object> information=DWServiceContext.getContext().getProfile();
				Object userId = information.get("UserId");
				map.put("last_modified_date", new Date());
				map.put("data_modified_by",userId);
				if (map.get("acc")==null || map.get("acc")==""
						|| map.get("language")==null || map.get("language")=="") 
				{
					throw new Exception("acc and language cannot be null!");
				} else {
					count += dao.update("dao.BaseBasAccContrastSettingMapper.modifyAccContrast",map);
				}
			}
			if (count > 0) {
				result.put("successValue", true);
				result.put("description", "修改成功");
			} else {
				result.put("successValue", false);
				result.put("description", "修改失败");
			}
		
		return result;
	}

	/**
	 * 删除应用分类对照表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> deleteAccContrast(List<Map<String, Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		int count = 0;
		for (Map<String, Object> map : param) {
			     map.put("language", "zh_CN");
			if (map.get("acc")==null || map.get("acc")==""
				|| map.get("language")==null || map.get("language")=="") 
			{
				throw new Exception("acc and language cannot be null!");
			} else {
				count += dao.delete("dao.BaseBasAccContrastSettingMapper.deleteAccContrast", map);
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
	 * 新增应用分类对照表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> addAccContrast(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
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
		if (StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("acc and language cannot be null!");
		}
		Map<String, Object> profile = new HashMap<String, Object>();
		List<Map<String,Long>> result = this.dao.query("dao.BaseBasAccContrastSettingMapper.getAccContrast", param);
		if (result.get(0).get("count") != 0) {
			profile.put("successValue", false);
			profile.put("description", "数据重复");
		}else {
			this.dao.insert("dao.BaseBasAccContrastSettingMapper.addAccContrast", param);
			profile.put("successValue", true);
			profile.put("description", "新增成功");
		}
		return profile;
	}

	/**
	 * 根据应用分类对照表获取相关记录(判断应用分类对照表是否存在)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getAccContrast(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("acc")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("acc and language cannot be null!");
		}
		Map<String, Object> profile = new HashMap<String, Object>();
		List<Map<String,Long>> result = this.dao.query("dao.BaseBasAccContrastSettingMapper.getAccContrast", param);
		if (result.get(0).get("count") != 0) {
			profile.put("successValue", true);
			profile.put("description", "");
			profile.put("data", result);
		}else {
			profile.put("successValue", false);
			profile.put("description", "没有数据");
		}
		return profile;
	}

}
