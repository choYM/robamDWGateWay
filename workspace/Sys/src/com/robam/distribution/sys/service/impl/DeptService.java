package com.robam.distribution.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.robam.distribution.sys.service.IDeptService;

/**
 * 2016-11-2 Demo 登錄服務實現 2017-02-14 login
 * 
 * @author falcon
 *
 */

public class DeptService implements IDeptService {

	@Override
	public List<String> getDepts() throws Exception {
		List<String> deptList = new ArrayList<String>();
		deptList.add("DeptA");
		deptList.add("DeptB");
		return deptList;
	}
}
