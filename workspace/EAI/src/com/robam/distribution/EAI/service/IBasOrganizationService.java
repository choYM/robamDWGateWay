package com.robam.distribution.EAI.service;

import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

public interface IBasOrganizationService extends DWService {
	
	@AllowAnonymous
	public Map<String, Object> getOrganization() throws Exception;
	
}
