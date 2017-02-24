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
import com.robam.distribution.base.service.IDocumentService;
/**
 * drp_bas_m02-单据别维护作业-
 * @author gejc
 * @since 2017-02-17
 **/ 
public class DocumentService implements IDocumentService {
	@Autowired
	private Dao dao;
	
	/**
	 * 分页查询单据别
	 * @param startPage,pageSize,param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object getDocumentList(int startPage, int pageSize,
			Map<String, Object> param) throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseBasDocumentSettingMapper.getDocumentListCount", "dao.BaseBasDocumentSettingMapper.getDocumentList", param, startPage, pageSize);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile;
	}
	
	/**
	 * 修改单据别
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object modifyDocument(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no"))||
				StringUtils.isEmpty(param.get("document"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no,document and language cannot be null!");
		}
		Map<String,Object> information=DWServiceContext.getContext().getProfile();
		Object userId = information.get("UserId");
		param.put("last_modified_date", new Date());
		param.put("data_modified_by",userId);
		int count= this.dao.update("dao.BaseBasDocumentSettingMapper.updateDocument", param);
		Map<String,Object> profile=new HashMap<String,Object>();
		profile.put("successValue", count>0);
		String str=count>0?"成功":"失败";
		profile.put("description", "修改数据"+str);
		return profile;
	}
	
	/**
	 * 批量删除单据别
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object deleteDocument(List<Map<String, Object>> param)
			throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no"))||
					StringUtils.isEmpty(map.get("document"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no,document and language cannot be null!");
			}
			count += dao.delete("dao.BaseBasDocumentSettingMapper.deleteDocument", map);
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
	 * 批量审核单据别
	 * @param param,status_code
	 * @return Object
	 * @author gejc
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public Object auditDocument(List<Map<String, Object>> param,
			String status_code) throws Exception {
		if (param == null || param.size() == 0) {
			throw new Exception("Pls select at least one data!");
		}
		if(status_code==null){
			throw new Exception("status_code cannot be null!");
		}
		int count = 0;
		for (Map<String, Object> map : param) {
			map.put("language", "zh_CN");
			if(StringUtils.isEmpty(map.get("reference_table_no"))||
					StringUtils.isEmpty(map.get("document"))||
					StringUtils.isEmpty(map.get("language"))){
				throw new Exception("reference_table_no,document and language cannot be null!");
			}
			Map<String,Object> information=DWServiceContext.getContext().getProfile();
			Object userId = information.get("UserId");
			map.put("last_modified_date", new Date());
			map.put("data_modified_by",userId);
			map.put("status_code", status_code);
			count += dao.update("dao.BaseBasDocumentSettingMapper.auditDocument", map);
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
	 * 新增单据别
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object addDocument(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no"))||
				StringUtils.isEmpty(param.get("document"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no,document and language cannot be null!");
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		//默认单别 为Y时，根据参照表编号、单据别、对应作业编号、语言别及默认单别Y查询是否有记录
		if("Y".equals(param.get("default_document"))){
			if(this.isExistDefaultDocument(param)){//存在默认单别
				profile.put("successValue",false);
				profile.put("description", "默认单别已存在！");
			}
		}
		
		List<Object> li=this.dao.query("dao.BaseBasDocumentSettingMapper.getDocument",param );
		
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
			int count= this.dao.insert("dao.BaseBasDocumentSettingMapper.addDocument", param);
			profile.put("successValue", count>0);
			String str=count>0?"成功":"失败";
			profile.put("description", "新增数据"+str);
		}
		return profile;
	}
	
	/**
	 * 默认单别 为Y时，根据参照表编号、单据别、对应作业编号、语言别及默认单别Y查询是否有记录
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public boolean isExistDefaultDocument(Map<String,Object> param) throws Exception{
		
		Map<String,Object> tempMap = new HashMap<String,Object>();
		//参照表编号
		tempMap.put("reference_table_no",param.get("reference_table_no"));
		//单据别
		tempMap.put("document",param.get("document"));
		//对应作业编号
		tempMap.put("corresponding_program_no",param.get("corresponding_program_no"));
		//语言别
		tempMap.put("language", param.get("language"));
		//默认单别Y
		tempMap.put("default_document", "Y");
		
		List<Integer> data = this.dao.query("dao.BaseBasDocumentSettingMapper.isExistDefaultDocument", tempMap);
		//存在默认单别 返回true
		return data.get(0) > 0 ? true:false;
	
	}
	
	/**
	 * 判断单据别是否存在
	 * @param param
	 * @return Object
	 * @author gejc
	 */
	@Override
	public Object judgeDocument(Map<String, Object> param) throws Exception {
		if(param==null){
			throw new Exception("param cannot be null!");
		}
		param.put("language", "zh_CN");
		if(StringUtils.isEmpty(param.get("reference_table_no"))||
				StringUtils.isEmpty(param.get("document"))||
				StringUtils.isEmpty(param.get("language"))){
			throw new Exception("reference_table_no,document and language cannot be null!");
		}
		List<Object> li=this.dao.query("dao.BaseBasDocumentSettingMapper.getDocument",param );
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
	public Object getDocumentSettingByDoc(Map<String, Object> param) throws Exception {
		param.put("language", "zh_CN");
		if (StringUtils.isEmpty(param.get("document")) || StringUtils.isEmpty(param.get("language"))) {
			throw new Exception("document and language cannot be null!");
		}
		Map<String, Object> profile = new HashMap<String, Object>();
		Object result = this.dao.query("dao.BaseSysDocumentSettingSettingMapper.getDocumentSettingByDoc", param);
		profile.put("successValue", true);
		profile.put("description", "");
		profile.put("data", result);
		return profile;
	}
	
}
