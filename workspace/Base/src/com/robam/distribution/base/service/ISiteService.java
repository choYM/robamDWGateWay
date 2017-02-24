package com.robam.distribution.base.service;
import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
import com.robam.distribution.base.model.Address;
import com.robam.distribution.base.model.StoresDataAccess;

/**
 * drp_org_a01 门店申请资料维护作业
 * @author nj
 * @since 2017-02-14
 **/
public interface ISiteService extends DWService{
	/**
	 * 分頁查詢
	 * @param pageNumber 查詢的頁次
	 * @param storesdataaccess 传过来的查询条件
	 * @return 分頁查詢結果
	 * @throws Exception 異常
	 */
	public Object getSiteList(int startPage,int pageSize,Map<String,Object> param) throws Exception;

	/**
	 * 
	 * @param storesdataaccess 前端传进来的要添加的门店数据对象
	 * @return
	 * @throws Exception
	 */
	public Object addSite(StoresDataAccess param) throws Exception;
	
	/**
	 * 删除门店信息
	 */
	public Object deleteSite(List<Map<String,Object>> param) throws Exception;
	/**
	 * 审核门店
	 */
	public  Object auditSite(List<Map<String,Object>> param) throws Exception;
	//金驰
	/***
	 * 
	 * @param address
	 * @return 
	 * @throws Exception
	 */
	public Object addAddress(Address address) throws Exception;
	public Object getAddress(Address address) throws Exception;
	public Object modifyAddress(Address address) throws Exception;
	public Object deleteAddress(Address address) throws Exception;
	//杨建
	/**
	 * 说明 : 查询门店基础资料
	 * 		根据申请单号查询详情
	 * 服务名 : getBaseSiteInfo
	 * @Param REQUEST_NO
	 */
	public Object getBaseSiteInfo(StoresDataAccess param) throws Exception;
	
	/**
	 * 说明 : 修改门店基础资料
	 * 服务名 : updateBaseSiteInfo
	 * @Param : StoresDataAccess
	 */
	public Object modifyBaseSiteInfo(StoresDataAccess param) throws Exception;
	
	/**
	 * 说明 : 修改门店其他资料，暫時去除此方法
	 * 服务名 : updateOtherInformation
	 * @param : StoresDataAccess
	 */
	public Object modifyOtherInformation(StoresDataAccess param) throws Exception;
	
	/**
	 * 说明 : 修改门店其他属性
	 * 服务名 : updateOtherAttribute
	 * @param : StoresDataAccess
	 */
	public Object modifyOtherAttribute(StoresDataAccess param) throws Exception;
	
	/**
	 * 说明 : 新增通讯方式
	 * 服务名 : addContact
	 * @param : StoresDataAccess
	 */
	public Object addContact(StoresDataAccess param) throws Exception;
	
	/**
	 * 说明 : 修改通讯方式
	 * 服务名 : updateContact
	 * @param : StoresDataAccess
	 */
	public Object modifyContact(StoresDataAccess param) throws Exception;
	
	/**
	 * 说明：删除通讯方式
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteContact(StoresDataAccess param) throws Exception;
}
