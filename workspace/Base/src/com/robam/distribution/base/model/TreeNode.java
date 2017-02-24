package com.robam.distribution.base.model;

import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * 树节点，支持Ext、zTree等Web控件 
 *  
 * @author gelf
 * @param <T> 树节点的绑定数据类 
 */  
public class TreeNode<T> {  
    /** 
     * 树节点id 
     * 为了兼容多种情况，使用String类型 
     */  
    private String organization;
      
    /** 
     * 树节点上级id 
     */  
    private String higher_organization;  
      
      
    /** 
     * 树节点名称
     */  
    private String organization_name;  
      
    /** 
     * 子节点，如果没有子节点，则列表长度为0 
     */  
    private List<TreeNode<T>> under_org = new ArrayList<TreeNode<T>>();  
    
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getHigher_organization() {
		return higher_organization;
	}

	public void setHigher_organization(String higher_organization) {
		this.higher_organization = higher_organization;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public List<TreeNode<T>> getUnder_org() {
		return under_org;
	}

	public void setUnder_org(List<TreeNode<T>> under_org) {
		this.under_org = under_org;
	}

	/** 
     * 把树节点列表构造成树，最后返回树的根节点，如果传入的列表有多个根节点，会动态创建一个根节点。 
     * @param nodes 树节点列表 
     * @return 根节点 
     */  
    public static <T> TreeNode<T> buildTree(List<TreeNode<T>> nodes){  
        if(nodes == null || nodes.size() == 0){  
            return null;  
        }  
          
        if(nodes.size() == 1){  
            return nodes.get(0);  
        }  
          
        //用来存放nodes里面的顶级树节点  
        //也就是把没有父节点的节点都放到tops里面去  
        List<TreeNode<T>> tops = new ArrayList<TreeNode<T>>();  
          
        boolean hasParent = false;  
        //第一次遍历，获取一个节点作为子节点  
        for(TreeNode<T> child : nodes){  
            hasParent = false;  
              
            //当前节点child的父节点id  
            String pid = child.getHigher_organization();  
              
            //如果pid不存在或为空  
            //则当前节点为顶级节点  
            if(pid == null || pid.equals("")){  
                //把当前节点添加到tops中作为顶级节点  
                tops.add(child);  
                //跳过当前节点，进入下一轮  
                continue;  
            }  
              
            //遍历nodes上的所有节点，判断是否有child的父节点  
            for(TreeNode<T> parent : nodes){  
                String id = parent.getOrganization();  
                  
                //如果parent节点的id等于child节点的pid，则parent节点是child节点的父节点  
                if(id != null && id.equals(pid)){  
                      
                    //把child加到parent下  
                    parent.getUnder_org().add(child);  
                      
                    //child节点有父节点  
                    hasParent = true;  
                      
                    continue;  
                }  
            }  
              
            //如果child节点没有父节点，则child是顶级节点  
            //把child添加到tops中  
            if(!hasParent){  
                tops.add(child);  
            }  
        }  
        TreeNode<T> root;  
        if(tops.size() == 1){  
            //如果顶级节点只有一个，该顶级节点是根节点  
            root = tops.get(0);  
        }else{  
            //如果顶级节点有多个，创建一个根节点，把顶级节点放到根节点下  
            root = new TreeNode<T>();  
            root.setOrganization("-1");  
            root.setOrganization_name("root");  
            root.setHigher_organization("");  
            root.getUnder_org().addAll(tops);  
        }       
        return root;  
    }
}  
