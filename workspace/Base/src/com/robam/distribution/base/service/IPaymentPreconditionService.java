package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_f09 缴款优惠折扣维护作业
 * @author liaogz
 * @since 2017-02-14
 *
 */
public interface IPaymentPreconditionService extends DWService{
	
	
	/**
	 * 根据预设条件查询缴款优惠条件维护列表（分页）
	 * @param param查询条件 
	 * @param startPage开始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getPaymentPreconditionList(Map<String, Object> param,int startPage,int pageSize) throws Exception;

	/**
	 * 修改缴款优惠条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> modifyPaymentPrecondition(Map<String, Object> param) throws Exception;
	
	/**
	 * 删除缴款优惠条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deletePaymentPrecondition(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核缴款优惠条件
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> auditPaymentPrecondition(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增缴款优惠条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addPaymentPrecondition(Map<String, Object> param) throws Exception;
	
	/**
	 * 判断缴款优惠条件是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> judgePaymentPrecondition(Map<String, Object> param) throws Exception;
	
	/**
	 * 主键查询缴款优惠条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getPaymentPrecondition(Map<String, Object> param) throws Exception;
}
