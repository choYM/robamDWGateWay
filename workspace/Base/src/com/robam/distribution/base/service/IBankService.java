package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_f13 银行资料维护作业 
 * gejc
 **/
public interface IBankService extends DWService {
	public Object getBankList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifyBank(Map<String,Object> param) throws Exception;
	public Object deleteBank(List<Map<String,Object>> param) throws Exception;
	public Object auditBank(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addBank(Map<String,Object> param) throws Exception;
	public Object judgeBank(Map<String,Object> param) throws Exception;
	public Object getBank(Map<String,Object> param) throws Exception;
}
