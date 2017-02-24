package com.robam.distribution.base.model;

import java.util.Date;
import java.util.List;

/**
 * StoresDataAccess entity. @author MyEclipse Persistence Tools
 */

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class StoresDataAccess implements java.io.Serializable {

	// Fields
	
	private String requisition_no;
	private String communication_no ;
	private String language;
	private String operation_organization;
	private String application_organization;
	private String requisition_date;
	private String requisition_type;
	private String organization;
	private String tax_code;
	private String is_legal_person;
	private String organization_simple_code;
	private String country_region;
	private String listed_company_no;
	private String exclusive_national_functions;
	private String date_display_format;
	private String main_currency_no;
	private String legal_person_name;
	private String time_zone_no;
	private String business_registration_no;
	private String legal_representative;
	private String register_capital;
	private String number_amount_format;
	private String customer_vendor_no;
	private String store_state;
	private String industry_type;
	private String opening_date;
	private String closing_date;
	private Double store_area;
	private String sales_area;
	private String other_attribute1;
	private String other_attribute2;
	private String other_attribute3;
	private String other_attribute4;
	private String other_attribute5;
	private String other_attribute6;
	private String other_attribute7;
	private String other_attribute8;
	private String other_attribute9;
	private String other_attribute10;
	private String status_code;
	private String data_owner;
	private String data_owned_department;
	private String data_created_by;
	private String data_created_department;
	private Date data_created_date;
	private String data_modified_by;
	private Date last_modified_date;
	private String data_confirmed_by;
	private Date data_confirmed_date;
	private String valid;
	private String belonged_organization;
	private String belonged_channel;
	private String reference_table_no;
	private String province;
	private String city;
	private String county_district;
	private String street;
	private String detailed_address;
	private String postcode;
	private String contact;
	private String contact_no;
	private String mobile_no;
	private String email;
	private String applicant;
	private String requested_department;
	private Integer counter_quantity;
	private String organization_name;
	private String organization_full_name;
	private String operation_organization_name;
	private String applicant_name;
	private String requested_department_name;
	private String belonged_organization_name;
	private String belonged_channel_name;
	private String sales_area_name;
	private String country_region_name;
	private String province_name;
	private String city_name;
	private String county_district_name;
	private String street_name;
	private String legal_person;
	private String time_zone_description;
	private String reference_table_description;
	private String main_currency_description;
	private String customer_vendor_name;
	private String other_attribute1_description;
	private String other_attribute2_description;
	private String other_attribute3_description;
	private String other_attribute4_description;
	private String other_attribute5_description;
	private String other_attribute6_description;
	private String other_attribute7_description;
	private String other_attribute8_description;
	private String other_attribute9_description;
	private String other_attribute10_description;
	private String is_main_communication;
	private String communication_type;
	private String brief_description;
	private String communication_content;
	
	private Integer startIndex;
    private Integer pageSize;
    
    private List<StoresDataAccess> information_list;
    public List<StoresDataAccess> getInformation_list() {
		return information_list;
	}

	public void setInformation_list(List<StoresDataAccess> information_list) {
		this.information_list = information_list;
	}

	private List<Address> contact_address_list;

	// Constructors

	public List<Address> getContact_address_list() {
		return contact_address_list;
	}

	public void setContact_address_list(List<Address> contact_address_list) {
		this.contact_address_list = contact_address_list;
	}

	/** default constructor */
	public StoresDataAccess() {
	}

	public String getRequisition_no() {
		return requisition_no;
	}

	public void setRequisition_no(String requisition_no) {
		this.requisition_no = requisition_no;
	}

	public String getCommunication_no() {
		return communication_no;
	}

	public void setCommunication_no(String communication_no) {
		this.communication_no = communication_no;
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


	public String getApplication_organization() {
		return application_organization;
	}

	public void setApplication_organization(String application_organization) {
		this.application_organization = application_organization;
	}

	public String getRequisition_date() {
		return requisition_date;
	}

	public void setRequisition_date(String requisition_date) {
		this.requisition_date = requisition_date;
	}

	public String getRequisition_type() {
		return requisition_type;
	}

	public void setRequisition_type(String requisition_type) {
		this.requisition_type = requisition_type;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getTax_code() {
		return tax_code;
	}

	public void setTax_code(String tax_code) {
		this.tax_code = tax_code;
	}

	public String getIs_legal_person() {
		return is_legal_person;
	}

	public void setIs_legal_person(String is_legal_person) {
		this.is_legal_person = is_legal_person;
	}

	public String getOrganization_simple_code() {
		return organization_simple_code;
	}

	public void setOrganization_simple_code(String organization_simple_code) {
		this.organization_simple_code = organization_simple_code;
	}

	public String getCountry_region() {
		return country_region;
	}

	public void setCountry_region(String country_region) {
		this.country_region = country_region;
	}

	public String getListed_company_no() {
		return listed_company_no;
	}

	public void setListed_company_no(String listed_company_no) {
		this.listed_company_no = listed_company_no;
	}

	public String getExclusive_national_functions() {
		return exclusive_national_functions;
	}

	public void setExclusive_national_functions(String exclusive_national_functions) {
		this.exclusive_national_functions = exclusive_national_functions;
	}

	public String getDate_display_format() {
		return date_display_format;
	}

	public void setDate_display_format(String date_display_format) {
		this.date_display_format = date_display_format;
	}

	public String getMain_currency_no() {
		return main_currency_no;
	}

	public void setMain_currency_no(String main_currency_no) {
		this.main_currency_no = main_currency_no;
	}

	public String getLegal_person_name() {
		return legal_person_name;
	}

	public void setLegal_person_name(String legal_person_name) {
		this.legal_person_name = legal_person_name;
	}

	public String getTime_zone_no() {
		return time_zone_no;
	}

	public void setTime_zone_no(String time_zone_no) {
		this.time_zone_no = time_zone_no;
	}

	public String getBusiness_registration_no() {
		return business_registration_no;
	}

	public void setBusiness_registration_no(String business_registration_no) {
		this.business_registration_no = business_registration_no;
	}

	public String getLegal_representative() {
		return legal_representative;
	}

	public void setLegal_representative(String legal_representative) {
		this.legal_representative = legal_representative;
	}

	public String getRegister_capital() {
		return register_capital;
	}

	public void setRegister_capital(String register_capital) {
		this.register_capital = register_capital;
	}

	public String getNumber_amount_format() {
		return number_amount_format;
	}

	public void setNumber_amount_format(String number_amount_format) {
		this.number_amount_format = number_amount_format;
	}

	public String getCustomer_vendor_no() {
		return customer_vendor_no;
	}

	public void setCustomer_vendor_no(String customer_vendor_no) {
		this.customer_vendor_no = customer_vendor_no;
	}

	public String getStore_state() {
		return store_state;
	}

	public void setStore_state(String store_state) {
		this.store_state = store_state;
	}

	public String getIndustry_type() {
		return industry_type;
	}

	public void setIndustry_type(String industry_type) {
		this.industry_type = industry_type;
	}

	public String getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(String opening_date) {
		this.opening_date = opening_date;
	}

	public String getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date;
	}

	public Double getStore_area() {
		return store_area;
	}

	public void setStore_area(Double store_area) {
		this.store_area = store_area;
	}

	public String getSales_area() {
		return sales_area;
	}

	public void setSales_area(String sales_area) {
		this.sales_area = sales_area;
	}

	public String getOther_attribute1() {
		return other_attribute1;
	}

	public void setOther_attribute1(String other_attribute1) {
		this.other_attribute1 = other_attribute1;
	}

	public String getOther_attribute2() {
		return other_attribute2;
	}

	public void setOther_attribute2(String other_attribute2) {
		this.other_attribute2 = other_attribute2;
	}

	public String getOther_attribute3() {
		return other_attribute3;
	}

	public void setOther_attribute3(String other_attribute3) {
		this.other_attribute3 = other_attribute3;
	}

	public String getOther_attribute4() {
		return other_attribute4;
	}

	public void setOther_attribute4(String other_attribute4) {
		this.other_attribute4 = other_attribute4;
	}

	public String getOther_attribute5() {
		return other_attribute5;
	}

	public void setOther_attribute5(String other_attribute5) {
		this.other_attribute5 = other_attribute5;
	}

	public String getOther_attribute6() {
		return other_attribute6;
	}

	public void setOther_attribute6(String other_attribute6) {
		this.other_attribute6 = other_attribute6;
	}

	public String getOther_attribute7() {
		return other_attribute7;
	}

	public void setOther_attribute7(String other_attribute7) {
		this.other_attribute7 = other_attribute7;
	}

	public String getOther_attribute8() {
		return other_attribute8;
	}

	public void setOther_attribute8(String other_attribute8) {
		this.other_attribute8 = other_attribute8;
	}

	public String getOther_attribute9() {
		return other_attribute9;
	}

	public void setOther_attribute9(String other_attribute9) {
		this.other_attribute9 = other_attribute9;
	}

	public String getOther_attribute10() {
		return other_attribute10;
	}

	public void setOther_attribute10(String other_attribute10) {
		this.other_attribute10 = other_attribute10;
	}

	public String getStatus_code() {
		return status_code;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public String getData_owner() {
		return data_owner;
	}

	public void setData_owner(String data_owner) {
		this.data_owner = data_owner;
	}


	public String getData_owned_department() {
		return data_owned_department;
	}

	public void setData_owned_department(String data_owned_department) {
		this.data_owned_department = data_owned_department;
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

	public Date getData_created_date() {
		return data_created_date;
	}

	public void setData_created_date(Date data_created_date) {
		this.data_created_date = data_created_date;
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

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getBelonged_organization() {
		return belonged_organization;
	}

	public void setBelonged_organization(String belonged_organization) {
		this.belonged_organization = belonged_organization;
	}

	public String getBelonged_channel() {
		return belonged_channel;
	}

	public void setBelonged_channel(String belonged_channel) {
		this.belonged_channel = belonged_channel;
	}

	public String getReference_table_no() {
		return reference_table_no;
	}

	public void setReference_table_no(String reference_table_no) {
		this.reference_table_no = reference_table_no;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty_district() {
		return county_district;
	}

	public void setCounty_district(String county_district) {
		this.county_district = county_district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDetailed_address() {
		return detailed_address;
	}

	public void setDetailed_address(String detailed_address) {
		this.detailed_address = detailed_address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getRequested_department() {
		return requested_department;
	}

	public void setRequested_department(String requested_department) {
		this.requested_department = requested_department;
	}

	public Integer getCounter_quantity() {
		return counter_quantity;
	}

	public void setCounter_quantity(Integer counter_quantity) {
		this.counter_quantity = counter_quantity;
	}

	public String getOrganization_name() {
		return organization_name;
	}

	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	public String getOrganization_full_name() {
		return organization_full_name;
	}

	public void setOrganization_full_name(String organization_full_name) {
		this.organization_full_name = organization_full_name;
	}

	public String getOperation_organization_name() {
		return operation_organization_name;
	}

	public void setOperation_organization_name(String operation_organization_name) {
		this.operation_organization_name = operation_organization_name;
	}

	public String getApplicant_name() {
		return applicant_name;
	}

	public void setApplicant_name(String applicant_name) {
		this.applicant_name = applicant_name;
	}

	public String getRequested_department_name() {
		return requested_department_name;
	}

	public void setRequested_department_name(String requested_department_name) {
		this.requested_department_name = requested_department_name;
	}

	public String getBelonged_organization_name() {
		return belonged_organization_name;
	}

	public void setBelonged_organization_name(String belonged_organization_name) {
		this.belonged_organization_name = belonged_organization_name;
	}

	public String getBelonged_channel_name() {
		return belonged_channel_name;
	}

	public void setBelonged_channel_name(String belonged_channel_name) {
		this.belonged_channel_name = belonged_channel_name;
	}

	public String getSales_area_name() {
		return sales_area_name;
	}

	public void setSales_area_name(String sales_area_name) {
		this.sales_area_name = sales_area_name;
	}

	public String getCountry_region_name() {
		return country_region_name;
	}

	public void setCountry_region_name(String country_region_name) {
		this.country_region_name = country_region_name;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getCounty_district_name() {
		return county_district_name;
	}

	public void setCounty_district_name(String county_district_name) {
		this.county_district_name = county_district_name;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public String getLegal_person() {
		return legal_person;
	}

	public void setLegal_person(String legal_person) {
		this.legal_person = legal_person;
	}

	public String getTime_zone_description() {
		return time_zone_description;
	}

	public void setTime_zone_description(String time_zone_description) {
		this.time_zone_description = time_zone_description;
	}

	public String getReference_table_description() {
		return reference_table_description;
	}

	public void setReference_table_description(String reference_table_description) {
		this.reference_table_description = reference_table_description;
	}

	public String getMain_currency_description() {
		return main_currency_description;
	}

	public void setMain_currency_description(String main_currency_description) {
		this.main_currency_description = main_currency_description;
	}

	public String getCustomer_vendor_name() {
		return customer_vendor_name;
	}

	public void setCustomer_vendor_name(String customer_vendor_name) {
		this.customer_vendor_name = customer_vendor_name;
	}

	public String getOther_attribute1_description() {
		return other_attribute1_description;
	}

	public void setOther_attribute1_description(String other_attribute1_description) {
		this.other_attribute1_description = other_attribute1_description;
	}

	public String getOther_attribute2_description() {
		return other_attribute2_description;
	}

	public void setOther_attribute2_description(String other_attribute2_description) {
		this.other_attribute2_description = other_attribute2_description;
	}

	public String getOther_attribute3_description() {
		return other_attribute3_description;
	}

	public void setOther_attribute3_description(String other_attribute3_description) {
		this.other_attribute3_description = other_attribute3_description;
	}

	public String getOther_attribute4_description() {
		return other_attribute4_description;
	}

	public void setOther_attribute4_description(String other_attribute4_description) {
		this.other_attribute4_description = other_attribute4_description;
	}

	public String getOther_attribute5_description() {
		return other_attribute5_description;
	}

	public void setOther_attribute5_description(String other_attribute5_description) {
		this.other_attribute5_description = other_attribute5_description;
	}

	public String getOther_attribute6_description() {
		return other_attribute6_description;
	}

	public void setOther_attribute6_description(String other_attribute6_description) {
		this.other_attribute6_description = other_attribute6_description;
	}

	public String getOther_attribute7_description() {
		return other_attribute7_description;
	}

	public void setOther_attribute7_description(String other_attribute7_description) {
		this.other_attribute7_description = other_attribute7_description;
	}

	public String getOther_attribute8_description() {
		return other_attribute8_description;
	}

	public void setOther_attribute8_description(String other_attribute8_description) {
		this.other_attribute8_description = other_attribute8_description;
	}

	public String getOther_attribute9_description() {
		return other_attribute9_description;
	}

	public void setOther_attribute9_description(String other_attribute9_description) {
		this.other_attribute9_description = other_attribute9_description;
	}

	public String getOther_attribute10_description() {
		return other_attribute10_description;
	}

	public void setOther_attribute10_description(String other_attribute10_description) {
		this.other_attribute10_description = other_attribute10_description;
	}

	

	public String getIs_main_communication() {
		return is_main_communication;
	}

	public void setIs_main_communication(String is_main_communication) {
		this.is_main_communication = is_main_communication;
	}

	public String getCommunication_type() {
		return communication_type;
	}

	public void setCommunication_type(String communication_type) {
		this.communication_type = communication_type;
	}

	public String getBrief_description() {
		return brief_description;
	}

	public void setBrief_description(String brief_description) {
		this.brief_description = brief_description;
	}

	public String getCommunication_content() {
		return communication_content;
	}

	public void setCommunication_content(String communication_content) {
		this.communication_content = communication_content;
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