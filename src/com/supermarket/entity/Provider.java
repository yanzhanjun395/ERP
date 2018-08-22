package com.supermarket.entity;

import java.util.Date;

public class Provider {
	private String proCode;  // '供应商编码',---设为主键
	private String proName; // '供应商名称',
	private String proDesc;  //'供应商详细描述',
	private String proContact;  // '供应商联系人',
	private String proPhone;  // '联系电话',
	private String proAddress; // '地址',
	private String proFax;  //'传真',
	private int createdBy;  // '创建者（userId）',
	private Date creationDate;  // '创建时间',
	private Date modifyDate; //'更新时间',
	private int modifyBy;  // '更新者（userId）'
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
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Provider(String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, int createdBy, Date creationDate, Date modifyDate,
			int modifyBy) {
		super();
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
	}
	public Provider() {
		super();
	}
	
	
}
