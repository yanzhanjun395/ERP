package com.supermarket.entity;

import java.util.Date;

/**
 * 用户实体类
 * @author 孙文刚
 *
 */
public class User {
	private String userCode; //用户编码
	private String userName;  //用户名
	private String userPassword;  //密码
	private String gender;  //性别
	private Date birthday;  //出生年月日
	private double age; //用户年龄
	private String phone;  //联系方式
	private String address;  //地址
	private int userType;  //用户类型
	private String createBy; //创建者
	private Date creationDate;  //创建时间
	private String modifyBy;  //更新者
	private Date modifyDate;  //更新时间
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public User(String userCode, String userName, String userPassword,
			String gender, Date birthday, double age, String phone,
			String address, int userType, String createBy, Date creationDate,
			String modifyBy, Date modifyDate) {
		super();
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.userType = userType;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
