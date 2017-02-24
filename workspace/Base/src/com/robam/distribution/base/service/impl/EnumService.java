package com.robam.distribution.base.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IEnumService;

/**
 * base_enum-枚舉服務
 * 
 * @author Enoch	
 * @since 2017-02-17
 */

public class EnumService implements IEnumService{

	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}
	/**
	 * 枚舉服務
	 */
	@Override
	public Object getEnumList(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		Map<String, Object> result = new HashMap<>();
		result.put("data", this.dao.query("getEnumList", params));

		return result;
		
		
	}

	

}
