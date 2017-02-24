package com.robam.distribution.base.model;

import java.util.Date;

public class BasSitePaymentType {
	private String status_code;
	private String operating_site;
	private String payment_type_code;
	private String payment_currency_code;
	private String is_thirdparty_collection;
	private String collection_agency;
	private Double collection_fee_rate;
	private Double collection_fee_amount;
	private String is_collection_billing;
	private String is_preset_payment;
	private String corresponding_payment_code;
	private String is_discount_receivables;
	private String is_single_use;
	private Double enter_min_number;
	private String refundable;
	private String can_give_change;
	private String can_overcharge;
	private String data_owner;
	private String data_owner_dept;
	private String data_created_by;
	private String department;
	private Date data_created_date;
	private String modified_by;
	private Date last_modified_date;
	private String corresponding_bank_account;
	private Double standard_fee_rate;
	private String coupons_recogniztion_method;
	private Double tax_deduction_seq;
	private String account_current_site;
	private String is_collection;
	private String collecting_site;
	private Double card_upper_amount;
	private Double upper_limit_charge;
	private String cashier_check_payment;
	private String processing_belonged_dept;
	private String language;
	private String operating_site_name;
	private String payment_type_name;
	private String payment_currency_name;
	private String collection_agency_name;
	private String corresponding_payment_name;
	private String bank_account_name;
	private String collecting_site_name;
	private String belonged_dept_name;
	
	private Integer startIndex;
	private Integer pageSize;
	
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

	public BasSitePaymentType() {
		super();
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getOperating_site() {
		return operating_site;
	}

	public void setOperating_site(String operating_site) {
		this.operating_site = operating_site;
	}

	public String getPayment_type_code() {
		return payment_type_code;
	}

	public void setPayment_type_code(String payment_type_code) {
		this.payment_type_code = payment_type_code;
	}

	public String getPayment_currency_code() {
		return payment_currency_code;
	}

	public void setPayment_currency_code(String payment_currency_code) {
		this.payment_currency_code = payment_currency_code;
	}

	public String getIs_thirdparty_collection() {
		return is_thirdparty_collection;
	}

	public void setIs_thirdparty_collection(String is_thirdparty_collection) {
		this.is_thirdparty_collection = is_thirdparty_collection;
	}

	public String getCollection_agency() {
		return collection_agency;
	}

	public void setCollection_agency(String collection_agency) {
		this.collection_agency = collection_agency;
	}

	public Double getCollection_fee_rate() {
		return collection_fee_rate;
	}

	public void setCollection_fee_rate(Double collection_fee_rate) {
		this.collection_fee_rate = collection_fee_rate;
	}

	public Double getCollection_fee_amount() {
		return collection_fee_amount;
	}

	public void setCollection_fee_amount(Double collection_fee_amount) {
		this.collection_fee_amount = collection_fee_amount;
	}

	public String getIs_collection_billing() {
		return is_collection_billing;
	}

	public void setIs_collection_billing(String is_collection_billing) {
		this.is_collection_billing = is_collection_billing;
	}

	public String getIs_preset_payment() {
		return is_preset_payment;
	}

	public void setIs_preset_payment(String is_preset_payment) {
		this.is_preset_payment = is_preset_payment;
	}

	public String getCorresponding_payment_code() {
		return corresponding_payment_code;
	}

	public void setCorresponding_payment_code(String corresponding_payment_code) {
		this.corresponding_payment_code = corresponding_payment_code;
	}

	public String getIs_discount_receivables() {
		return is_discount_receivables;
	}

	public void setIs_discount_receivables(String is_discount_receivables) {
		this.is_discount_receivables = is_discount_receivables;
	}

	public String getIs_single_use() {
		return is_single_use;
	}

	public void setIs_single_use(String is_single_use) {
		this.is_single_use = is_single_use;
	}

	public Double getEnter_min_number() {
		return enter_min_number;
	}

	public void setEnter_min_number(Double enter_min_number) {
		this.enter_min_number = enter_min_number;
	}

	public Double getTax_deduction_seq() {
		return tax_deduction_seq;
	}

	public void setTax_deduction_seq(Double tax_deduction_seq) {
		this.tax_deduction_seq = tax_deduction_seq;
	}

	public String getRefundable() {
		return refundable;
	}

	public void setRefundable(String refundable) {
		this.refundable = refundable;
	}

	public String getCan_give_change() {
		return can_give_change;
	}

	public void setCan_give_change(String can_give_change) {
		this.can_give_change = can_give_change;
	}

	public String getCan_overcharge() {
		return can_overcharge;
	}

	public void setCan_overcharge(String can_overcharge) {
		this.can_overcharge = can_overcharge;
	}

	public String getData_owner() {
		return data_owner;
	}

	public void setData_owner(String data_owner) {
		this.data_owner = data_owner;
	}

	public String getData_owner_dept() {
		return data_owner_dept;
	}

	public void setData_owner_dept(String data_owner_dept) {
		this.data_owner_dept = data_owner_dept;
	}

	public String getData_created_by() {
		return data_created_by;
	}

	public void setData_created_by(String data_created_by) {
		this.data_created_by = data_created_by;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getData_created_date() {
		return data_created_date;
	}

	public void setData_created_date(Date data_created_date) {
		this.data_created_date = data_created_date;
	}

	public String getModified_by() {
		return modified_by;
	}

	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}

	public Date getLast_modified_date() {
		return last_modified_date;
	}

	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}

	public String getCorresponding_bank_account() {
		return corresponding_bank_account;
	}

	public void setCorresponding_bank_account(String corresponding_bank_account) {
		this.corresponding_bank_account = corresponding_bank_account;
	}

	public Double getStandard_fee_rate() {
		return standard_fee_rate;
	}

	public void setStandard_fee_rate(Double standard_fee_rate) {
		this.standard_fee_rate = standard_fee_rate;
	}

	public String getCoupons_recogniztion_method() {
		return coupons_recogniztion_method;
	}

	public void setCoupons_recogniztion_method(String coupons_recogniztion_method) {
		this.coupons_recogniztion_method = coupons_recogniztion_method;
	}


	public String getAccount_current_site() {
		return account_current_site;
	}

	public void setAccount_current_site(String account_current_site) {
		this.account_current_site = account_current_site;
	}

	public String getIs_collection() {
		return is_collection;
	}

	public void setIs_collection(String is_collection) {
		this.is_collection = is_collection;
	}

	public String getCollecting_site() {
		return collecting_site;
	}

	public void setCollecting_site(String collecting_site) {
		this.collecting_site = collecting_site;
	}

	public Double getCard_upper_amount() {
		return card_upper_amount;
	}

	public void setCard_upper_amount(Double card_upper_amount) {
		this.card_upper_amount = card_upper_amount;
	}

	public Double getUpper_limit_charge() {
		return upper_limit_charge;
	}

	public void setUpper_limit_charge(Double upper_limit_charge) {
		this.upper_limit_charge = upper_limit_charge;
	}

	public String getCashier_check_payment() {
		return cashier_check_payment;
	}

	public void setCashier_check_payment(String cashier_check_payment) {
		this.cashier_check_payment = cashier_check_payment;
	}

	public String getProcessing_belonged_dept() {
		return processing_belonged_dept;
	}

	public void setProcessing_belonged_dept(String processing_belonged_dept) {
		this.processing_belonged_dept = processing_belonged_dept;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOperating_site_name() {
		return operating_site_name;
	}

	public void setOperating_site_name(String operating_site_name) {
		this.operating_site_name = operating_site_name;
	}

	public String getPayment_type_name() {
		return payment_type_name;
	}

	public void setPayment_type_name(String payment_type_name) {
		this.payment_type_name = payment_type_name;
	}

	public String getPayment_currency_name() {
		return payment_currency_name;
	}

	public void setPayment_currency_name(String payment_currency_name) {
		this.payment_currency_name = payment_currency_name;
	}

	public String getCollection_agency_name() {
		return collection_agency_name;
	}

	public void setCollection_agency_name(String collection_agency_name) {
		this.collection_agency_name = collection_agency_name;
	}

	public String getCorresponding_payment_name() {
		return corresponding_payment_name;
	}

	public void setCorresponding_payment_name(String corresponding_payment_name) {
		this.corresponding_payment_name = corresponding_payment_name;
	}

	public String getBank_account_name() {
		return bank_account_name;
	}

	public void setBank_account_name(String bank_account_name) {
		this.bank_account_name = bank_account_name;
	}

	public String getCollecting_site_name() {
		return collecting_site_name;
	}

	public void setCollecting_site_name(String collecting_site_name) {
		this.collecting_site_name = collecting_site_name;
	}

	public String getBelonged_dept_name() {
		return belonged_dept_name;
	}

	public void setBelonged_dept_name(String belonged_dept_name) {
		this.belonged_dept_name = belonged_dept_name;
	}
	
}
