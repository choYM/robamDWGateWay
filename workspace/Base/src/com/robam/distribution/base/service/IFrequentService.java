package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

public interface IFrequentService extends DWService{
	
	public Object addSearchCondition(List<Map<String, Object>> params, String program_code) throws Exception;
	
	public Object getSearchCondition(Map<String, Object> params ) throws Exception;
	
	

}
