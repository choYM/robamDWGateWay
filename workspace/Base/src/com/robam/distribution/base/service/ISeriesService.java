package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_s03 商品-系列维护作业
 * @author gejc
 * @since 2017-02-14
 **/ 
public interface ISeriesService extends DWService {
	public Object getSeriesList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifySeries(Map<String,Object> param) throws Exception;
	public Object deleteSeries(List<Map<String,Object>> param) throws Exception;
	public Object auditSeries(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addSeries(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断商品系列是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Object judgeSeries(Map<String,Object> param) throws Exception;
	
	public Object getSeries(Map<String,Object> param) throws Exception;
}
