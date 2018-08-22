package com.supermarket.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.supermarket.dao.ProviderDao;
import com.supermarket.entity.providers;
import com.supermarket.until.BaseDao;

/**
 * 供应商查询的实现
 * @author Mr孙
 *  2017-2-20下午8:41:42
 */
public  class ProviderDaoImpl extends BaseDao implements ProviderDao {

	
	/**
	 * 供应商的集合
	 */
	@Override
	public List<providers> getProviders(String proName,int index, int page) {
		
		List<providers> list= new ArrayList<providers>();
		
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" SELECT p.procode,p.proname,p.procontact, ");
			sql.append(" p.prophone,p.profax,p.creationDate ");
			sql.append(" FROM(SELECT smbms_provider.*, ");
			sql.append(" row_number() OVER(ORDER BY proCode ASC) tn FROM smbms_provider ) p ");
			sql.append(" WHERE proname like ? and tn>? AND tn<=? ");
			
			Object[] params={proName,(index-1)*page,page*index};
			
			ResultSet rs = this.executeQuery(sql.toString(), params);
			while(rs!=null && rs.next()){
				providers pro = new providers();
				pro.setProCode(rs.getString(1));
				pro.setProName(rs.getString(2));
				pro.setProContact(rs.getString(3));
				pro.setProPhone(rs.getString(4));
				pro.setProFax(rs.getString(5));
				pro.setCreateDate(rs.getString(6));
				
				list.add(pro);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closed();
		}
		
		return list;
	}

	
	/**
	 * 根据每页显示的条数得到总共的页数
	 */
	@Override
	public int getTotalProviders() {
		int row=0;
		try {
			String sql="SELECT COUNT(1) FROM smbms_provider";
			ResultSet rs= this.executeQuery(sql,null);
			while(rs!=null && rs.next()){
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closed();
		}
		
		return row;
	}


	/**
	 * 供应商的详细信息
	 */
	@Override
	public providers getProviderByProCode(String proCode) {
		providers pro = null;
		try {
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT proCode,proName,proContact,proPhone,proFax,proDesc ");
			sql.append(" FROM smbms_provider ");
			sql.append(" WHERE proCode=? ");
			
			Object[] params={proCode};
			ResultSet rs= this.executeQuery(sql.toString(), params);
			while(rs!=null && rs.next()){
				pro = new providers();
				pro.setProCode(rs.getString(1));
				pro.setProName(rs.getString(2));
				pro.setProContact(rs.getString(3));
				pro.setProPhone(rs.getString(4));
				pro.setProFax(rs.getString(5));
				pro.setProDesc(rs.getString(6));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closed();
		}
		
		return pro;
	}

	/**
	 * 根据供应商的姓名得到供应商的详细信息查询
	 */
	@Override
	public List<providers> getProviderByProName(String proName) {
		providers provider=null;
		List<providers> list=new ArrayList<providers>();
		try {
			StringBuffer sql= new StringBuffer();
			sql.append(" SELECT procode,proname,procontact,prophone,profax,creationdate ");
			sql.append(" FROM smbms_provider ");
			sql.append(" WHERE proname like ? ");
			Object[] params={proName};
			ResultSet rs= this.executeQuery(sql.toString(), params);
			
			while (rs!=null&&rs.next()) {
				provider=new providers();
				provider.setProCode(rs.getString(1));
				provider.setProName(rs.getString(2));
				provider.setProContact(rs.getString(3));
				provider.setProPhone(rs.getString(4));
				provider.setProFax(rs.getString(5));
				provider.setCreateDate(rs.getString(6));
				list.add(provider);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closed();
		}
		
		return list;
	}
	
	
	@Override
	public int addPro(providers provider) {
		int row = 0;
		//创建一个可变长度的字符串sql creationdate,modifydate, provider.getCreateDate(),
		//provider.getModifyDate(),
		StringBuffer sql = new StringBuffer();
		sql.append(" INSERT INTO smbms_provider(procode,proname, ");
		sql.append(" prodesc,procontact,prophone,proaddress,profax, ");
		sql.append(" createdby,creationdate,modifyby) ");
		sql.append(" VALUEs(?,?,?,?,?,?,?,?,sysdate,?) ");
		Object[] params = {provider.getProCode(),provider.getProName(),provider.getProDesc(),
				provider.getProContact(),provider.getProPhone(),provider.getProAddress(),
				provider.getProFax(),provider.getCreateBy(),provider.getModifyBy()};
		row = this.executeUpdate(sql.toString(), params);
		//关闭资源
		this.closed();
		return row;
	}

	@Override
	public int deleteProByCode(String code) {
		int row = 0;
		//StringBuffer sbf=new StringBuffer();
		String sbf=("{call smbms_deleteprovider(?)}");
		Object[] params = {code};
		row = this.executeUpdate(sbf, params);
		
		return row;
	}

	/**
	 * 根据供应商的编码修改供应商的信息
	 */
	@Override
	public int updateProvider(providers provider) {
		int row=0;
		StringBuffer sql=new StringBuffer();
		sql.append(" UPDATE smbms_provider SET proCode=?, ");
		sql.append(" proName=?,proContact=?,proPhone=?, ");
		sql.append(" proAddress=?,proFax=?,proDesc=? ");
		sql.append(" WHERE proCode=?");
		
		Object[] params={provider.getProCode(),provider.getProName(),
				 provider.getProContact(),provider.getProPhone(),
				 provider.getProAddress(),provider.getProFax(),provider.getProDesc(),provider.getProCode()};
		row= this.executeUpdate(sql.toString(), params);
		
		this.closed();
		return row;
	}
	
	

}
