package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
import com.robam.distribution.base.model.BasOrganizationHierarchy;

/**
 * drp_bas_m13 组织层级关系维护作业
 * @author YangJian
 * @since 2017-02-14
 */
public interface IOrganizationHierarchyService extends DWService{
	/**
	 * 根据预设条件查询组织层级列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object getOrganizationHierarchyList(Integer startPage,Integer pageSize,Map<String,Object> param) throws Exception;
	
	/**
	 * 获取组织层级详细资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object getOrganizationHierarchyDetail(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据组织类型获取基础组织列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object getOrganizationBase(Map<String,Object> param) throws Exception;
	
	/**
	 * 获取最上层组织
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object getTopOrganization(Map<String,Object> param) throws Exception;
	
	/**
	 * 修改组织层级
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object modifyOrganizationHierarchy(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除组织层级
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object deleteOrganizationHierarchy(List<BasOrganizationHierarchy> param) throws Exception;
	
	/**
	 * 审核组织层级
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object auditOrganizationHierarchy(List<BasOrganizationHierarchy> param,String status_code) throws Exception;
	
	/**
	 * 新增组织层级
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Object addOrganizationHierarchy(Map<String,Object> param) throws Exception;
}
