package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m08 城市资料维护作业
 * @author yangjian
 * @since 2017-02-14
 **/
public interface ICityService extends DWService{
	/**
	 * 根据预设条件查询城市列表（分页）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getCityList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	
	/**
	 * 修改城市资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object modifyCity(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除城市资料档
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteCity(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核城市资料档
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object auditCity(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增城市资料档
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object addCity(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断城市资料是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeCity(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查询城市资料
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getCity(Map<String,Object> param) throws Exception;
	
}
