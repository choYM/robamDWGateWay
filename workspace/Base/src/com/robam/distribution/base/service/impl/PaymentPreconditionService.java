package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IPaymentPreconditionService;

/**
 * drp_bas_f09 缴款优惠折扣维护作业
 * @author liaogz
 * @since 2017-02-14
 *
 */
 
public class PaymentPreconditionService implements IPaymentPreconditionService{
	@Autowired
	private Dao dao;

	/**
	 * 根据预设条件查询缴款优惠条件维护列表（分页）
	 * @param param查询条件 
	 * @param startPage开始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> getPaymentPreconditionList(Map<String, Object> param, int startPage, int pageSize)
			throws Exception {
		param.put("language", "zh_CN");
		Object data = this.dao.executePagination("dao.BaseBasPaymentPreconditionSettingMapper.selectPaymentPreconditionCount", "dao.BaseBasPaymentPreconditionSettingMapper.selectPaymentPreconditionLimit", param, startPage, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("successValue", true);
		map.put("description", "");
		map.put("data", data);
		return map;
	}

	/**
	 * 修改缴款优惠条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> modifyPaymentPrecondition(Map<String, Object> param) throws Exception {
		if (param.get("advance_days1") == null || "".equals(param.get("advance_days1"))) {
			param.put("advance_days1", "0");
		}
		if (param.get("discount_rate1") == null || "".equals(param.get("discount_rate1"))) {
			param.put("discount_rate1", "0.0");
		}
		if (param.get("advance_days2") == null || "".equals(param.get("advance_days2"))) {
			param.put("advance_days2", "0");
		}
		if (param.get("discount_rate2") == null || "".equals(param.get("discount_rate2"))) {
			param.put("discount_rate2", "0.0");
		}
		if (param.get("advance_days3") == null || "".equals(param.get("advance_days3"))) {
			param.put("advance_days3", "0");
		}
		if (param.get("discount_rate3") == null || "".equals(param.get("discount_rate3"))) {
			param.put("discount_rate3", "0.0");
		}
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("favorable_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("favorable_term and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		int count = this.dao.update("dao.BaseBasPaymentPreconditionSettingMapper.modifyPaymentPrecondition", param);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("successValue", true);
			map.put("description", "修改资料成功");
		}else {
			map.put("successValue", false);
			map.put("description", "修改资料失败");
		}
		return map;
	}

	/**
	 * 删除缴款优惠条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> deletePaymentPrecondition(List<Map<String, Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		int count = 0;
		for (Map<String, Object> map : param) {
			     map.put("language", "zh_CN");
			if (map.get("favorable_term")==null || map.get("favorable_term")==""
				|| map.get("language")==null || map.get("language")=="") 
			{
				throw new Exception("favorable_term and language cannot be null!");
			} else {
				count += dao.delete("dao.BaseBasPaymentPreconditionSettingMapper.deletePaymentPrecondition", map);
			}
		}
		Map<String, Object> profile = new HashMap<String, Object>();
		if (count > 0) {
			profile.put("successValue", true);
			profile.put("description", "删除成功");
		} else {
			profile.put("successValue", false);
			profile.put("description", "删除失败");
		}
		return profile;
	}

	/**
	 * 审核缴款优惠条件
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> auditPaymentPrecondition(List<Map<String, Object>> param, String status_code)
			throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
        }
		Map<String, Object> result = new HashMap<String, Object>();
		if (!status_code.isEmpty()) {
			int count = 0;
			for (Map<String, Object> map : param) {
				map.put("language", "zh_CN");
				if (map.get("favorable_term")==null || map.get("favorable_term")==""
						|| map.get("language")==null || map.get("language")=="") 
				{
					throw new Exception("favorable_term and language cannot be null!");
				} else {
					Map<String,Object> information=DWServiceContext.getContext().getProfile();
					Object userId = information.get("UserId");
					map.put("last_modified_date", new Date());
					map.put("data_modified_by",userId);
					map.put("status_code", status_code);
					count += dao.update("dao.BaseBasPaymentPreconditionSettingMapper.auditPaymentPrecondition",map);
				}
			}
			if (count > 0) {
				result.put("successValue", true);
				result.put("description", "审核成功");
			} else {
				result.put("successValue", false);
				result.put("description", "审核失败");
			}
		}else {
			throw new Exception("status_code cannot be null!");
		}
		return result;
	}

	/**
	 * 新增缴款优惠条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> addPaymentPrecondition(Map<String, Object> param) throws Exception {
		if (param.get("advance_days1") == null || "".equals(param.get("advance_days1"))) {
			param.put("advance_days1", "0");
		}
		if (param.get("discount_rate1") == null || "".equals(param.get("discount_rate1"))) {
			param.put("discount_rate1", "0.0");
		}
		if (param.get("advance_days2") == null || "".equals(param.get("advance_days2"))) {
			param.put("advance_days2", "0");
		}
		if (param.get("discount_rate2") == null || "".equals(param.get("discount_rate2"))) {
			param.put("discount_rate2", "0.0");
		}
		if (param.get("advance_days3") == null || "".equals(param.get("advance_days3"))) {
			param.put("advance_days3", "0");
		}
		if (param.get("discount_rate3") == null || "".equals(param.get("discount_rate3"))) {
			param.put("discount_rate3", "0.0");
		}
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("favorable_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("favorable_term and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasPaymentPreconditionSettingMapper.judgePaymentPrecondition", param);
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.size() > 0 && data.get(0) > 0){
			result.put("successValue", false);
			result.put("description", "存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			Date date = new Date();
			param.put("last_modified_date", date);
			param.put("data_created_date",date);
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			Object deptId = information.get("DeptId");
			param.put("data_owner",userId);
			param.put("data_owned_department",deptId);
			param.put("data_created_by",userId);
			param.put("data_created_department",deptId);
			param.put("data_modified_by",userId);
			this.dao.insert("dao.BaseBasPaymentPreconditionSettingMapper.addPaymentPrecondition", param);
			result.put("successValue", true);
			result.put("description", "数据插入成功");
		}
		return result;
	}

	@Override
	public Map<String, Object> judgePaymentPrecondition(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("favorable_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("favorable_term and language cannot be null!");
		}
		List<Integer> data = this.dao.query("dao.BaseBasPaymentPreconditionSettingMapper.judgePaymentPrecondition", param);
		Map<String,Object> result = new HashMap<String,Object>();
		if(data.size() > 0 && data.get(0) > 0){
			result.put("successValue", true);
			result.put("description", "存在此笔记录");
		}else if(data.size() > 0 && data.get(0) == 0){
			result.put("successValue", false);
			result.put("description", "不存在此笔记录");
		}
		return result;
	}
	
	@Override
	public Map<String, Object> getPaymentPrecondition(Map<String, Object> param)
			throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("favorable_term")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("favorable_term and language cannot be null!");
		}
		List<Map<String,Object>> data = this.dao.query("dao.BaseBasPaymentPreconditionSettingMapper.getPaymentPreconditionOne", param);
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("successValue", data!=null);
		result.put("description", "查询数据"+data!=null?"成功":"失败");
		result.put("data", data!=null?data.get(0):null);
		return result;
	}
}
