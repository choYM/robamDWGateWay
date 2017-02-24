package com.robam.distribution.EAI.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.dao.Dao;
import com.robam.distribution.EAI.service.IBasOrganizationService;

public class BasOrganizationService implements IBasOrganizationService {

	@Autowired
	private Dao dao;

	@Override
	public Map<String, Object> getOrganization() throws Exception {
		Map<String, Object> response = new HashMap<>();
		try {
			List<HashMap<String, Object>> result = this.dao.query("test.selectCount", null);
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new HashMap<>();
			int i = 0;
			while (!result.isEmpty() && i < result.size()) {
				Map<String, Object> returnResult = result.get(i);
				map.put("ooefent", "8080");
				map.put("ooef001", "test");
				map.put("STATUS_CODE", (String) returnResult.get("STATUS_CODE"));
				map.put("BUSINESS_REGISTRATION_NO", (String) returnResult.get("BUSINESS_REGISTRATION_NO"));
				map.put("COUNTRY_REGION", (String) returnResult.get("COUNTRY_REGION"));
				map.put("LISTED_COMPANY_NO", (String) returnResult.get("LISTED_COMPANY_NO"));
				map.put("EXCLUSIVE_NATIONAL_FUNCTIONS", (String) returnResult.get("EXCLUSIVE_NATIONAL_FUNCTIONS"));
				map.put("DATE_DISPLAY_FORMAT", (String) returnResult.get("DATE_DISPLAY_FORMAT"));
				map.put("MAIN_CURRENCY_NO", (String) returnResult.get("MAIN_CURRENCY_NO"));
				map.put("TIME_ZONE_NO", (String) returnResult.get("TIME_ZONE_NO"));
				map.put("REGISTER_CAPITAL", (String) returnResult.get("REGISTER_CAPITAL"));
				map.put("CUSTOMER_VENDOR_NO", (String) returnResult.get("CUSTOMER_VENDOR_NO"));
				map.put("INDUSTRY_TYPE", (String) returnResult.get("INDUSTRY_TYPE"));
				map.put("OPENING_DATE", (String) returnResult.get("OPENING_DATE"));
				map.put("STORE_AREA", (BigDecimal) returnResult.get("STORE_AREA"));
				map.put("SALES_AREA", (String) returnResult.get("SALES_AREA"));
				map.put("LANGUAGE", (String) returnResult.get("LANGUAGE"));
				i++;
				list.add(map);
			}
			
			if (list.size() > 0) {
				response = response("0", "", "");
				response.put("parameter", list);
			} else {
				response = response("-1", "", "DB 無資料");
			}
		} catch (Exception e) {
			response = response("-1", "", e.toString());
		}
		System.out.println(response.toString());
		return response;

	}

	public Map<String, Object> response(String code, String sqlCode, String description) {
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> std_data = new HashMap<>();
		Map<String, Object> execution = new HashMap<>();
		execution.put("code", code);
		execution.put("sqlcode", sqlCode);
		execution.put("description", description);
		std_data.put("execution", execution);
		response.put("srvver", "1.0");
		response.put("srvcode", "000");
		response.put("payload", std_data);
		return response;

	}

}
