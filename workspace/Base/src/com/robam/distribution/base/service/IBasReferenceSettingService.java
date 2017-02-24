package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;


/**
 * 參照表維護作業-介面
 * 
 * @author Enoch
 * @since 2017-01-20
 */
public interface IBasReferenceSettingService extends DWService{
	
	
	/**
	 * insert data
	 * 
	 * @param param insert bean map
	 * @return
	 * @throws Exception
	 */
	public Object addBasReferenceTables(Map<String, Object> params) throws Exception;

	/**
	 * delete data
	 * 
	 * @param param delete bean map
	 * @return
	 * @throws Exception
	 */
	public Object deleteBasReferenceTables(List<Map<String, Object>> params) throws Exception;

	/**
	 * update data
	 * 
	 * @param params update bean map
	 * @return
	 * @throws Exception
	 */
	public Object modifyBasReferenceTables(List<Map<String, Object>> params) throws Exception;

	/**
	 * search data with page & pageRows
	 * 
	 * @param params condition map
	 * @param page page
	 * @param pageRows data counts of each row
	 * @return
	 * @throws Exception
	 */
	public Object getBasReferenceTablesList(Map<String, Object> params, int page, int pageRows) throws Exception;

	/**
	 * search 1 data by pk
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Object getBasReferenceTablesDetail(Map<String, Object> params) throws Exception;

}
