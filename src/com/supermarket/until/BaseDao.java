package com.supermarket.until;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @ author 闫战军
 * @ version 
 * @ date 2017-2-16上午11:06:46
 * Oracle数据库操作类
 */
public class BaseDao {
	protected Connection connection;
	protected PreparedStatement ps;
	protected ResultSet result;
	
	//建立链接
	public Connection getConnection(){
		try {
			Context text=new InitialContext();
			DataSource con = (DataSource) text.lookup("java:comp/env/jdbc/scott");
			
		    connection=con.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	//查询数据
	public  ResultSet  executeQuery(String sql,Object[]params){
		try {
			//得到链接
			getConnection();
			//得到PreparedStatement准备声明语句
			ps=connection.prepareStatement(sql);
			if(params!=null&&params.length>0){
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			
			result=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	//修改数据
	public int executeUpdate(String sql,Object[]params){
		int row =0;
		try {
			//得到链接
			getConnection();
			//得到PreparedStatement准备声明语句
			ps=connection.prepareCall(sql);
			if(params!=null&&params.length>0){
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			row=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.closed();
		
		return row;
	}
	
	//释放资源
	public void closed(){
		try {
			if(result!=null){
				result.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(connection!=null){
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
