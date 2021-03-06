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
import com.robam.distribution.base.service.ICollectConditionService;
/**
 * drp_bas_m30 收款条件维护服务
 * @author yangjian
 * @since 2017-02-17
 **/
public class CollectConditionService implements ICollectConditionService {

	@Autowired
	private Dao dao;
	
	/**
	 * 根据预设条件查询收款条件列表（分页）
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getCollectConditionList(int startPage, int pageSize, Map<String,Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		DWPaginationQueryResult data = this.dao.executePagination("dao.BaseCollectConditionSettingMapper.selectCollectConditionCount","dao.BaseCollectConditionSettingMapper.selectCollectConditionLimit",param,startPage,pageSize);
		Map<String,Object> profile = new HashMap<String,Object>();
		profile.put("successValue",true);
		profile.put("description", "根据预设条件查询收款条件列表（分页）");
		profile.put("data", data);
		return profile;
	}

	/**
	 * 修改收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyCollectCondition(Map<String,Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("collection_term"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("collection_term and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		int count=this.dao.insert("dao.BaseCollectConditionSettingMapper.updateCollectCondition", param);
		Map<String,Object> profile = new HashMap<String,Object>();
		profile.put("successValue", count>0);String str=count>0?"成功":"失败";
		profile.put("description", "修改收款条件"+str);
		return profile;
	}

	/**
	 * 删除收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object deleteCollectCondition(List<Map<String,Object>> param) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("collection_term"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("collection_term and language cannot be null!");
			}
			count += dao.delete("dao.BaseCollectConditionSettingMapper.deleteCollectCondition", map);
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
	 * 审核收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object auditCollectCondition(List<Map<String,Object>> param,String status_code) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		if(status_code==null){
			throw new Exception("status_code cannot be null!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("collection_term"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("collection_term and language cannot be null!");
			}
			map.put("status_code", status_code);
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			map.put("last_modified_date", new Date());
			map.put("data_modified_by",userId);
			count += dao.update("dao.BaseCollectConditionSettingMapper.auditCollectCondition", map);
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
	 * 新增收款条件
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addCollectCondition(Map<String,Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("collection_term"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("collection_term and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseCollectConditionSettingMapper.queryCollectConditionCountId",param );
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
			int count= this.dao.insert("dao.BaseCollectConditionSettingMapper.addCollectCondition", param);
			profile.put("successValue", count>0);
			String str=count>0?"成功":"失败";
			profile.put("description", "新增数据"+str);
		}
		return profile;
	}
	
	@Override
	public Object judgeCollectCondition(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("collection_term"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("collection_term and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseCollectConditionSettingMapper.queryCollectConditionCountId",param );
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
	
	@Override
	public Object getCollectCondition(Map<String, Object> param)
			throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("collection_term"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("collection_term and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseCollectConditionSettingMapper.queryCollectConditionCountId",param );
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", li!=null);
		profile.put("data", li!=null?li.get(0):null);
		profile.put("description", "查询数据"+li!=null?"成功":"失败");
		return profile;
	}
}
