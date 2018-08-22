package com.supermarket.entity;

public class Products {
	private String pid;//供应商编号
	private String proName;//供应商名称
	
	public Products() {
		super();
	}
	public Products(String pid, String proName) {
		super();
		this.pid = pid;
		this.proName = proName;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	

}
