package com.supermarket.entity;

import java.util.Date;

/**
 *
 * @ author 闫战军
 * @ version 
 * @ date 2017-2-22上午8:59:26
 *
 */
public class providers {

	private String proCode; //供应商编码
	private String proName;  //供应商姓名
	private String proDesc; //供应商详细的描述
	private String proContact; //供应商联系人
	private String proPhone; //供应商联系电话
	private String proAddress; //地址
	private String proFax;  //传真
	private String createBy; //创建者
	private String createDate; //创建时间
	private Date modifyDate; //更新时间
	private String modifyBy; //更新者
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProDesc() {
		return proDesc;
	}
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProPhone() {
		return proPhone;
	}
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	public String getProAddress() {
		return proAddress;
	}
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	public String getProFax() {
		return proFax;
	}
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public providers(String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, String createBy, String createDate, Date modifyDate,
			String modifyBy) {
		super();
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createBy = createBy;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
	}
	public providers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
