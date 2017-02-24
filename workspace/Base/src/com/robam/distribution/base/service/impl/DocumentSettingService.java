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
import com.robam.distribution.base.service.IDocumentSettingService;
/**
 * 单据别设置
 * @author liaogz
 * @since2017-2-17
 *drp_sys_m01
 */
public class DocumentSettingService implements IDocumentSettingService{
	@Autowired
	private Dao dao;
	
	/**
	 * 分页查询
	 * @param param查询条件
	 * @param startPage页码
	 * @param pageSize每页多少数据
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getDocumentSettingList(Map<String, Object> param, int startPage, int pageSize)
			throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.put("language", "zh_CN");
		DWPaginationQueryResult result = this.dao.executePagination("dao.BaseSysDocumentSettingSettingMapper.selectDocumentCount", "dao.BaseSysDocumentSettingSettingMapper.selectDocumentLimit", param, startPage, pageSize);
		profile.put("successValue", true);
		profile.put("description", "");
		profile.put("data", result);
		return profile;
	}

	/**
	 * 修改单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> modifyDocumentSetting(Map<String, Object> param) throws Exception {
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		param.put("data_modified_by", userId);
		param.put("last_modified_date", modifydate);
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("document")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("document and language cannot be null!");
		}
		int count=0;
		count += this.dao.update("dao.BaseSysDocumentSettingSettingMapper.modifyDocumentSetting", param);
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
	 * 批量删除单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> deleteDocumentSetting(List<Map<String, Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		int count = 0;
		for (Map<String, Object> map : param) {
			     map.put("language", "zh_CN");
			if (map.get("document")==null || map.get("document")==""
				|| map.get("language")==null || map.get("language")=="") 
			{
				throw new Exception("document and language cannot be null!");
			} else {
				count += dao.delete("dao.BaseSysDocumentSettingSettingMapper.deleteDocumentSetting", map);
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
	 * 批量审核单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> auditDocumentSetting(List<Map<String, Object>> param,String status_code) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		Map<String, Object> information = DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Date modifydate = new Date();
		Map<String, Object> result = new HashMap<String, Object>();
		if (!status_code.isEmpty()) {
			int count = 0;
			for (Map<String, Object> map : param) {
				map.put("language", "zh_CN");
				if (map.get("document")==null || map.get("document")==""
						|| map.get("language")==null || map.get("language")=="") 
				{
					throw new Exception("document and language cannot be null!");
				} else {
					map.put("status_code", status_code);
					map.put("data_modified_by", userId);
					map.put("last_modified_date", modifydate);
					count += dao.update("dao.BaseSysDocumentSettingSettingMapper.auditDocumentSetting",map);
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
	 * 新增单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> addDocumentSetting(Map<String, Object> param) throws Exception {
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
		if (StringUtils.isEmpty(param.get("document")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("document and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseSysDocumentSettingSettingMapper.judgeDocumentSetting", param);
		Map<String,Object> map = new HashMap<String,Object>();
		if(data.size() > 0 && data.get(0) > 0){
			map.put("successValue", false);
			map.put("description", "存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			this.dao.insert("dao.BaseSysDocumentSettingSettingMapper.addDocumentSetting",param);
			map.put("successValue", true);
			map.put("description", "资料新增成功");
		}
		return map;
	}

	/**
	 * 判断单据别设置是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> judgeDocumentSetting(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("document")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("document and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseSysDocumentSettingSettingMapper.judgeDocumentSetting", param);
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
	public Map<String, Object> getDocumentSettingByDoc(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("document")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("document and language cannot be null!");
		}
		Map<String, Object> profile = new HashMap<String, Object>();
		Object result = this.dao.query("dao.BaseSysDocumentSettingSettingMapper.getDocumentSettingByDoc", param);
		profile.put("successValue", true);
		profile.put("description", "");
		profile.put("data", result);
		return profile;
	}

}
