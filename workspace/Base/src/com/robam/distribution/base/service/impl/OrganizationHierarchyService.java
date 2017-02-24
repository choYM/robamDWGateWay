package com.robam.distribution.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.model.BasOrganization;
import com.robam.distribution.base.model.BasOrganizationHierarchy;
import com.robam.distribution.base.model.OrganizationHierarchy;
import com.robam.distribution.base.model.TreeNode;
import com.robam.distribution.base.service.IOrganizationHierarchyService;


/**
 * drp_bas_m13 组织层级关系维护作业
 * @author YangJian
 * @since 2017-02-14
 */
public class OrganizationHierarchyService implements IOrganizationHierarchyService {

	@Autowired
	private Dao dao;
	
	@Override
	public Object getOrganizationHierarchyList(Integer startPage, Integer pageSize, Map<String, Object> param) throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		//1.先去数据库查询到所有的最上层组织
		DWPaginationQueryResult data=this.dao.executePagination("dao.BaseBasOrganizationHierarchySettingMapper.getOrganizationHierarchyListCount",
				"dao.BaseBasOrganizationHierarchySettingMapper.getOrganizationHierarchyList", param, startPage, pageSize);
		
		if(data.getDatas()!=null && data.getDatas().size()>0){
			//2.再去带出第一笔数据的全部下层组织信息
			BasOrganizationHierarchy item = (BasOrganizationHierarchy) data.getDatas().get(0);
			if(item!=null){
				TreeNode<OrganizationHierarchy> trees=createTree(item.getTop_organization());
				if(trees==null){
					item.setOrg_hierarchy(new ArrayList<TreeNode<OrganizationHierarchy>>());
				}else{
					item.setOrg_hierarchy(trees.getUnder_org());
				}
			}
		}
		boolean flag=data!=null;
		String str=flag?"成功":"失败";
		profile.put("data", data);
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile; 
	}
	
	@Override
	public Object getOrganizationHierarchyDetail(Map<String, Object> param)
			throws Exception {
		Map<String,Object> profile=new HashMap<String,Object>();
		List<BasOrganizationHierarchy> list=this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.getOrganizationHierarchyDetail", param);
		if(list!=null&&list.size()>0){
			BasOrganizationHierarchy item=list.get(0);
			//3.对取得的全部下层组织进行递归查询
			if(item!=null){
				TreeNode<OrganizationHierarchy> trees=createTree(item.getTop_organization());
				if(trees==null){
					item.setOrg_hierarchy(new ArrayList<TreeNode<OrganizationHierarchy>>());
				}else{
					item.setOrg_hierarchy(trees.getUnder_org());
				}
			}
			profile.put("data", list.get(0));
		}
		boolean flag=list!=null;
		String str=flag?"成功":"失败";
		profile.put("successValue", flag);
		profile.put("description", "查询数据"+str);
		return profile;
	}

	/**
	 * 获取最上层组织下的所有层级组织
	 * 
	 * @throws Exception
	 *
	 */
	private List<OrganizationHierarchy> getAllOrgnizations(String top_organization) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("top_organization", top_organization);
		List<OrganizationHierarchy> orgs = this.dao
				.query("dao.BaseBasOrganizationHierarchySettingMapper.getAllOrgnizations", params);
		return orgs;
	}
	
	/**
	 * 获取生成的树
	 * 
	 * @throws Exception
	 */
	private TreeNode<OrganizationHierarchy> createTree(String top_organization) throws Exception {
		List<OrganizationHierarchy> orgs = this.getAllOrgnizations(top_organization);

		List<TreeNode<OrganizationHierarchy>> nodes = new ArrayList<TreeNode<OrganizationHierarchy>>();
		for (OrganizationHierarchy org : orgs) {
			TreeNode<OrganizationHierarchy> node = new TreeNode<OrganizationHierarchy>();
			// 节点id
			node.setOrganization(org.getOrganization().toString());
			// 节点上级id
			node.setHigher_organization(org.getHigher_organization().toString());
			node.setOrganization_name(org.getOrganization_name());
			nodes.add(node);
		}
		return TreeNode.buildTree(nodes);
	}
	
	

	/**
	 * 根据组织类型获取基础组织列表
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getOrganizationBase(Map<String,Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		List<BasOrganization> data = this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.getOrganizationBase", param);
		if(data!=null){
			profile.put("datas", data);
			profile.put("successValue",true);
			profile.put("description", "根据组织类型获取基础组织列表 成功");
		}else{
			profile.put("successValue",true);
			profile.put("description", "根据组织类型获取基础组织列表 数据为空");
		}
		return profile;
	}
	

	/**
	 * 获取最上层组织
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object getTopOrganization(Map<String,Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		List<BasOrganization> data = this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.getTopOrganization",param);
		if(data!=null){
			profile.put("datas", data);
			profile.put("successValue",true);
			profile.put("description", "获取最上层组织 成功");
		}else{
			profile.put("successValue",true);
			profile.put("description", "获取最上层组织 数据为空");
		}
		return profile;
	}

	/**
	 * 修改组织层级
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object modifyOrganizationHierarchy(
			Map<String,Object> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.modifyOrganizationHierarchy", param);
		profile.put("successValue",true);
		profile.put("description", "修改组织层级");
		return profile;
	}

	/**
	 * 删除组织层级
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object deleteOrganizationHierarchy(List<BasOrganizationHierarchy> param) throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		Map<String,Object> orgMap = new HashMap<String,Object>();
		orgMap.put("orgMap", param);
		this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.deleteOrganizationHierarchy", orgMap);
		this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.deleteOrganizationHierarchy2", orgMap);
		profile.put("successValue",true);
		profile.put("description", "删除组织层级");
		return profile;
	}

	/**
	 * 审核组织层级
	 * @param param
	 * @param status_code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object auditOrganizationHierarchy(List<BasOrganizationHierarchy> param, String status_code)
			throws Exception {
		Map<String,Object> profile = new HashMap<String,Object>();
		Map<String,Object> orgMap = new HashMap<String,Object>();
		orgMap.put("orgMap", param);
		orgMap.put("status_code", status_code);
		this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.auditOrganizationHierarchy",orgMap);
		profile.put("successValue",true);
		profile.put("description", "审核组织层级");
		return profile;
	}

	/**
	 * 新增组织层级
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object addOrganizationHierarchy(
			Map<String,Object> param) throws Exception {
		if(param!=null){
			param.put("language", "CN");
			param.put("operation_organization", "待定编号");
			param.put("operation_organization_name", "待定组织名");
		}
		Map<String,Object> profile = new HashMap<String,Object>();
		List<String> list = this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.queryMaxId",param);
		String requisition_no = String.valueOf((Integer.parseInt(list.get(0).split("\\.")[0])));
		param.put("requisition_no", requisition_no);
		param.put("status_code", "Y");
		this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.addOrganizationHierarchy", param);
		this.dao.query("dao.BaseBasOrganizationHierarchySettingMapper.addOrganizationHierarchy2", param);
		profile.put("successValue",true);
		profile.put("description", "新增组织层级");
		return profile;
	}
	
}
