package com.robam.distribution.base.service;
import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m07 省别资料维护作业
 * @author gejc
 * @since 2017-02-14
 **/ 
public interface IProvinceService extends DWService {
	public Object getProvinceList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifyProvince(Map<String,Object> param) throws Exception;
	public Object deleteProvince(List<Map<String,Object>> param) throws Exception;
	public Object auditProvince(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addProvince(Map<String,Object> param) throws Exception;
	public Object judgeProvince(Map<String,Object> param) throws Exception;
	public Object getProvince(Map<String,Object> param) throws Exception;
}
