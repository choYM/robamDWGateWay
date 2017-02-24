package com.robam.distribution.base.model;

import java.io.Serializable;
/**
 * 组织层级实体类
 * @author gelf
 *
 */
public class OrganizationHierarchy implements Serializable {

	private static final long serialVersionUID = 1L;
	//组织编号
	private String organization;
	//上级组织编号
	private String higher_organization;
	//组织名称
	private String organization_name;
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
}
