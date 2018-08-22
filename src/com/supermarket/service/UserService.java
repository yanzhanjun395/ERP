package com.supermarket.service;

import java.util.List;

import com.supermarket.entity.User;

/**
 * 用户业务逻辑类
 * @author 孙文刚
 *
 */
public interface UserService {
	
	/**
	 * 根据用户名和密码得到用户
	 * @param username 用户名
	 * @param password 密码
	 * @return 一个用户
	 */
	public User login(String username,String password);
	
	/**
	 * 通过用户名修改一个新密码；
	 * @param name
	 * @param password
	 * @return
	 */
	public int updatePass(String name,String password);
	/**
	 * 通过用户名得到用户信息显示用户详情
	 * @param username
	 * @return
	 */
	public User userSelcet(String username);
	
	//得到所有用户记录
	public int getAllRocord(int pageSize);
	
	/**
	 * 得到所有用户信息,以及搜索的分页显示；
	 * @return
	 */
	public List<User> getAllUser(int pageIndex,int pageSize,String username);
	
	/**
	 * 修改通过用户ID
	 * @param newname
	 * @param birthday
	 * @param gender
	 * @param phone
	 * @param address
	 * @param usertype
	 * @param username
	 * @return
	 */
	public int updateUser(String newname,String  birthday,String gender,
			String phone, String address,int usertype,String userCode);
	
	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	
	public int deleteUser(String username);
	
	/**
	 * 添加用户
	 * @param userId
	 * @param uuser
	 * @param userpassword
	 * @param userRemi
	 * @param sex
	 * @param data
	 * @param userAddress
	 * @param userlei
	 * @return
	 */
	public int addUser(String userId,String uuser,String userpassword
			,String sex,String data,String phone,String userAddress
			,double usertype
			);
	
	
}
