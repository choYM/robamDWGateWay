package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp_bas_m04-员工职称维护作业
 * @author YangJian
 * @date 2017-02-17
 *
 */
public interface IEmployeeTitleService extends DWService{
	
	/**
	 * 根据预设条件查询员工职称列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public abstract Object getEmployeeTitleList(Map<String,Object> param , Integer startPage,Integer pageSize) throws Exception;
	
	/**
	 * 修改员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object modifyEmployeeTitle(Map<String,Object> param) throws Exception;
	
	/**
	 * 删除员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object deleteEmployeeTitle(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 审核员工职称
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	public abstract Object auditEmployeeTitle(List<Map<String,Object>> param,String status_code) throws Exception;
	
	/**
	 * 新增员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object addEmployeeTitle(Map<String,Object> param) throws Exception;
	
	/**
	 * 判断员工职称是否存在
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object judgeEmployeeTitle(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据主键查询员工职称
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object getEmployeeTitle(Map<String,Object> param) throws Exception;
	
}
