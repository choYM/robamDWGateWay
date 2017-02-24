package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_f10 款别依据点设置服务规格
 * @author YangJian
 * @since 2017-02-14
 *
 */
public interface ISitePaymentTypeService extends DWService{
	
	/**
	 * 根据预设条件查询缴款优惠条件维护列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public Object getSitePaymentTypeList(Map<String,Object> param,Integer startPage,Integer pageSize) throws Exception;
	
	/**
	 * 修改款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object modifySitePaymentType(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteSitePaymentType(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object auditSitePaymentType(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增款别依据点设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object addSitePaymentType(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断款别依据点设置是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeSitePaymentType(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查找款别依据点
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getSitePaymentType(Map<String,Object> param) throws Exception;
	
}
