package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IAccountSettingService;

/**
 * drp_bas_f06-帳別資料維護
 * 
 * @author Enoch	
 * @since 2017-02-23
 */
public class AccountSettingService implements IAccountSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}

	@Override
	public Object addBasAccountType(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");

		if (StringUtils.isEmpty(params.get("account_set")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("account_set and language cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("status_code", "Y");

		return dao.insert("addBasAccountType", params);
	}

	@Override
	public Object modifyBasAccountType(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			
			if (StringUtils.isEmpty(map.get("account_set")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("account_set and language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());

			count += this.dao.update("modifyBasAccountType", map);
		}

		return count;
	}

	@Override
	public Object deleteBasAccountType(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasAccountType", map);
		}

		return count;
	}

	@Override
	public Object getBasAccountTypeList(Map<String, Object> params, int page, int pageRows) throws Exception {
		params.put("language", "zh_CN");
		
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);
		
		result.put("data", this.dao.query("getBasAccountTypeList", params));

		return result;
	}

	@Override
	public Object getBasAccountTypeDetail(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		if (StringUtils.isEmpty(params.get("account_set")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("account_set and language cannot be null!");
		}
		
		return this.dao.query("getBasAccountTypeDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasAccountTypeTotalRows", params).get(0);

		return result.get("totalRows");
	}


}
