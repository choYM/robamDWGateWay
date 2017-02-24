package com.robam.distribution.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.app.container.exceptions.DWException;
import com.digiwin.app.service.DWLoginResult;
import com.robam.distribution.sys.dao.impl.LoginMybatisDao;
import com.robam.distribution.sys.model.LoginInfo;
import com.robam.distribution.sys.service.ILoginService;

/**
 * 2016-11-2 Demo 登錄服務實現 2017-02-14 login
 * 
 * @author falcon
 *
 */

public class LoginService implements ILoginService {

	// private static com.sun.istack.internal.logging.Logger logger =
	// LogManager.getLogger(LoginServiceImp.class);

	/**
	 * Data Access Object
	 */
	@Autowired
	private LoginMybatisDao loginMybatisDao;

	@Override
	// @Value("${redis_active}")
	public DWLoginResult<Object> login(String userId, String password, String deptId) throws Exception {

		// boolean redis_active;

		List<Object> parameter = new ArrayList<Object>();
		parameter.add(userId);

		List<LoginInfo> userList = loginMybatisDao.execute("selectByUserId", parameter);

		if (userList.size() == 0 || !password.equals(userList.get(0).getPassword())) {
			throw new DWException("帐号或密码不正确!");
		}
		
		DeptService depService = new DeptService();
		if(!depService.getDepts().contains(deptId)){
			throw new DWException("部門不正确!");
		}

		Map<String, Object> userMap = new HashMap<String, Object>();
		String username = userList.get(0).getUserName();
		userMap.put("UserId", userId);
		userMap.put("DeptId", deptId);

		DWLoginResult<Object> resultLogin = new DWLoginResult<Object>(userMap, username);
		// logger.info("login:" + userId);
		// System.out.println("login:" + userId);

		return resultLogin;
	}
}