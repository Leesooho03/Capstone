package com.hy.capstone.company;

import java.io.Serializable;

import com.hy.capstone.PagingVO;

public class CompanyVO extends PagingVO implements Serializable{

	private String company_id = "";
	private String company_name = "";
	private String company_address = "";
	private String company_ceo = "";
	private String company_tel = "";
	private String company_email = "";
	private String reg_date = "";
	private String useyn = "";
	private String id = "";
	
	
	
	
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_ceo() {
		return company_ceo;
	}
	public void setCompany_ceo(String company_ceo) {
		this.company_ceo = company_ceo;
	}
	public String getCompany_tel() {
		return company_tel;
	}
	public void setCompany_tel(String company_tel) {
		this.company_tel = company_tel;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getUseyn() {
		return useyn;
	}
	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
