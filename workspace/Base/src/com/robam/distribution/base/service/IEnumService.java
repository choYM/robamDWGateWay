package com.robam.distribution.base.service;

import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

public interface IEnumService extends DWService{
	
	public Object getEnumList(Map<String, Object> params) throws Exception;

}
