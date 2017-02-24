package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IUnitSettingService;

/**
 * drp_bas_m21-單位維護作業
 * 
 * @author choYM
 * @since 2017-02-02
 */
public class UnitSettingService implements IUnitSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}
	
	@Override
	public Object addBasUnit(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		if (StringUtils.isEmpty(params.get("unit")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("unit and language cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("status_code", "Y");

		return dao.insert("addBasUnit", params);
	}

	@Override
	public Object modifyBasUnit(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			
			if (StringUtils.isEmpty(map.get("unit")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("unit and language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());

			count += this.dao.update("modifyBasUnit", map);
		}

		return count;
	}

	@Override
	public Object deleteBasUnit(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasUnit", map);
		}

		return count;
	}

	@Override
	public Object getBasUnitList(Map<String, Object> params, int page, int pageRows) throws Exception {
		params.put("language", "zh_CN");
		
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);
		
		result.put("data", this.dao.query("searchBasUnitList", params));

		return result;
	}

	@Override
	public Object getBasUnitDetail(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("unit"))) {
			throw new Exception("unit cannot be null!");
		}
		
		params.put("language", "zh_CN");

		return this.dao.query("searchBasUnitDetail", params);
	}
	
	/**
	 * get total data count
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private Object getTotalRows(Map<String, Object> params) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasUnitTotalRows", params).get(0);

		return result.get("totalRows");
	}

}
