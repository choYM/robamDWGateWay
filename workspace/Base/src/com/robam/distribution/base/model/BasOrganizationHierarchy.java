package com.robam.distribution.base.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BasOrganizationHierarchy implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5999943187686437873L;
	private String status_code;
	private String requisition_no;
	private String requisition_date;
	private String change_type;
	private String organization_type;
	private String top_organization;
	private String version;
	private String valid_date;
	private String invalid_date;
	private String data_owner;
	private String data_own_department;
	private String data_created_by;
	private String data_created_department;
	private Date data_create_date;
	private String data_modified_by;
	private Date last_modified_date;
	private String data_confirmed_by;
	private Date data_confirmed_date;
	private String top_organization_name;
	private String language;
	private String operation_organization;
	private String operation_organization_name;
	
	private List<TreeNode<OrganizationHierarchy>> org_hierarchy;
	private Date query_date;
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getRequisition_no() {
		return requisition_no;
	}
	public void setRequisition_no(String requisition_no) {
		this.requisition_no = requisition_no;
	}
	public String getRequisition_date() {
		return requisition_date;
	}
	public void setRequisition_date(String requisition_date) {
		this.requisition_date = requisition_date;
	}
	public String getChange_type() {
		return change_type;
	}
	public void setChange_type(String change_type) {
		this.change_type = change_type;
	}
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
	public String getValid_date() {
		return valid_date;
	}
	public void setValid_date(String valid_date) {
		this.valid_date = valid_date;
	}
	public String getInvalid_date() {
		return invalid_date;
	}
	public void setInvalid_date(String invalid_date) {
		this.invalid_date = invalid_date;
	}
	public String getData_owner() {
		return data_owner;
	}
	public void setData_owner(String data_owner) {
		this.data_owner = data_owner;
	}
	public String getData_own_department() {
		return data_own_department;
	}
	public void setData_own_department(String data_own_department) {
		this.data_own_department = data_own_department;
	}
	public String getData_created_by() {
		return data_created_by;
	}
	public void setData_created_by(String data_created_by) {
		this.data_created_by = data_created_by;
	}
	public String getData_created_department() {
		return data_created_department;
	}
	public void setData_created_department(String data_created_department) {
		this.data_created_department = data_created_department;
	}
	public Date getData_create_date() {
		return data_create_date;
	}
	public void setData_create_date(Date data_create_date) {
		this.data_create_date = data_create_date;
	}
	public String getData_modified_by() {
		return data_modified_by;
	}
	public void setData_modified_by(String data_modified_by) {
		this.data_modified_by = data_modified_by;
	}
	public Date getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public String getData_confirmed_by() {
		return data_confirmed_by;
	}
	public void setData_confirmed_by(String data_confirmed_by) {
		this.data_confirmed_by = data_confirmed_by;
	}
	public Date getData_confirmed_date() {
		return data_confirmed_date;
	}
	public void setData_confirmed_date(Date data_confirmed_date) {
		this.data_confirmed_date = data_confirmed_date;
	}
	public String getTop_organization_name() {
		return top_organization_name;
	}
	public void setTop_organization_name(String top_organization_name) {
		this.top_organization_name = top_organization_name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOperation_organization() {
		return operation_organization;
	}
	public void setOperation_organization(String operation_organization) {
		this.operation_organization = operation_organization;
	}
	public String getOperation_organization_name() {
		return operation_organization_name;
	}
	public void setOperation_organization_name(String operation_organization_name) {
		this.operation_organization_name = operation_organization_name;
	}
	public List<TreeNode<OrganizationHierarchy>> getOrg_hierarchy() {
		return org_hierarchy;
	}
	public void setOrg_hierarchy(List<TreeNode<OrganizationHierarchy>> org_hierarchy) {
		this.org_hierarchy = org_hierarchy;
	}
	public Date getQuery_date() {
		return query_date;
	}
	public void setQuery_date(Date query_date) {
		this.query_date = query_date;
	}
	
}
