package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_s05 门店类别维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 
public interface ISiteCategoryService extends DWService{
	/**
	 * 
	 * @param param查询条件对象
	 * @param startPage起始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getSiteCategoryList(Map<String, Object> param,int startPage,int pageSize) throws Exception;
	
	/**
	 * 
	 * @param param需要修改的内容
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> modifySiteCategory(Map<String,Object> param) throws Exception;
	/**
	 * 
	 * @param param前端传的对象数组
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deleteSiteCategory(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 
	 * @param param前端传的要审核的关于主键的对象数组
	 * @param status_code状态码
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> auditSiteCategory(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 
	 * @param param要新增的资料对象
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addSiteCategory(Map<String,Object> param) throws Exception;

}
