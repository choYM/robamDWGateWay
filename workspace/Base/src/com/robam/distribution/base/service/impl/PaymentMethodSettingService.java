package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IPaymentMethodSettingService;

/**
 * drp_bas_f04-付款方式維護
 * 
 * @author choYM
 * @since 2017-01-23
 */
public class PaymentMethodSettingService implements IPaymentMethodSettingService {
	@Autowired
	public Dao dao;

	public Dao getDao() {
		return dao;
	}
	
	@Override
	@Transactional
	public Object addBasPaymentMethod(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		
		if (StringUtils.isEmpty(params.get("acc_code")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("acc_code and language cannot be null!");
		}

		// set create day & default valid value (true)
		params.put("data_created_date", new Date());
		params.put("status_code", "Y");
		params.put("acc", "basf04a");

		return dao.insert("addBasPaymentMethod", params);
	}

	@Override
	@Transactional
	public Object deleteBasPaymentMethod(List<Map<String, Object>> params) throws Exception {
		if (params == null || params.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}

		int count = 0;
		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			count += dao.delete("deleteBasPaymentMethod", map);
		}

		return count;
	}

	@Override
	@Transactional
	public Object modifyBasPaymentMethod(List<Map<String, Object>> params) throws Exception {
		int count = 0;

		for (Map<String, Object> map : params) {
			map.put("language", "zh_CN");
			
			if (StringUtils.isEmpty(map.get("acc_code")) || StringUtils.isEmpty(map.get("language"))) {
				throw new Exception("acc_code and language cannot be null!");
			}

			// set update date
			map.put("last_modified_date", new Date());

			count += this.dao.update("updateBasPaymentMethod", map);
		}

		return count;
	}
	
	@Override
	public Object getBasPaymentMethodList(Map<String, Object> params, int page, int pageRows) throws Exception {
		params.put("acc", "basf04a");
		
		Map<String, Object> result = new HashMap<>();
		result.put("page", page);
		result.put("pageRows", pageRows);
		result.put("totalRows", this.getTotalRows(params));

		// calculate data start index & page rows
		params.put("start", pageRows * (page - 1));
		params.put("pageRows", pageRows);
		
		result.put("data", this.dao.query("searchBasPaymentMethodList", params));

		return result;
	}

	@Override
	public Object getBasPaymentMethodDetail(Map<String, Object> params) throws Exception {
		params.put("language", "zh_CN");
		params.put("acc", "basf04a");
		if (StringUtils.isEmpty(params.get("acc_code")) || StringUtils.isEmpty(params.get("language"))) {
			throw new Exception("acc_code and language cannot be null!");
		}

		return this.dao.query("searchBasPaymentMethodDetail", params);
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
		Map<String, Object> result = (Map<String, Object>) this.dao.query("getBasPaymentMethodTotalRows", params).get(0);

		return result.get("totalRows");
	}
}
