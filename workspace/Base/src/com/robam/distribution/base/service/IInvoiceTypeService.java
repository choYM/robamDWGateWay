package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_f12 发票类型维护作业
 * @author yangjian
 * @since 2017-02-14
 *
 */
public interface IInvoiceTypeService extends DWService{
	
	/**
	 * 根据预设条件查询发票类型列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public Object getInvoiceTypeList(Map<String,Object> param,Integer startPage,Integer pageSize) throws Exception;
	
	/**
	 * 修改发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object modifyInvoiceType(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteInvoiceType(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object auditInvoiceType(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object addInvoiceType(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断发票类型是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeInvoiceType(Map<String, Object> param) throws Exception;
	
	/**
	 * 根据主键获取指定发票类型
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getInvoiceType(Map<String, Object> param) throws Exception;
}
