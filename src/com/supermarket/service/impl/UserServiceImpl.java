package com.supermarket.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.supermarket.dao.UserDao;
import com.supermarket.dao.impl.UserDaoImpl;
import com.supermarket.entity.User;
import com.supermarket.service.UserService;
import com.supermarket.until.BaseDao;

/**
 * 业务逻辑实现类
 * @author 孙文刚
 *
 */
public class UserServiceImpl extends BaseDao implements UserService {
	UserDao dao = new UserDaoImpl();
	
	/**
	 * 用户实现方法
	 */
	@Override
	public User login(String username, String password) {
		
		return dao.checkUser(username, password);
	}
	/**
	 * 通过用户名修改一个新密码；
	 * @param name
	 * @param password
	 * @return
	 */
	@Override
	public int updatePass(String name, String password) {
		
		return dao.updatePass(name, password);
	}
	/**
	 * 通过用户名得到用户信息，显示用户详情
	 * @param username
	 * @return
	 */
	@Override
	public User userSelcet(String username) {
		return dao.userSelcet(username);
	}
	/**
	 * 得到所有用户信息,搜索的分页显示；
	 * @return
	 */
	@Override
	public List<User> getAllUser(int pageIndex,int pageSize,String username) {
		
		return dao.getAllUser(pageIndex, pageSize, username);
	}
	
	//得到所有用户记录
	@Override
	public int getAllRocord(int pageSize) {
		int record=dao.getUserRecord();
		int page=record/pageSize;
		
		return record%pageSize==0?page:page+1;
	}
	
	
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
	@Override
	public int updateUser(String newname, String birthday, String gender,
			String phone, String address, int usertype, String userCode) {
		return dao.updateUser(newname, birthday, gender, phone, address, usertype, userCode);
	}
	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	@Override
	public int deleteUser(String username) {
		return dao.removeUser(username);
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public int addUser(String userId, String uuser, String userpassword,
			String sex, String data, String phone, String userAddress,
			double usertype) {
		return dao.addUser(userId,uuser,userpassword,sex,data,phone,userAddress,usertype);
	}
	

}
