package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_s04 商品-属性维护作业
 * drp_bas_s06 门店属性维护作业
 * @author liaogz
 * @since 2017-02-14
 **/ 
public interface IOtherAttributeService extends DWService{
	/**
	 * 
	 * @param param查询条件对象
	 * @param startPage起始页码
	 * @param pageSize每页多少笔数据
	 * @return
	 * @throws Exception
	 */
	
	public Object getOtherAttributeList(Map<String, Object> param,int startPage,int pageSize) throws Exception;
	
	/**
	 * 
	 * @param param需要修改的内容
	 * @return
	 * @throws Exception
	 */
	
	public Object modifyOtherAttribute(Map<String,Object> param) throws Exception;
	/**
	 * 
	 * @param param前端传的对象数组
	 * @return
	 * @throws Exception
	 */
	
	public Object deleteOtherAttribute(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 
	 * @param param前端传的要审核的关于主键的对象数组
	 * @param status_code状态码
	 * @return
	 * @throws Exception
	 */
	
	public Object auditOtherAttribute(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 
	 * @param param要新增的资料对象
	 * @return
	 * @throws Exception
	 */
	
	public Object addOtherAttribute(Map<String,Object> param) throws Exception;

	/**
	 * 判断主键是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	
	public Object judgeOtherAttribute(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查询商品其他属性
	 * @param param
	 * @return
	 * @throws Exception
	 */
	
	public Object getOtherAttribute(Map<String,Object> param) throws Exception;
}
