package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IFrequentService;

public class FrequentServiceImp implements IFrequentService {

	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}

	/**
	 * 儲存常用查詢
	 */
	@Override
	public Object addSearchCondition(List<Map<String, Object>> params, String program_code) throws Exception {
		int count = 0;
		// 先將DB中條件刪除
		// 因為沒有登入服務，UserId 先寫死
		Map delMap = new HashMap<String, Object>();
		delMap.put("program_code", program_code);
		delMap.put("user_code", "user001");
		delMap.put("language", "zh_CN");
		this.dao.delete("deleteSearchCondition", delMap);

		for (Map<String, Object> map : params) {

			map.put("language", "zh_CN");
			map.put("program_code", program_code);
			map.put("user_code", "user001");
			if (StringUtils.isEmpty(map.get("user_code"))||StringUtils.isEmpty(map.get("search_order")) || StringUtils.isEmpty(map.get("language")) || StringUtils.isEmpty(map.get("program_code"))) {
				throw new Exception("user_code , program_code , search_order and language cannot be null!");
			}
			map.put("data_created_date", new Date());
			map.put("status_code", "Y");

			count += this.dao.insert("addSearchCondition", map);
		}

		return count;
	}

	/**
	 * 常用查詢
	 */
	@Override
	public Object getSearchCondition(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		params.put("user_code", "user001");
		Map<String, Object> result = new HashMap<>();
		result.put("data", this.dao.query("getSearchCondition", params));

		return result;
	}

}
