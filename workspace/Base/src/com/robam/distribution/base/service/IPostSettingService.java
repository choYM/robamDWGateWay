package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m11-郵政資料維護
 * 
 * @author choYM
 * @since 2017-01-18
 */
public interface IPostSettingService extends DWService {
	/**
	 * insert a record
	 * @param params insert bean map
	 * @return
	 * @throws Exception
	 */
	public Object addBasPostcode(Map<String, Object> params) throws Exception;
	
	/**
	 * delete data
	 * @param params delete bean map
	 * @return
	 * @throws Exception
	 */
	public Object deleteBasPostcode(List<Map<String,Object>> params) throws Exception;
	
	/**
	 * update data
	 * @param params update bean map
	 * @return
	 * @throws Exception
	 */
	public Object modifyBasPostcode(List<Map<String,Object>> params) throws Exception;
	
	/**
	 * search data on requested page with specified page rows
	 * @param params where conditions
	 * @param page request page
	 * @param pageRows data rows in one page
	 * @return
	 * @throws Exception
	 */
	public Object getBasPostcodeList(Map<String, Object> params, int page, int pageRows) throws Exception;
	
	/**
	 * search 1 record by pk
	 * @param params pk
	 * @return
	 * @throws Exception
	 */
	public Object getBasPostcodeDetail(Map<String, Object> params) throws Exception;
}
