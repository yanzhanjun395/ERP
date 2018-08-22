package com.supermarket.entity;

import java.util.Date;

public class ShoppingBill {

	  private int bid;//主键ID',
	  private String billcode;
	  //private String billCode;//账单编码',
	  private String productName;//商品名称',
	  private String productDesc;//商品描述',
	  private String productUnit;//商品单位',
	  private  double productCount;//商品数量',
	  private double totalPrice;//商品总额',
	  private int isPayment;//'是否支付（0：未支付 1：已支付）',
	  private int createdBy;//创建者（userId）',
	  private Date creationDate;//创建时间',
	  private int modifyBy;//更新者（userId）',
	  private Date modifyDate;//更新时间',
	  private String pname;
	  private String proname;
	  private String pid;


	public ShoppingBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoppingBill(int bid, String billcode, String productName,
			String productDesc, String productUnit, double productCount,
			double totalPrice, int isPayment, int createdBy, Date creationDate,
			int modifyBy, Date modifyDate, String pname, String proname,String pid) {
		super();
		
		this.bid = bid;
		this.billcode = billcode;
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
		this.pname = pname;
		this.proname = proname;
		this.pid=pid;
		
	}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBillcode() {
		return billcode;
	}
	public void setBillcode(String billcode) {
		this.billcode = billcode;
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
	public double getProductCount() {
		return productCount;
	}
	public void setProductCount(double productCount) {
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
	  
	

}
