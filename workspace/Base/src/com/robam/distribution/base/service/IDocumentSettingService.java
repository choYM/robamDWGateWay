package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * 单据别设定
 * @author liaogz
 * @since2017-2-17
 *drp_sys_m01
 */
public interface IDocumentSettingService extends DWService{
	/**
	 * 分页查询
	 * @param param查询条件
	 * @param startPage页码
	 * @param pageSize每页多少数据
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getDocumentSettingList(Map<String, Object> param,int startPage, int pageSize) throws Exception;

	/**
	 * 修改单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> modifyDocumentSetting(Map<String, Object> param) throws Exception;
	
	/**
	 * 批量删除单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> deleteDocumentSetting(List<Map<String, Object>> param) throws Exception;
	
	/**
	 * 批量审核单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> auditDocumentSetting(List<Map<String, Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增单据别设置
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> addDocumentSetting(Map<String, Object> param) throws Exception;
	
	/**
	 * 判断单据别设置是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> judgeDocumentSetting(Map<String, Object> param) throws Exception;
	
	/**
	 * 获取单据别设置信息
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getDocumentSettingByDoc(Map<String, Object> param) throws Exception;
	
}
