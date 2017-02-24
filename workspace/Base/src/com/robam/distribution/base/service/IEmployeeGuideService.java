package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m99 门店导购员维护作业
 * @author YangJian
 * @date 2017-02-20
 */
public interface IEmployeeGuideService extends DWService {

	/**
	 * 根据预设条件查询门店导购员列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public abstract Object getEmployeeGuideList(Map<String,Object> param,Integer startPage,Integer pageSize) throws Exception;
	
	/**
	 * 修改门店导购员(包含审核门店导购员)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object modifyEmployeeGuide(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 删除门店导购员
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object deleteEmployeeGuide(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 新增门店导购员
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object addEmployeeGuide(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据门店导购员(判断门店导购员是否存在)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object getEmployeeGuide(Map<String,Object> param) throws Exception;
	
}
