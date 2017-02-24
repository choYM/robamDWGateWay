package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m23 自动编码设置维护作业规格
 * @author YangJian
 * @date 2017-02-21
 */
public interface IAutoNumberingService extends DWService {

	/**
	 * 根据预设条件查询自动编码设置列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public abstract Object getAutoNumberingList(Map<String,Object> param,Integer startPage,Integer pageSize) throws Exception;
	
	/**
	 * 修改自动编码设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object modifyAutoNumbering(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除自动编码设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object deleteAutoNumbering(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核自动编码设置
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	public abstract Object auditAutoNumbering(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增自动编码设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object addAutoNumbering(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键获取记录（判断自动编码设置是否存在）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object getAutoNumbering(Map<String,Object> param) throws Exception;
	
}
