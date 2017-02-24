package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m28 单一税别设置作业规格
 * @author YangJian
 * @since 2017-02-14
 *
 */
public interface ISingleTaxService extends DWService{

	/**
	 * 根据预设条件查询单一税别列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public Object getSingleTaxList(Map<String,Object> param,Integer startPage,Integer pageSize) throws Exception;
	
	/**
	 * 修改单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object modifySingleTax(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteSingleTax(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核单一税别
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	public Object auditSingleTax(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object addSingleTax(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断单一税别是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeSingleTax(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查询单一税别
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getSingleTax(Map<String,Object> param) throws Exception;
	
}
