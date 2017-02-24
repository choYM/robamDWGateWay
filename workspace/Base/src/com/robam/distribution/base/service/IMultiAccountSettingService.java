package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_f11-多账期设定档
 * 
 * @author Enoch
 * @since 2017-02-15
 */
public interface IMultiAccountSettingService extends DWService{
	
	
	/**
	 * insert a record
	 * @param params insert bean map
	 * @return
	 * @throws Exception
	 */
	public Object addMultiAccount(List<Map<String, Object>> params) throws Exception;

	/**
	 * update data
	 * @param params update bean map
	 * @return
	 * @throws Exception
	 */
	public Object modifyMultiAccount(List<Map<String, Object>> params) throws Exception;
	
	/**
	 * delete data
	 * @param params delete bean map
	 * @return
	 * @throws Exception
	 */
	public Object deleteMultiAccount(List<Map<String, Object>> params) throws Exception;

	/**
	 * search data on requested page with specified page rows
	 * @param params where conditions
	 * @param page request page
	 * @param pageRows data rows in one page
	 */
	public Object getMultiAccountList(Map<String, Object> params, int page, int pageRows) throws Exception;
	
	/**
	 * search 1 record by pk
	 * @param params pk
	 * @return
	 * @throws Exception
	 */
	public Object getMultiAccountDetail(Map<String, Object> params) throws Exception;

}
