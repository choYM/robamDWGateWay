package com.robam.distribution.base.service;

import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;

/**
 * drp-bas-m02 部门资料维护作业
 * @author YangJian
 * @date by 2017-02-20
 * 
 */
public interface IDepartmentService extends DWService {

	/**
	 * 根据预设条件查询部门列表（分页）
	 * @param param
	 * @param startPage
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public abstract Object getDepartmentList(Map<String,Object> param,Integer startPage,Integer pageSize) throws Exception;
	
	/**
	 * 修改部门(包含审核部门)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object modifyDepartment(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 删除部门
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object deleteDepartment(List<Map<String,Object>> param) throws Exception;
	
	/**
	 * 新增部门
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object addDepartment(Map<String,Object> param) throws Exception;
	
	/**
	 * 根据部门主键获取相关记录(判断部门是否存在)
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public abstract Object getDepartment(Map<String,Object> param) throws Exception;
	
}
