package com.robam.distribution.sys.model;

import java.io.Serializable;

/**
 * 登錄信息
 * @author falcon
 *
 */
public class LoginInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2391342196324528901L;

	private String id;
	private String name;
	private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String language;
	private String retailerCountry;
	
	public String getUserId() {
		
		return this.id;
	}
	
	public String getUserName() {
		
		return this.name;
	}
	
	public void setLanguage(String language) {
		
		this.language = language;
	}
	
	public String getLanguage() {
		
		return this.language;
	}
	
	public String getRetailerCountry() {
		
		return this.retailerCountry;
	}
}
