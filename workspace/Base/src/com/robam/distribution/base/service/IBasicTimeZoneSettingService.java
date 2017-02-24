package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * 時區設定作業-介面
 * 
 * @author choYM
 * @since 2017-01-11
 */
public interface IBasicTimeZoneSettingService extends DWService {
	/**
	 * insert data
	 * 
	 * @param param insert bean map
	 * @return
	 * @throws Exception
	 */
	public Object addBasicTimeZone(Map<String, Object> params) throws Exception;

	/**
	 * delete data
	 * 
	 * @param param delete bean map
	 * @return
	 * @throws Exception
	 */
	public Object deleteBasicTimeZone(List<String> params) throws Exception;

	/**
	 * update data
	 * 
	 * @param params update bean map
	 * @return
	 * @throws Exception
	 */
	public Object modifyBasicTimeZone(List<Map<String, Object>> params) throws Exception;

	/**
	 * search data with page & pageRows
	 * 
	 * @param params condition map
	 * @param page page
	 * @param pageRows data counts of each row
	 * @return
	 * @throws Exception
	 */
	public Object getBasicTimeZoneList(Map<String, Object> params, int page, int pageRows) throws Exception;

	/**
	 * search 1 data by pk
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Object getBasicTimeZoneDetail(Map<String, Object> params) throws Exception;
}
