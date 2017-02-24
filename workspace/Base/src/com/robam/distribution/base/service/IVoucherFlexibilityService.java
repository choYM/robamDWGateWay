package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_f07 传票摘要弹性预设作业
 * @author gejc
 * @since 2017-02-14
 **/ 
public interface IVoucherFlexibilityService extends DWService {
	public Object getVoucherFlexibilityList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifyVoucherFlexibility(Map<String,Object> param) throws Exception;
	public Object deleteVoucherFlexibility(List<Map<String,Object>> param) throws Exception;
	public Object auditVoucherFlexibility(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addVoucherFlexibility(Map<String,Object> param) throws Exception;
}
