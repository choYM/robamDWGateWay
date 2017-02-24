package com.robam.distribution.sys.service;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWLoginResult;
import com.digiwin.app.service.DWService;

/**
 * 2016-11-2 Demo 登錄服務接口
 * 
 * @author falcon
 *
 */
public interface ILoginService extends DWService {

	/**
	 * 登錄
	 * 
	 * @param userId
	 *            使用者編號
	 * @param password
	 *            使用者密碼
	 * @return 登錄結果
	 */
	@AllowAnonymous
	public DWLoginResult<Object> login(String userId, String password, String deptId) throws Exception;
}
