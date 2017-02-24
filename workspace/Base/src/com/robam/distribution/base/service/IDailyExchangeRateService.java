package com.robam.distribution.base.service;
import java.util.List;
import java.util.Map;
import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m17 日汇率维护作业
 * @author gejc
 * @since 2017-02-16
 **/ 
public interface IDailyExchangeRateService extends DWService {
	public Object getDailyExchangeRateList(Map<String,Object> param,int startPage,int pageSize) throws Exception;
	public Object modifyDailyExchangeRate(Map<String,Object> param) throws Exception;
	public Object deleteDailyExchangeRate(List<Map<String,Object>> param) throws Exception;
	public Object auditDailyExchangeRate(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addDailyExchangeRate(Map<String,Object> param) throws Exception;
	public Object judgeDailyExchangeRate(Map<String,Object> param) throws Exception;
	public Object getDailyExchangeRate(Map<String,Object> param) throws Exception;
	
}
