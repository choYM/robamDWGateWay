package com.robam.distribution.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ISiteCategoryService;

/**
 * drp_bas_s05 门店类别维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 

public class SiteCategoryService implements ISiteCategoryService{
	@Autowired
	private Dao dao;

	@Override
	public Map<String, Object> getSiteCategoryList(Map<String, Object> param, int startPage, int pageSize) throws Exception {
		param.put("language", "CN");
		Object data = this.dao.executePagination("dao.BaseApplicationCategoryCodesSettingMapper.selectSiteCategoryCount", "dao.BaseApplicationCategoryCodesSettingMapper.selectSiteCategoryLimit", param, startPage, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "");
		map.put("data", data);
		return map;
	}

	@Override
	public Map<String, Object> modifySiteCategory(Map<String,Object> param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		param.put("language", "CN");
		this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.updateSiteCategory",param);
		profile.put("successValue", true);
		profile.put("description", "修改资料成功");
		return profile;
	}

	@Override
	public Map<String, Object> deleteSiteCategory(List<Map<String,Object>> param) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> paramer = new HashMap<String, Object>();
		paramer.put("language", "CN");
		paramer.put("list", param);
		this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.deleteSiteCategory",paramer);
		profile.put("successValue", true);
		profile.put("description", "删除成功");
		return profile;
	}

	@Override
	public Map<String, Object> auditSiteCategory(List<Map<String,Object>> param, String status_code) throws Exception {
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> paramer = new HashMap<String, Object>();
		paramer.put("status_code", status_code);
		paramer.put("language", "CN");
		paramer.put("list", param);
		this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.auditSiteCategory",paramer);
		profile.put("successValue", true);
		profile.put("description", "审核成功");
		return profile;
	}

	@Override
	public Map<String, Object> addSiteCategory(Map<String,Object> param) throws Exception {
		param.put("language", "CN");
		List<Map<String, Long>> id = this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.selectSiteCategoryId", param);
		Map<String, Long> firstRow = id.get(0);
		long totalCount = firstRow.entrySet().iterator().next().getValue();
		Map<String, Object> map = new HashMap<String, Object>();
		if (totalCount != 0) {
			map.put("successValue", false);
			map.put("description", "已存在此笔记录");
		}else {
			this.dao.query("dao.BaseApplicationCategoryCodesSettingMapper.addSiteCategory",param);
			map.put("successValue", true);
			map.put("description", "资料新增成功");
		}
		return map;
	}

}
