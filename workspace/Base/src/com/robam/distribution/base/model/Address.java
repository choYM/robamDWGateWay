package com.robam.distribution.base.model;

import java.io.Serializable;
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6444370397362077610L;
	private String status_code;//状态码
	private String address_no;//联络地址编号(不显示)
	private String address_type;//地址类型（默认2）
	private String brief_description;//简要说明
	private String country_region;//国家地区
	private String postcode;//邮政编号
	private String province;//省份
	private String city;//城市
	private String county_district;//县区
	private String street;//街道
	private String detailed_address;//详细地址
	private String language;//语言别
	private String country_region_name;//国家地区说明
	private String province_name;//省别说明
	private String city_name;//城市说明
	private String county_district_name;//县区说明
	private String street_name;//街道说明
	private String requisition_no;//申请单号
	private String primary_address;
	public String getPrimary_address() {
		return primary_address;
	}
	public void setPrimary_address(String primary_address) {
		this.primary_address = primary_address;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getAddress_no() {
		return address_no;
	}
	public void setAddress_no(String address_no) {
		this.address_no = address_no;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public String getBrief_description() {
		return brief_description;
	}
	public void setBrief_description(String brief_description) {
		this.brief_description = brief_description;
	}
	public String getCountry_region() {
		return country_region;
	}
	public void setCountry_region(String country_region) {
		this.country_region = country_region;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
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
	public String getRequisition_no() {
		return requisition_no;
	}
	public void setRequisition_no(String requisition_no) {
		this.requisition_no = requisition_no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}