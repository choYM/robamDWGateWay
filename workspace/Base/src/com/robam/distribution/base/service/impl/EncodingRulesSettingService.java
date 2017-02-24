package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IEncodingRulesSettingService;

/**
 * drp_bas_m23-鑷嫊閭婄⒓瑷疆浣滄キ
 * 
 * @author Enoch
 * @since 2017-02-18
 */

public class EncodingRulesSettingService implements IEncodingRulesSettingService {

	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}

	@Override
	public Object addEncodingRules(List<Map<String, Object>> params) throws Exception {
		int count = 0;
		
		// 鍙栧緱鐣跺墠鏈?澶у簭铏?
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getMaxEnocodingRulesSerialNo", params.get(0)).get(0);
		int serialNo = result != null ? Integer.valueOf(result.get("maxSerialNo").toString()) : 0;

		for (Map<String, Object> map : params) {
			serialNo++;
			map.put("language", "zh_CN");

			if (StringUtils.isEmpty(map.get("rule_number")) || StringUtils.isEmpty(map.get("language")) || StringUtils.isEmpty(map.get("serial_no"))) {
				throw new Exception("rule_number , serial_no and language cannot be null!");
			}
			map.put("serial_no",serialNo);
			map.put("data_created_date", new Date());
			map.put("status_code", "Y");

			count += this.dao.insert("addEncodingRules", map);
		}

		return count;
	}

	@Override
	public Object modifyEncodingRules(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");

			if (StringUtils.isEmpty(map.get("rule_number")) || StringUtils.isEmpty(map.get("language")) || StringUtils.isEmpty(map.get("serial_no"))) {
				throw new Exception("rule_number , serial_no and language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());

			count += this.dao.update("modifyEncodingRules", map);
		}

		return count;
	}

	@Override
	public Object deleteEncodingRules(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteEncodingRules", map);
		}

		return count;
	}

	@Override
	public Object getEncodingRulesList(Map<String, Object> params, int page, int pageRows) throws Exception {
		params.put("language", "zh_CN");

		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("getEncodingRulesList", params));

		return result;
	}

	@Override
	public Object getEncodingRulesListDetail(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");

		if (StringUtils.isEmpty(params.get("rule_number")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("rule_number and language cannot be null!");
		}

		return this.dao.query("getEncodingRulesListDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getEncodingRulesTotalRows", params).get(0);

		return result.get("totalRows");
	}

}
