package com.supermarket.dao;

import java.util.List;

import com.supermarket.entity.User;

/**
 * 存储用户信息接口
 * @author 孙文刚
 *
 */
public interface UserDao {
	//通过用户名和密码得到一个用户
	public User checkUser(String username,String password);
	
	/**
	 * 根据用户名修改用户密码；
	 * 
	 */
	
	public int updatePass(String name,String password);
	
	/**
	 * 分页或查询得到用户列表信息，翻页
	 */
	public List<User> getAllUser(int pageIndex,int pageSize,String username);
	
	/**
	 * 得到所有用户的条数
	 */
	public int getUserRecord();
	
	
	/**
	 * 通过用户名得到一个user对象显示用户详情；
	 * @param username
	 * @return
	 */
	public User userSelcet(String username);
	
	/**
	 * 根据用户编号修改用户信息；
	 * @param username
	 * @return
	 */
	public int updateUser(String newname,String birthday,String gender,
			String phone, String address,int usertype,String userCode);
	
	 
	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	public int removeUser(String username);
	
	/**
	 * 添加用户
	 */
	public int addUser(String userId,String uuser,String userpassword
			,String sex,String data,String phone,String userAddress
			,double usertype
			);
	
	
}
