package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IReceivableTypeSettingService;

/**
 * drp_bas_f05-應收帳款維護
 * 
 * @author choYM
 * @since 2017-01-23
 */
public class ReceivableTypeSettingService implements IReceivableTypeSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}
	
	@Override
	@Transactional
	public Object addApplicationCategoryCodes(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("acc_code"))) {
			throw new Exception("acc_code or language cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("language", "zh_CN");
		params.put("status_code", "Y");
		params.put("acc", "basf05a");
		return dao.insert("addApplicationCategoryCodes", params);
	}

	@Override
	@Transactional
	public Object deleteApplicationCategoryCodes(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteApplicationCategoryCodes", map);
		}

		return count;
	}

	@Override
	@Transactional
	public Object modifyApplicationCategoryCodes(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			if (StringUtils.isEmpty(map.get("acc_code"))) {
				throw new Exception("acc_code or language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());
			map.put("language", "zh_CN");

			count += this.dao.update("updateApplicationCategoryCodes", map);
		}

		return count;
	}
	
	@Override
	public Object getApplicationCategoryCodesList(Map<String, Object> params, int page, int pageRows) throws Exception {
		params.put("acc", "basf05a");
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("searchApplicationCategoryCodesList", params));

		return result;
	}

	@Override
	public Object getApplicationCategoryCodesDetail(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("acc_code")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("acc_code and language cannot be null!");
		}

		return this.dao.query("searchApplicationCategoryCodesDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getApplicationCategoryCodesTotalRows", params).get(0);

		return result.get("totalRows");
	}
}
