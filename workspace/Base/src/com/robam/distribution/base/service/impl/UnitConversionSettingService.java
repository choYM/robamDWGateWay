package com.robam.distribution.base.service.impl;


import java.util.HashMap;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IUnitConversionSettingService;

/**
 * drp_bas_m22-單位維護轉換作業
 * 
 * @author choYM
 * @since 2017-02-02
 */
public class UnitConversionSettingService implements IUnitConversionSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}
	
	@Override
	public Object addBasUnitConversionRate(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("source_unit")) || StringUtils.isEmpty(params.get("destination_unit"))) {
			throw new Exception("source_unit or destination_unit cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("language", "zh_CN");
		params.put("status_code", "Y");

		return dao.insert("addBasUnitConversionRate", params);
	}

	@Override
	public Object deleteBasUnitConversionRate(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasUnitConversionRate", map);
		}

		return count;
	}

	@Override
	public Object modifyBasUnitConversionRate(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			if (StringUtils.isEmpty(map.get("source_unit")) || StringUtils.isEmpty(map.get("destination_unit"))) {
				throw new Exception("source_unit or destination_unit cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());
			map.put("language", "zh_CN");

			count += this.dao.update("modifyBasUnitConversionRate", map);
		}

		return count;
	}
	
	@Override
	public Object getBasUnitConversionRateList(Map<String, Object> params, int page, int pageRows) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("searchBasUnitConversionRateList", params));

		return result;
	}

	@Override
	public Object getBasUnitConversionRateDetail(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("source_unit")) || StringUtils.isEmpty(params.get("destination_unit"))) {
			throw new Exception("source_unit and destination_unit cannot be null!");
		}

		return this.dao.query("searchBasUnitConversionRateDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasUnitConversionrateTotalRows", params).get(0);

		return result.get("totalRows");
	}
}
