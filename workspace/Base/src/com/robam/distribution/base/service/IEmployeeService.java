package com.robam.distribution.base.service;
import java.util.List;
import java.util.Map;

import com.digiwin.app.service.AllowAnonymous;
import com.digiwin.app.service.DWService;
/**
 * drp_bas_m03 员工维护作业 
 * @author gejc
 * @since 2017-02-20
 **/
public interface IEmployeeService extends DWService {
	public Object getEmployeeList(int startPage,int pageSize,Map<String,Object> param) throws Exception;
	public Object modifyEmployee(Map<String,Object> param) throws Exception;
	public Object getEmployeeAddressList(Map<String,Object> param) throws Exception;
	public Object getEmployeeCommunicationList(Map<String,Object> param) throws Exception;
	public Object getEmployee(Map<String,Object> param) throws Exception;
	public Object modifyEmployeeAddress(Map<String,Object> param) throws Exception;
	public Object modifyEmployeeCommunication(Map<String,Object> param) throws Exception;
	public Object deleteEmployee(List<Map<String,Object>> param) throws Exception;
	public Object deleteEmployeeAddress(Map<String,Object> param) throws Exception;
	public Object deleteEmployeeCommunication(Map<String,Object> param) throws Exception;
	public Object addEmployee(Map<String,Object> param) throws Exception;
	public Object addEmployeeAddress(Map<String,Object> param) throws Exception;
	public Object addEmployeeCommunication(Map<String,Object> param) throws Exception;
}
