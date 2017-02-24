package com.robam.distribution.base.model;

import java.util.Date;

public class BasSingleTax {
	
	private String data_owner;
	private String data_own_department;
	private String data_inputer;
	private String data_input_department;
	private Date data_create_date;
	private String data_modificator;
	private Date recently_modify_date;
	private String status_code;
	private String reference_table;
	private String tax_code;
	private String tax_property;
	private String is_tax;
	private Double tax_rate;
	private String formula_no;
	private String ke_tax;
	private String tax_application;
	private String print_invoice_vat;
	private Double fixed_tax;
	private String language;
	private String tax_name;
	private String reference_table_description;
	
	private Integer startIndex;
	private Integer pageSize;
 
	public BasSingleTax() {
		super();
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

	public String getData_inputer() {
		return data_inputer;
	}

	public void setData_inputer(String data_inputer) {
		this.data_inputer = data_inputer;
	}

	public String getData_input_department() {
		return data_input_department;
	}

	public void setData_input_department(String data_input_department) {
		this.data_input_department = data_input_department;
	}

	public Date getData_create_date() {
		return data_create_date;
	}

	public void setData_create_date(Date data_create_date) {
		this.data_create_date = data_create_date;
	}

	public String getData_modificator() {
		return data_modificator;
	}

	public void setData_modificator(String data_modificator) {
		this.data_modificator = data_modificator;
	}

	public Date getRecently_modify_date() {
		return recently_modify_date;
	}

	public void setRecently_modify_date(Date recently_modify_date) {
		this.recently_modify_date = recently_modify_date;
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getReference_table() {
		return reference_table;
	}

	public void setReference_table(String reference_table) {
		this.reference_table = reference_table;
	}

	public String getTax_code() {
		return tax_code;
	}

	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}

	public String getTax_property() {
		return tax_property;
	}

	public void setTax_property(String tax_property) {
		this.tax_property = tax_property;
	}

	public String getIs_tax() {
		return is_tax;
	}

	public void setIs_tax(String is_tax) {
		this.is_tax = is_tax;
	}

	public Double getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(Double tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getFormula_no() {
		return formula_no;
	}

	public void setFormula_no(String formula_no) {
		this.formula_no = formula_no;
	}

	public String getKe_tax() {
		return ke_tax;
	}

	public void setKe_tax(String ke_tax) {
		this.ke_tax = ke_tax;
	}

	public String getTax_application() {
		return tax_application;
	}

	public void setTax_application(String tax_application) {
		this.tax_application = tax_application;
	}

	public String getPrint_invoice_vat() {
		return print_invoice_vat;
	}

	public void setPrint_invoice_vat(String print_invoice_vat) {
		this.print_invoice_vat = print_invoice_vat;
	}

	public Double getFixed_tax() {
		return fixed_tax;
	}

	public void setFixed_tax(Double fixed_tax) {
		this.fixed_tax = fixed_tax;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTax_name() {
		return tax_name;
	}

	public void setTax_name(String tax_name) {
		this.tax_name = tax_name;
	}

	public String getReference_table_description() {
		return reference_table_description;
	}

	public void setReference_table_description(String reference_table_description) {
		this.reference_table_description = reference_table_description;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
