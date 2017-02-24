package com.robam.distribution.base.model;

import java.util.Date;
import java.util.List;

/**
 * BasOrganizationHierarchy2 entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class BasOrganizationHierarchy2 implements java.io.Serializable {

	// Fields

	private String organization_type;
	private String top_organization;
	private String version;
	private String organization;
	private String higher_organization;
	private Date valid_date;
	private Date invalid_date;
	private String requisition_no;
	private String top_organization_name;
	private String organization_name;
	private String higher_organization_name;
	List<BasOrganizationHierarchy2> under_org;
	public String getOrganization_type() {
		return organization_type;
	}
	public void setOrganization_type(String organization_type) {
		this.organization_type = organization_type;
	}
	public String getTop_organization() {
		return top_organization;
	}
	public void setTop_organization(String top_organization) {
		this.top_organization = top_organization;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
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
	public Date getValid_date() {
		return valid_date;
	}
	public void setValid_date(Date valid_date) {
		this.valid_date = valid_date;
	}
	public Date getInvalid_date() {
		return invalid_date;
	}
	public void setInvalid_date(Date invalid_date) {
		this.invalid_date = invalid_date;
	}
	public String getRequisition_no() {
		return requisition_no;
	}
	public void setRequisition_no(String requisition_no) {
		this.requisition_no = requisition_no;
	}
	public String getTop_organization_name() {
		return top_organization_name;
	}
	public void setTop_organization_name(String top_organization_name) {
		this.top_organization_name = top_organization_name;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	public String getHigher_organization_name() {
		return higher_organization_name;
	}
	public void setHigher_organization_name(String higher_organization_name) {
		this.higher_organization_name = higher_organization_name;
	}
	public List<BasOrganizationHierarchy2> getUnder_org() {
		return under_org;
	}
	public void setUnder_org(List<BasOrganizationHierarchy2> under_org) {
		this.under_org = under_org;
	}
	
}