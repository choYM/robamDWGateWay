package com.robam.distribution.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.digiwin.DWPaginationQueryResult;
import com.digiwin.dao.Dao;
import com.robam.distribution.base.model.BasOrganizationHierarchy;
import com.robam.distribution.base.model.OrganizationHierarchy;
import com.robam.distribution.base.model.TreeNode;
import com.robam.distribution.base.service.IOrganizationHierarchyQueryService;
/**
 * drp_bas_m14 组织层级查询维护作业
 * @author gejc
 * @since 2017-02-14
 */
public class OrganizationHierarchyQueryService implements IOrganizationHierarchyQueryService {
	@Autowired
	private Dao dao;

	@Override
	public Object getOrganizationHierarchyList(int startPage, int pageSize,
			Map<String, Object> param) throws Exception {
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

	@Override
	public Object getOrganizationHierarchy(String top_org_code) throws Exception {
		
		return this.createTree(top_org_code);
	}

	
}
