package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IContinentSettingService;

/**
 * drp_bas_m05-洲別維護
 * 
 * @author choYM
 * @since 2017-01-16
 */
public class ContinentSettingService implements IContinentSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}

	@Override
	public Object addBasContinent(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("continent")) || StringUtils.isEmpty(params.get("continent_name"))) {
			throw new Exception("continent or continent_name cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("language", "zh_CN");
		params.put("status_code", "Y");

		return dao.insert("addBasContinent", params);
	}

	@Override
	public Object deleteBasContinent(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		
		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasContinent", map);
		}
		
		return count;
	}

	@Override
	public Object modifyBasContinent(List<Map<String, Object>> params) throws Exception {
		int count = 0;
		
		for (Map<String, Object> map : params) {
			if (StringUtils.isEmpty(map.get("continent")) || StringUtils.isEmpty(map.get("continent_name"))) {
				throw new Exception("continent and continent_name cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());
			map.put("language", "zh_CN");
			
			count += this.dao.update("updateBasContinent", map);
		}

		return count;
	}

	@Override
	public Object getBasContinentList(Map<String, Object> params, int page, int pageRows) throws Exception {
		params.put("language", "zh_CN");
		
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("searchBasContinentList", params));

		return result;
	}

	@Override
	public Object getBasContinentDetail(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("continent")) && StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("continent and language cannot be null!");
		}

		return this.dao.query("searchBasContinentDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasContinentTotalRows", params).get(0);

		return result.get("totalRows");
	}
}
