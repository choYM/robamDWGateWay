package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m36-应用分类对照表维护作业
 * @author liaogz
 * @since 2017-02-20
 *
 */
public interface IAccContrastService extends DWService{
	/**
	 * 根据预设条件查询应用分类对照表列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAccContrastList(Map<String, Object> param,int startPage,int pageSize) throws Exception;

	/**
	 * 修改应用分类对照表(包含审核应用分类对照表)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> modifyAccContrast(List<Map<String, Object>> param) throws Exception;
	
	/**
	 * 删除应用分类对照表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deleteAccContrast(List<Map<String, Object>> param) throws Exception;
	
	/**
	 * 新增应用分类对照表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addAccContrast(Map<String, Object> param) throws Exception;
	
	/**
	 * 根据应用分类对照表获取相关记录(判断应用分类对照表是否存在)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getAccContrast(Map<String, Object> param) throws Exception;
	
}
