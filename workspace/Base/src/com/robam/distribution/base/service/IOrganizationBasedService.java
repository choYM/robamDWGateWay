package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
import com.robam.distribution.base.model.BasOrganization;

/**
 * drp_bas_m12 组织基础资料维护作业
 * @author YangJian
 * @since 2017-02-14
 *
 */
public interface IOrganizationBasedService extends DWService{
	
	/**
	 * 获取组织基础详细资料
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@AllowAnonymous
	public Object getOrganizationBasedDetail(Map<String,Object> param) throws Exception;
	
	/**
	 * 修改组织基础资料
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@AllowAnonymous
	public Object modifyOrganizationBasedDetail(Map<String,Object> param) throws Exception;
	
	/**
	 * 新增通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@AllowAnonymous
	public Object addOrganizationBasedContact(BasOrganization param) throws Exception;
	
	/**
	 * 修改通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@AllowAnonymous
	public Object modifyOrganizationBasedContact(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 * @author YangJian
	 */
	@AllowAnonymous
	public Object deleteOrganizationBasedContact(Map<String,Object> param) throws Exception;
	
	/**
	 * 分页查询组织基础资料
	 * @param param查询条件 
	 * @param startPage开始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Map<String, Object> getOrganizationBasedList(Map<String, Object> param,int startPage,int pageSize) throws Exception;
	
	/**
	 * 新增组织
	 * @param param  
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Map<String, Object> addOrganization(BasOrganization param) throws Exception;
	
	/**
	 * 删除组织
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Map<String, Object> deleteOrganization(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核组织
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@AllowAnonymous
	public Map<String, Object> auditOrganization(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 获取其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@AllowAnonymous
	public Object getOrganizationAddress(Map<String,Object> param) throws Exception;
	
	/**
	 * 修改其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@AllowAnonymous
	public Object modifyOrganizationAddress(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@AllowAnonymous
	public Object deleteOrganizationAddress(Map<String,Object> param) throws Exception;
	
	/**
	 * 新增其他地址服务
	 * @param param
	 * @return 
	 * @throws Exception
	 * @author gejc
	 */
	@AllowAnonymous
	public Object addOrganizationAddress(Map<String,Object> param) throws Exception;
}
