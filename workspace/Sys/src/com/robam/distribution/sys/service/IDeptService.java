package com.robam.distribution.sys.service;

import java.util.List;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * 2016-11-2 Demo 登錄服務接口
 * 
 * @author falcon
 *
 */
public interface IDeptService extends DWService {

	/**
	 * 取得所有部門
	 * 
	 * @return 登錄結果
	 */
	@AllowAnonymous
	public List<String> getDepts() throws Exception;
}
