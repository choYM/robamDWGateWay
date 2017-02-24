package com.robam.distribution.base.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.app.service.DWServiceContext;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IEmployeeService;
/**
 * drp_bas_m03 员工维护作业 
 * @author gejc
 * @since 2017-02-20
 **/
public class EmployeeService implements IEmployeeService {
	@Autowired
	private  Dao dao;
	
	/**
	 * 分页查询银行数据
	 * @param startPage,pageSize,param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object getEmployeeList(int startPage, int pageSize,
			Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseBasEmployeeSettingMapper.getEmployeeListCount","dao.BaseBasEmployeeSettingMapper.getEmployeeList", param, startPage, pageSize);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile;
	}

	/**
	 * 根据员工编号获取员工地址
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object getEmployeeAddressList(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		param.put("status_code", "Y");
		if(StringUtils.isEmpty(param.get("language"))||StringUtils.isEmpty(param.get("employee_no"))){
			throw new Exception("employee_no and language cannot be null!");
		}
		List<Object> data=this.dao.query("dao.BaseBasEmployeeSettingMapper.getEmployeeAddressList",param);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile;
	}
	
	/**
	 * 根据员工编号获取员工通讯方式
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object getEmployeeCommunicationList(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		param.put("status_code", "Y");
		if(StringUtils.isEmpty(param.get("language"))||StringUtils.isEmpty(param.get("employee_no"))){
			throw new Exception("employee_no and language cannot be null!");
		}
		List<Object> data=this.dao.query("dao.BaseBasEmployeeSettingMapper.getEmployeeCommunicationList",param);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile;
	}
	
	/**
	 * 根据员工编号获取员工信息
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object getEmployee(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasEmployeeSettingMapper.getEmployee",param );
		Map<String,Object> profile=new HashMap<String,Object>();
		if(li!=null && li.size()>0){
			profile.put("data", li.get(0));
		}
		profile.put("successValue", li!=null&&li.size()>0);
		profile.put("description", "查询数据"+li!=null&&li.size()>0?"成功":"失败");	
		return profile;
	}
	
	
	/**
	 * 修改员工数据
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object modifyEmployee(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		//1.首先修改员工信息
		int count=this.dao.update("dao.BaseBasEmployeeSettingMapper.updateEmployee", param);
		//2.修改员工信息成功后，将主表的默认联系地址的修改内容，同时带入到员工地址表进行修改
		if(count>0){
			param.put("address_type2","2");
			param.put("is_pramary_address2","Y");
			this.dao.update("dao.BaseBasEmployeeSettingMapper.updateEmployeeAndAddress", param);
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "修改数据"+str);
		return profile;
	}
	
	/**
	 * 修改员工地址
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object modifyEmployeeAddress(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("address_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no,address_no and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		//1.首先对要修改的目标地址进行修改
		int count= this.dao.update("dao.BaseBasEmployeeSettingMapper.updateEmployeeAddress", param);
		if(count>0){
			//2.修改成功后，若发现修改成默认联络地址，则主表的联络地址进行修改
			if(param.get("address_type")!=null&&param.get("is_pramary_address")!=null&&
					param.get("address_type").equals("2")&&
					param.get("is_pramary_address").equals("Y")){
				this.dao.update("dao.BaseBasEmployeeSettingMapper.updateAddressToEmployee", param);
			}
			//3.并且再把原来的默认联络地址，修改成非默认状态
			if(param.get("is_pramary_address")!=null&&param.get("is_pramary_address").equals("Y")){
				this.dao.update("dao.BaseBasEmployeeSettingMapper.updateEmployeeAddressN",param);
			}
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "修改数据"+str);
		return profile;
	}
	
	/**
	 * 修改员工通讯方式
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object modifyEmployeeCommunication(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("communication_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no,communication_no and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		//1.首先修改目标通讯方式
		int count= this.dao.update("dao.BaseBasEmployeeSettingMapper.updateEmployeeCommunication", param);
		//2.修改成功后，若发现修改成了主要通讯方式，则将该员工下的原主要通讯方式设为非主要通讯方式
		if(count>0){
			if(param.get("is_primary_communication")!=null&&param.get("is_primary_communication").equals("Y")){
				this.dao.update("dao.BaseBasEmployeeSettingMapper.updateCommunicationToN", param);
			}
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "修改数据"+str);
		return profile;
	}
	
	/**
	 * 批量删除员工
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object deleteEmployee(List<Map<String, Object>> param)
			throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "CN");
			if(StringUtils.isEmpty(map.get("employee_no"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("employee_no and language cannot be null!");
			}
			//1.首先，循环删除每一个目标员工
			count += dao.delete("dao.BaseBasEmployeeSettingMapper.deleteEmployee", map);
			//2.然后，在删除该目标员工下的全部地址信息
			this.dao.delete("dao.BaseBasEmployeeSettingMapper.deleteEmployeeAddress", map);
			//3.最后，删除该目标员工下的全部通讯方式
			this.dao.delete("dao.BaseBasEmployeeSettingMapper.deleteEmployeeCommunication", map);
		}
		//若最后删除量和参数数组数量不一样，则抛出异常
		if(count!=param.size()){
			throw new Exception("delete fail!");
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count==param.size());
		String str=count==param.size()?"成功":"失败";
		profile.put("description", "删除数据"+str);		
		return profile;
	}

	/**
	 * 删除员工地址
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object deleteEmployeeAddress(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("address_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no,address_no and language cannot be null!");
		}
		//1.删除前，先通过主键信息，找到将要删除的地址的信息
		List<Map<String,Object>> list=this.dao.query("dao.BaseBasEmployeeSettingMapper.getEmployeeAddressList", param);
		Map<String,Object> map=list!=null?list.get(0):null;
		//2.找到并保存该地址信息后，再删除该目标地址
		int count=this.dao.delete("dao.BaseBasEmployeeSettingMapper.deleteEmployeeAddress",param);
		if(map!=null){
			//3.从删除前的信息中，若发现，要删除的地址，为默认联络地址，则需要查询到，该员工的第一个其他的联络地址
			if(map.get("address_type")!=null&&map.get("is_pramary_address")!=null&&
					map.get("address_type").equals("2")&&
					map.get("is_pramary_address").equals("Y")){
				List<Map<String,Object>> li=this.dao.query("dao.BaseBasEmployeeSettingMapper.getMaxEmployeeAddress", param);
				Map<String,Object> param2=li!=null?list.get(0):null;
				System.out.println("*****************"+param+param==null);
				//4.若删除上述地址后，查询不到该员工有其他的联络地址，则将主表的联络地址信息全部设为空
				if(param2==null){
					this.dao.update("dao.BaseBasEmployeeSettingMapper.updateAddressNull",param);
				//4.若删除上述地址后，查询到该员工还有其他的联络地址，则取出第一个联络地址，将该地址更新到主表的联络地址中
				}else{
					param2.put("employee_no", param.get("employee_no"));
					param2.put("language", param.get("language"));
					this.dao.update("dao.BaseBasEmployeeSettingMapper.updateAddressToEmployee",param2);
				}
			}
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "删除数据"+str);
		return profile;
	}
	
	/**
	 * 删除员工通讯方式
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object deleteEmployeeCommunication(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("communication_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no,communication_no and language cannot be null!");
		}
		//通讯方式，直接删除即可
		int count=this.dao.delete("dao.BaseBasEmployeeSettingMapper.deleteEmployeeCommunication",param);
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "删除数据"+str);
		return profile;
	}
	
	/**
	 * 新增员工信息
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object addEmployee(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no and language cannot be null!");
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		//1.新增员工前，先查询是否已有相同数据
		List<Object> li=this.dao.query("dao.BaseBasEmployeeSettingMapper.getEmployee",param );
		if(li!=null&&li.size()>0){
			profile.put("successValue",false);
			profile.put("description", "新增数据失败！该编号数据已存在！");
		}else{
			param.put("status_code", "Y");
			Date date=new Date();
			param.put("data_created_date",date);
			param.put("last_modified_date",date);
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			Object deptId = information.get("DeptId");
			param.put("data_owner",userId);
			param.put("data_owned_department",deptId);
			param.put("data_created_by",userId);
			param.put("data_created_department",deptId);
			param.put("data_modified_by",userId);
			//2.若没有相同数据，则新增员工信息
			int count= this.dao.insert("dao.BaseBasEmployeeSettingMapper.addEmployee", param);
			param.put("address_no", "1");
			param.put("address_type", "2");
			param.put("is_pramary_address", "Y");
			//3.同时，将新增员工信息中的默认联络地址相关信息，新增到地址表当中
			int num=this.dao.insert("dao.BaseBasEmployeeSettingMapper.addEmployeeAddress", param);
			//5.若新增员工参数信息中，还有更多地址，则循环插入更多地址
			if(param.get("address_list")!=null){
				List<Map<String,Object>> addressList=(List<Map<String,Object>>)param.get("address_list");
				for (Map<String, Object> map : addressList) {
					map.put("language", "CN");
					//地址ID，查询数据库，并生成
					List<Integer> item=this.dao.query("dao.BaseBasEmployeeSettingMapper.getMaxAddressId",param);
					Integer id=item!=null&&item.get(0)!=null?item.get(0):0;
					map.put("address_no", (++id).toString());
					map.put("employee_no", param.get("employee_no"));
					if(StringUtils.isEmpty(map.get("employee_no"))||
							StringUtils.isEmpty(map.get("address_no"))||
							StringUtils.isEmpty(map.get("language"))){
						throw new Exception("employee_no,address_no and language cannot be null!");
					}
					map.put("status_code", "Y");
					map.put("data_created_date",date);
					map.put("last_modified_date",date);
					map.put("employee_name", param.get("employee_name"));
					map.put("data_owner",param.get("userId"));
					map.put("data_owned_department",param.get("deptId"));
					map.put("data_created_by",param.get("userId"));
					map.put("data_created_department",param.get("deptId"));
					map.put("data_modified_by",param.get("userId"));
					this.dao.insert("dao.BaseBasEmployeeSettingMapper.addEmployeeAddress", map);
				}
			}
			//6.若新增员工参数信息中，还有更多通讯方式，则循环插入更多通讯方式
			if(param.get("communication_list")!=null){
				List<Map<String,Object>> communicationList=(List<Map<String,Object>>)param.get("communication_list");
				for (Map<String, Object> map : communicationList) {
					map.put("language", "CN");
					//通讯方式ID，查询数据库，并生成
					List<Integer> item=this.dao.query("dao.BaseBasEmployeeSettingMapper.getCommunicationMaxId",param);
					Integer id=item!=null&&item.get(0)!=null?item.get(0):0;
					map.put("communication_no", (++id).toString());
					map.put("employee_no", param.get("employee_no"));
					if(StringUtils.isEmpty(map.get("employee_no"))||
							StringUtils.isEmpty(map.get("communication_no"))||
							StringUtils.isEmpty(map.get("language"))){
						throw new Exception("employee_no,communication_no and language cannot be null!");
					}
					map.put("status_code", "Y");
					map.put("data_created_date",date);
					map.put("last_modified_date",date);
					map.put("employee_name", param.get("employee_name"));
					map.put("data_owner",param.get("userId"));
					map.put("data_owned_department",param.get("deptId"));
					map.put("data_created_by",param.get("userId"));
					map.put("data_created_department",param.get("deptId"));
					map.put("data_modified_by",param.get("userId"));
					this.dao.insert("dao.BaseBasEmployeeSettingMapper.addEmployeeCommunication", map);
				}
			}
			profile.put("successValue", count>0&&num>0);
			String str=count>0&&num>0?"成功":"失败";
			profile.put("description", "新增数据"+str);
		}
		return profile;
	}
	
	/**
	 * 新增员工地址信息
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object addEmployeeAddress(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		//地址ID，查询数据库，并生成
		List<Integer> item=this.dao.query("dao.BaseBasEmployeeSettingMapper.getMaxAddressId",param);
		Integer id=item!=null&&item.get(0)!=null?item.get(0):0;
		param.put("address_no", (++id).toString());
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("address_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no,address_no and language cannot be null!");
		}
		param.put("status_code", "Y");
		Date date=new Date();
		param.put("data_created_date",date);
		param.put("last_modified_date",date);
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Object deptId = information.get("DeptId");
		param.put("data_owner",userId);
		param.put("data_owned_department",deptId);
		param.put("data_created_by",userId);
		param.put("data_created_department",deptId);
		param.put("data_modified_by",userId);
		//1.首先，先插入目标地址到地址表
		int count= this.dao.insert("dao.BaseBasEmployeeSettingMapper.addEmployeeAddress", param);
		Map<String,Object> profile=new HashMap<String,Object>();
		if(count>0){
			//2.插入成功后，若发现插入数据为默认联络地址，则将主表默认联络地址更新为该信息
			if(param.get("address_type")!=null&&param.get("is_pramary_address")!=null&&
					param.get("address_type").equals("2")&&
					param.get("is_pramary_address").equals("Y")){
				this.dao.update("dao.BaseBasEmployeeSettingMapper.updateAddressToEmployee", param);
				//3.同时将附表中，原来的默认联络地址，设为N
				this.dao.update("dao.BaseBasEmployeeSettingMapper.updateEmployeeAddressN", param);
			}
		}
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "新增数据"+str);
		return profile;
	}

	
	/**
	 * 新增员工通讯方式信息
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object addEmployeeCommunication(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "CN");
		//通讯方式ID，查询数据库，并生成
		List<Integer> item=this.dao.query("dao.BaseBasEmployeeSettingMapper.getCommunicationMaxId",param);
		Integer id=item!=null&&item.get(0)!=null?item.get(0):0;
		param.put("communication_no", (++id).toString());
		if(StringUtils.isEmpty(param.get("employee_no"))||
				StringUtils.isEmpty(param.get("communication_no"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("employee_no,communication_no and language cannot be null!");
		}
		param.put("status_code", "Y");
		Date date=new Date();
		param.put("data_created_date",date);
		param.put("last_modified_date",date);
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		Object deptId = information.get("DeptId");
		param.put("data_owner",userId);
		param.put("data_owned_department",deptId);
		param.put("data_created_by",userId);
		param.put("data_created_department",deptId);
		param.put("data_modified_by",userId);
		//1.首先，先将目标通讯方式添加到通讯方式表
		int count= this.dao.insert("dao.BaseBasEmployeeSettingMapper.addEmployeeCommunication", param);
		Map<String,Object> profile=new HashMap<String,Object>();
		//2.添加成功后，若发现添加的数据为主要通讯方式，则该员工原主要通讯方式设为N
		if(count>0){
			if(param.get("is_primary_communication")!=null&&param.get("is_primary_communication").equals("Y")){
				this.dao.update("dao.BaseBasEmployeeSettingMapper.updateCommunicationToN", param);
			}
		}
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "新增数据"+str);
		return profile;
	}
	
}
