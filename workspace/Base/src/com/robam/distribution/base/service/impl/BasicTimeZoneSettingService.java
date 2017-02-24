package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IBasicTimeZoneSettingService;

/**
 * 時區設定作業
 * 
 * @author choYM
 * @since 2017-01-11
 */
public class BasicTimeZoneSettingService implements IBasicTimeZoneSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}

	@Override
	@Transactional
	public Object addBasicTimeZone(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("time_zone_no"))) {
			throw new Exception("time_zone_no cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("status_code", "Y");

		return dao.insert("addBasicTimeZone", params);
	}

	@Override
	@Transactional
	public Object deleteBasicTimeZone(List<String> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		return dao.delete("deleteBasicTimeZone", params);
	}

	@Override
	@Transactional
	public Object modifyBasicTimeZone(List<Map<String, Object>> params) throws Exception {
		int count = 0;
		
		for (Map<String, Object> map : params) {
			if (StringUtils.isEmpty(map.get("time_zone_no"))) {
				throw new Exception("time_zone_no cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());
			
			count += this.dao.update("updateBasicTimeZone", map);
		}
		

		return count;
	}

	@Override
	public Object getBasicTimeZoneList(Map<String, Object> params, int page, int pageRows) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));
		
		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);
		
		result.put("data", this.dao.query("searchBasicTimeZoneList", params));
		
		return result;
	}

	@Override
	public Object getBasicTimeZoneDetail(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("time_zone_no"))) {
			throw new Exception("time_zone_no cannot be null!");
		}

		return this.dao.query("searchBasicTimeZoneDetail", params);
	}

	private Object getTotalRows(Map<String, Object> params) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasicTimeZoneTotalRows", params).get(0);
		
		return result.get("totalRows");
	}
}
