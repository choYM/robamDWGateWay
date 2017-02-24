package com.robam.distribution.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.service.IVoucherFlexibilityService;

/**
 * drp_bas_f07 传票摘要弹性预设作业
 * @author gejc
 * @since 2017-02-14
 **/ 
 
public class VoucherFlexibilityService implements IVoucherFlexibilityService{
	@Autowired
	private  Dao dao;
	@Override
	public Object getVoucherFlexibilityList(int startPage, int pageSize,
			Map<String, Object> param) throws Exception {
		if(param!=null){
			param.put("language", "CN");
		}
		Map<String,Object> profile=new HashMap<String,Object>();
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseBasVoucherFlexibilitySettingMapper.getVoucherFlexibilityListCount",
				"dao.BaseBasVoucherFlexibilitySettingMapper.getVoucherFlexibilityList", param, startPage, pageSize);
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile; 
	}

	@Override
	public Object modifyVoucherFlexibility(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param!=null){
			param.put("language", "CN");
			this.dao.query("dao.BaseBasVoucherFlexibilitySettingMapper.updateVoucherFlexibility", param);
			profile.put("successValue", true);
			profile.put("description", "修改数据成功");
		}
		return profile;
	}

	@Override
	public Object deleteVoucherFlexibility(List<Map<String,Object>> param)
			throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param!=null){
			Map<String, Object> deleteInfo = new HashMap<String, Object>();
			deleteInfo.put("list", param);
			deleteInfo.put("language", "CN");
			this.dao.query("dao.BaseBasVoucherFlexibilitySettingMapper.deleteVoucherFlexibility", deleteInfo);
			profile.put("successValue", true);
			profile.put("description", "删除数据成功");		
		}
		return profile;
	}

	@Override
	public Object auditVoucherFlexibility(List<Map<String,Object>> param,
			String status_code) throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param!=null){
			Map<String, Object> auditInfo = new HashMap<String, Object>();
			auditInfo.put("list", param);
			auditInfo.put("status", status_code);
			auditInfo.put("language", "CN");
			this.dao.query("dao.BaseBasVoucherFlexibilitySettingMapper.auditVoucherFlexibility", auditInfo);
			profile.put("successValue", true);
			profile.put("description", "审批数据成功");
		}
		return profile;
	}

	@Override
	public Object addVoucherFlexibility(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		if(param!=null){
			param.put("language", "CN");
			List li=this.dao.query("dao.BaseBasVoucherFlexibilitySettingMapper.getVoucherFlexibility",param );
			if(li!=null&&li.size()>0){
				profile.put("successValue",false);
				profile.put("description", "新增数据失败！该编号数据已存在！");
			}else{
				param.put("status_code", "Y");
				param.put("acc", 2001);
				this.dao.query("dao.BaseBasVoucherFlexibilitySettingMapper.addVoucherFlexibility", param);
				profile.put("successValue", true);
				profile.put("description", "新增数据成功");
			}
		}
		return profile;
	}
	
}
