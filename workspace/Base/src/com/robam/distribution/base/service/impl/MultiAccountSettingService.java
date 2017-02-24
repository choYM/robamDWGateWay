package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IMultiAccountSettingService;

/**
 * drp_bas_f11-多账期设定档
 * 
 * @author Enoch
 * @since 2017-02-15
 */

public class MultiAccountSettingService implements IMultiAccountSettingService {

	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}

	@Override
	public Object addMultiAccount(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
		
			map.put("language", "zh_CN");
			
			if (StringUtils.isEmpty(map.get("multiple_account_period")) || StringUtils.isEmpty(map.get("language")) || StringUtils.isEmpty(map.get("periods"))) {
				throw new Exception("multiple_account_period , period and language cannot be null!");
			}
			map.put("data_created_date", new Date());
			map.put("status_code", "Y");

			count += this.dao.insert("addMultiAccount", map);
		}

		return count;
	}

	@Override
	public Object modifyMultiAccount(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");

			if (StringUtils.isEmpty(map.get("multiple_account_period")) || StringUtils.isEmpty(map.get("language")) || StringUtils.isEmpty(map.get("periods"))) {
				throw new Exception("multiple_account_period , period and language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());

			count += this.dao.update("modifyMultiAccount", map);
		}

		return count;
	}

	@Override
	public Object deleteMultiAccount(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteMultiAccount", map);
		}

		return count;
	}

	@Override
	public Object getMultiAccountList(Map<String, Object> params, int page, int pageRows) throws Exception {
		params.put("language", "zh_CN");

		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("searchMultiAccountList", params));

		return result;
	}

	@Override
	public Object getMultiAccountDetail(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");

		if (StringUtils.isEmpty(params.get("multiple_account_period")) || StringUtils.isEmpty(params.get("language")) || StringUtils.isEmpty(params.get("money_setting"))) {
			throw new Exception("multiple_account_period , money_setting and language cannot be null!");
		}

		return this.dao.query("searchMultiAccountDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getMultiAccountTotalRows", params).get(0);

		return result.get("totalRows");
	}

}
