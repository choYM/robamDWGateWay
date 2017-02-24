package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m29 休假类型维护作业
 * @author gejc
 * @since 2017-02-14
 **/ 
public interface IVacationCategoryService extends DWService {
	public Object getVacationCategoryList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifyVacationCategory(Map<String,Object> param) throws Exception;
	public Object deleteVacationCategory(List<Map<String,Object>> param) throws Exception;
	public Object auditVacationCategory(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addVacationCategory(Map<String,Object> param) throws Exception;
	public Object judgeVacationCategory(Map<String,Object> param) throws Exception;
	public Object getVacationCategory(Map<String,Object> param) throws Exception;
}
