package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m20-单据别维护作业-
 * @author gejc
 * @since 2017-02-17
 **/
public interface IDocumentService extends DWService {
	public Object getDocumentList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifyDocument(Map<String,Object> param) throws Exception;
	public Object deleteDocument(List<Map<String,Object>> param) throws Exception;
	public Object auditDocument(List<Map<String,Object>> param, String status_code) throws Exception;
	public Object addDocument(Map<String,Object> param) throws Exception;
	public Object judgeDocument(Map<String,Object> param) throws Exception;
	public Object getDocumentSettingByDoc(Map<String,Object> param) throws Exception;
}
