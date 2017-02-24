package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.ICollectionTermSettingService;

/**
 * drp_bas_f08-收款條件維護
 * 
 * @author choYM
 * @since 2017-01-23
 */
public class CollectionTermSettingService implements ICollectionTermSettingService{
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}
	
	@Override
	public Object addBasCollectCondition(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		if (StringUtils.isEmpty(params.get("payment_term_no")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("payment_term_no and language cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("status_code", "Y");

		return dao.insert("addBasCollectCondition", params);
	}

	@Override
	public Object deleteBasCollectCondition(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasCollectCondition", map);
		}

		return count;
	}

	@Override
	public Object modifyBasCollectCondition(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			if (StringUtils.isEmpty(map.get("payment_term_no"))) {
				throw new Exception("payment_term_no cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());
			map.put("language", "zh_CN");

			count += this.dao.update("updateBasCollectCondition", map);
		}

		return count;
	}
	
	@Override
	public Object getBasCollectConditionList(Map<String, Object> params, int page, int pageRows) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("searchBasCollectConditionList", params));

		return result;
	}

	@Override
	public Object getBasCollectConditionDetail(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("payment_term_no"))) {
			throw new Exception("payment_term_no cannot be null!");
		}

		params.put("language", "zh_CN");
		
		return this.dao.query("searchBasCollectConditionDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasCollectConditionTotalRows", params).get(0);

		return result.get("totalRows");
	}
}
