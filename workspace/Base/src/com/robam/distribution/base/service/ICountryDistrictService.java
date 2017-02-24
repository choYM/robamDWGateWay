package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m09 县区资料服务
 * @author xiongjh
 * @since 2017-02-14
 */
public interface ICountryDistrictService extends DWService{
	/**
	 * 分頁查詢
	 * @param pageNumber 查詢的頁次
	 * @param  BasCountryDistrict传过来的查询条件
	 * @return 分頁查詢結果
	 * @throws Exception 異常
	 */
	public Object getCountryDistrictList(Map<String,Object> param,int startPage,int pageSize) throws Exception;

	/**
	 * 修改县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object modifyCountryDistrict(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteCountryDistrict(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核县区资料
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	public Object auditCountryDistrict(List<Map<String,Object>> param, String status_code) throws Exception;
	
	/**
	 * 新增县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object addCountryDistrict(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断县区资料是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeCountryDistrict(Map<String, Object> param) throws Exception;
	
	/**
	 * 根据主键查询县区资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getCountryDistrict(Map<String, Object> param) throws Exception;

}
