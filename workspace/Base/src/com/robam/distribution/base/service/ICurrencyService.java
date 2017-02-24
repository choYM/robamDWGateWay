package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m15 币种资料服务
 * @author gelf
 * @since 2017-02-14
 *
 */
public interface ICurrencyService extends DWService{
	/**
	 * 根据预设条件查询币种列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 */
	Object getCurrencyList(Map<String,Object> param,int startPage,int pageSize) throws Exception;
	
	/**
	 * 修改币种详细资料
	 * @param param
	 * @return
	 */
	Object modifyBaseCurrencyInfo(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除币种资料
	 * @param param
	 * @return
	 */
	Object deleteBaseCurrencyInfo(List<String> param) throws Exception;
	
	/**
	 * 审核币种资料
	 * @param param
	 * @return
	 */
	Object auditCurrency(List<String> param,String status_code) throws Exception;
	
	
	/**
	 * 判断币种是否存在记录
	 * @param param
	 * @return
	 */
	Object judgeCurrency(Map<String,Object> param) throws Exception;
	
	/**
	 * 新增币种资料
	 * @param param
	 * @return
	 */
	Object addCurrency(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取主币种
	 * @return
	 */
	Object getCoinsKind() throws Exception;
	
	/**
	 * 根据主键查询币种资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	Object getCurrency(Map<String,Object> param) throws Exception;
	
}
