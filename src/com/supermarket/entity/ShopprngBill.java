package com.supermarket.entity;

import java.util.Date;

public class ShopprngBill {
	private String billCode;  //'定单编码',
	private String productName;// '商品名称',
	private String productDesc;//'商品描述',
	private String productUnit;//'商品单位',
	private int productCount;// '商品数量',
	private double totalPrice;// '商品总额',
	private int isPayment;//'是否支付（0：未支付 1：已支付）',
	private int createdBy;// '创建者（userId）',
	private Date creationDate; //'创建时间',
	private int modifyBy;// '更新者（userId）',
	private Date modifyDate;//'更新时间',
	private String proName;//供应商
	private int billId;
	private String pname;
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getBillCode() {
		return billCode;
	}
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
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
	public int getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(int modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public ShopprngBill(String billCode, String productName,
			String productDesc, String productUnit, int productCount,
			double totalPrice, int isPayment, int createdBy, Date creationDate,
			int modifyBy, Date modifyDate, String proName,int billId,String pname) {
		super();
		this.billCode = billCode;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productUnit = productUnit;
		this.productCount = productCount;
		this.totalPrice = totalPrice;
		this.isPayment = isPayment;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.proName = proName;
		this.billId=billId;
		this.pname=pname;
	}
	public ShopprngBill() {
		super();
		
	}
	
	
	
	
}
