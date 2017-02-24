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
import com.robam.distribution.base.service.IBankService;
/**
 * drp_bas_f13 银行资料维护作业
 * @author gejc
 * @since 2017-02-17
 *
 */
public class BankService implements IBankService {
	@Autowired
	private  Dao dao;
	
	/**
	 * 分页查询银行数据
	 * @param startPage,pageSize,param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object getBankList(int startPage, int pageSize,
			Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseBasBankSettingMapper.getBankListCount","dao.BaseBasBankSettingMapper.getBankList", param, startPage, pageSize);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile; 
	}
	
	/**
	 * 修改银行数据
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object modifyBank(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		if(StringUtils.isEmpty(param.get("bank_branch"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("bank_location_code and language cannot be null!");
		}
		int count=this.dao.update("dao.BaseBasBankSettingMapper.updateBank", param);
		Map<String, Object> profile = new HashMap<String, Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "修改数据"+str);
		return profile;
	}
	
	/**
	 * 批量删除银行数据
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object deleteBank(List<Map<String,Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("bank_branch"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("bank_location_code and language cannot be null!");
			}
			count += dao.delete("dao.BaseBasBankSettingMapper.deleteBank", map);
		}
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
	 * 批量审核银行数据
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object auditBank(List<Map<String,Object>> param, String status_code)
			throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		if(status_code==null){
			throw new Exception("status_code cannot be null!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("bank_branch"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("bank_location_code and language cannot be null!");
			}
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			map.put("last_modified_date", new Date());
			map.put("data_modified_by",userId);
			map.put("status_code", status_code);
			count += dao.update("dao.BaseBasBankSettingMapper.auditBank", map);
		}
		if(count!=param.size()){
			throw new Exception("audit fail!");
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue",count==param.size());
		String str=count==param.size()?"成功":"失败";
		profile.put("description", "审批数据"+str);
		return profile;
	}
	
	/**
	 * 新增银行数据
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object addBank(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("bank_branch"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("bank_location_code and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasBankSettingMapper.getBank",param );
		Map<String,Object> profile=new HashMap<String,Object>();
		if(li!=null&&li.size()>0){
			profile.put("successValue",false);
			profile.put("description", "新增数据失败！该编号数据已存在！");
		}else{
			param.put("status_code", "Y");
			Date date = new Date();
			param.put("last_modified_date", date);
			param.put("data_created_date",date);
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			Object deptId = information.get("DeptId");
			param.put("data_owner",userId);
			param.put("data_owned_department",deptId);
			param.put("data_created_by",userId);
			param.put("data_created_department",deptId);
			param.put("data_modified_by",userId);
			int count= this.dao.insert("dao.BaseBasBankSettingMapper.addBank", param);
			profile.put("successValue", count>0);
			String str=count>0?"成功":"失败";
			profile.put("description", "新增数据"+str);
		}
		return profile;
	}
	
	/**
	 * 查询银行数据是否存在
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object judgeBank(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("bank_branch"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("bank_location_code and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasBankSettingMapper.getBank",param );
		Map<String,Object> profile=new HashMap<String,Object>();
		if(li!=null&&li.size()>0){
			profile.put("successValue", true);
			profile.put("description", "存在该数据");	
		}else{
			profile.put("successValue", false);
			profile.put("description", "不存在该数据");	
		}
		return profile;
	}
	
	/**
	 * 通过主键查询指定银行数据
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object getBank(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("bank_branch"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("bank_location_code and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasBankSettingMapper.getBank",param );
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", li!=null);
		profile.put("data", li!=null?li.get(0):null);
		profile.put("description", "查询数据"+li!=null?"成功":"失败");
		return profile;
	}
}
