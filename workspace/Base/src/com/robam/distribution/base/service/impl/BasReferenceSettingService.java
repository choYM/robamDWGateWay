package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IBasReferenceSettingService;

/**
 * 參照表設定作業
 * 
 * @author Enoch
 * @since 2017-01-20
 */
public class BasReferenceSettingService implements IBasReferenceSettingService {

	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}

	@Override
	public Object addBasReferenceTables(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		if (StringUtils.isEmpty(params.get("reference_table_no")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("reference_table_no and language cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("status_code", "Y");

		return dao.insert("addBasReferenceTables", params);
	}

	@Override
	public Object deleteBasReferenceTables(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasReferenceTables", map);
		}

		return count;
	}

	@Override
	public Object modifyBasReferenceTables(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			
			if (StringUtils.isEmpty(map.get("reference_table_no")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("reference_table_no and language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());

			count += this.dao.update("updateBasReferenceTables", map);
		}

		return count;
	}

	@Override
	public Object getBasReferenceTablesList(Map<String, Object> params, int page, int pageRows) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);

		result.put("data", this.dao.query("searchBasReferenceTablesList", params));

		return result;
	}

	@Override
	public Object getBasReferenceTablesDetail(Map<String, Object> params) throws Exception {
		if (StringUtils.isEmpty(params.get("reference_table_no")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("reference_table_no and language  cannot be null!");
		}

		return this.dao.query("searchBasReferenceTablesDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getTotalRows", params).get(0);

		return result.get("totalRows");
	}

}
