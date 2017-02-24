package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_s01 商品-价格带维护作业
 * @author gejc
 * @since 2017-02-14
 * 
 **/ 
public interface IPriceZoneService extends DWService {
	public Object getPriceZoneList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifyPriceZone(Map<String,Object> param) throws Exception;
	public Object deletePriceZone(List<Map<String,Object>> param) throws Exception;
	public Object auditPriceZone(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addPriceZone(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断商品价格带是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgePriceZone(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查询商品价格带
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object getPriceZone(Map<String,Object> param) throws Exception;
}
