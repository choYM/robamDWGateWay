package com.robam.distribution.base.service;

import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m14 组织层级查询维护作业
 * @author gejc
 * @since 2017-02-14
 */
public interface IOrganizationHierarchyQueryService extends DWService {
	@AllowAnonymous
	public Object getOrganizationHierarchyList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	@AllowAnonymous
	public Object getOrganizationHierarchyDetail(Map<String,Object> param) throws Exception;
	
	@AllowAnonymous
	Object getOrganizationHierarchy(String top_org_code) throws Exception;
}
