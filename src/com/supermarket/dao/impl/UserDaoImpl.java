package com.supermarket.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.supermarket.dao.UserDao;
import com.supermarket.entity.User;
import com.supermarket.until.BaseDao;
/**
 * 用户Dao实现类
 * @author 孙文刚
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao {
	
	/**
	 * 得到用户实现方法
	 */
	@Override
	public User checkUser(String username, String password) {
		User user=null;
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select userName,userPassword,gender,birthday, ");
			sql.append(" phone,address,userType from smbms_user where ");
			sql.append(" userName=? and userPassword=? ");
			
			//传递参数
			Object[] params= {username,password};
			ResultSet rs = this.executeQuery(sql.toString(), params);
			while(rs!=null && rs.next()){
				user =new User();
				user.setUserName(rs.getString(1));
				user.setUserPassword(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setBirthday(rs.getDate(4));
				user.setPhone(rs.getString(5));
				user.setAddress(rs.getString(6));
				user.setUserType(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closed();
		}
		return user;
	}

	/**
	 * 根据用户名修改用户密码；
	 * 
	 */
	@Override
	public int updatePass(String name, String password) {
		int row =0;
		StringBuffer sql=new StringBuffer();
		sql.append(" UPDATE smbms_user SET userpassword=? WHERE username = ? ");
		Object [] params={password,name};
		row=this.executeUpdate(sql.toString(), params);
		
		return row;
	}

	/**
	 * 通过用户名得到一个user对象,显示用户详情；
	 * @param username
	 * @return
	 */
	@Override
	public User userSelcet(String username) {
		User user=null;
		StringBuffer sql=new StringBuffer();
		sql.append(" SELECT usercode,username,gender ,birthday,phone,usertype FROM smbms_user   ");
		sql.append("  WHERE username=?  ");
		Object [] params={username};
		ResultSet	rs=this.executeQuery(sql.toString(), params);
		try {
			while(rs!=null && rs.next()){
				 user =new User();
				user.setUserCode(rs.getString(1));
				user.setUserName(rs.getString(2));
				//user.setUserPassword(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setBirthday(rs.getDate(4));
				user.setPhone(rs.getString(5));
				//user.set(rs.getString(6));
				user.setUserType(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 根据用户编号修改用户信息；
	 * @param username
	 * @return
	 */
	@Override
	public int updateUser(String newname, String birthday, String gender,
			String phone, String address, int usertype, String userCode) {
		int row=0;
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date bir=null;
		try {
			bir = sdf.parse(birthday);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*StringBuffer sql=new StringBuffer();
		sql.append( " UPDATE  smbms_user  SET username=? ,birthday=?,gender=?, ");
		sql.append("  phone=? ,address=?,usertype=? WHERE userCode=? ");*/
		Object [] params={newname,birthday,gender,phone,address,usertype,userCode};
		row=this.executeUpdate("{call smbms_updateuser(?,?,?,?,?,?,?)}", params);
		
		return row;
	}

	/**
	 * 删除用户
	 * @param username
	 * @return
	 */
	@Override
	public int removeUser(String username) {
		int row =0;
		StringBuffer sql=new StringBuffer();
		sql.append(" DELETE FROM smbms_user WHERE username=? ");
		Object[] params={username};
		row=this.executeUpdate(sql.toString(), params);
		
		return row;
	}

	/**
	 * 分页或查询得到用户列表信息，翻页
	 */
	@Override
	public List<User> getAllUser(int pageIndex, int pageSize,String username) {
		List<User> list =new ArrayList<User>();
		StringBuffer sbf=new StringBuffer();
		sbf.append(" SELECT usercode,username,gender,TRUNC((months_between(SYSDATE,birthday)/12),1),phone,usertype FROM ");
		sbf.append(" (SELECT smbms_user.*,row_number() OVER(ORDER BY usercode ASC) tn FROM smbms_user) ");
		sbf.append(" WHERE tn>? AND tn<=? AND username LIKE ? ");
		
		Object[] params={(pageIndex-1)*pageSize,pageIndex*pageSize,username};
		ResultSet rs = this.executeQuery(sbf.toString(), params);
		try {
			while(rs!=null&&rs.next()){
				User user=new User();
				user.setUserCode(rs.getString(1));
				user.setUserName(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setAge(rs.getDouble(4));
				user.setPhone(rs.getString(5));
				user.setUserType(rs.getInt(6));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 得到所有用户的条数
	 */
	@Override
	public int getUserRecord() {
		int recod=0;
		String sql="SELECT COUNT(1) FROM smbms_user";
		ResultSet rs = this.executeQuery(sql, null);
		try {
			while(rs!=null&&rs.next()){
					recod=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recod;
	}

	/**
	 * 添加用户
	 */
	@Override
	public int addUser(String userId, String uuser, String userpassword,
			String sex, String data, String phone, String userAddress,
			double usertype) {
		
		int row=0;
		StringBuffer sql=new StringBuffer();
		sql.append(" INSERT INTO smbms_user (usercode,username,userpassword,gender,birthday,phone,address,usertype) ");
		sql.append(" VALUES(?,?,?,?,to_date(?,'yyyy-dd-mm'),?,?,?) ");
		Object[] params={userId,uuser,userpassword,sex,data,phone,userAddress,usertype};
		 row=this.executeUpdate(sql.toString(), params);
		
		return row;
	}

}
