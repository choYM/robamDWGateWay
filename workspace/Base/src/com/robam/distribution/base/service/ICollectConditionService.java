package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m30 收款条件维护服务
 * @author yangjian
 * @since 2017-02-14
 **/
public interface ICollectConditionService extends DWService{
	
	/**
	 * 根据预设条件查询收款条件列表（分页）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getCollectConditionList(int startPage, int pageSize, Map<String,Object> param) throws Exception;
	
	/**
	 * 修改收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object modifyCollectCondition(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object deleteCollectCondition(List<Map<String,Object>> param) throws Exception;

	/**
	 * 审核收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object auditCollectCondition(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object addCollectCondition(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断收款条件是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeCollectCondition(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查指定数据
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getCollectCondition(Map<String,Object> param) throws Exception;
}
