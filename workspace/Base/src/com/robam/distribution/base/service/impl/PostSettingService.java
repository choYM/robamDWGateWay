package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IPostSettingService;

/**
 * drp_bas_m11-郵政資料維護
 * 
 * @author choYM
 * @since 2017-01-18
 */
public class PostSettingService implements IPostSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}
	
	@Override
	public Object addBasPostcode(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		if (StringUtils.isEmpty(params.get("country_region")) || StringUtils.isEmpty(params.get("serial_no")) || 
				StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("country_region, serial_no, and language cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("status_code", "Y");

		return dao.insert("addBasPostcode", params);
	}

	@Override
	public Object deleteBasPostcode(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasPostcode", map);
		}

		return count;
	}

	@Override
	public Object modifyBasPostcode(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			
			if (StringUtils.isEmpty(map.get("country_region")) || StringUtils.isEmpty(map.get("serial_no")) || 
					StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("country_region, serial_no, and language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());

			count += this.dao.update("updateBasPostcode", map);
		}

		return count;
	}
	
	@Override
	public Object getBasPostcodeList(Map<String, Object> params, int page, int pageRows) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("searchBasPostcodeList", params));

		return result;
	}

	@Override
	public Object getBasPostcodeDetail(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		if (StringUtils.isEmpty(params.get("country_region")) || StringUtils.isEmpty(params.get("serial_no")) || 
				StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("country_region, serial_no, and language cannot be null!");
		}

		return this.dao.query("searchBasPostcodeDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasPostcodeTotalRows", params).get(0);

		return result.get("totalRows");
	}
}
