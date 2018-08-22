package com.supermarket.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.supermarket.dao.AddBillDao;
import com.supermarket.until.BaseDao;

public class AddBillDaoImpl extends BaseDao implements AddBillDao {

	@Override
	public int addBill(Object[] param) {
		StringBuffer sql=new StringBuffer();
		sql.append(" INSERT INTO smbms_bill(billid, ");
		sql.append(" billcode ,productName , ");
		sql.append(" productUnit  ,productCount, ");
		sql.append(" totalPrice ,proCode , ");
		sql.append(" ispayment ,createdBy , ");
		sql.append(" creationDate )VALUES (  ");
		sql.append(" billid.nextval,?, ?,?,?,?,?,?,?,SYSDATE) ");
		
		return this.executeUpdate(sql.toString(), param);
	}

	@Override
	public String getAPro(String proCode) {
		String str=null;
		StringBuffer sql =new StringBuffer();
		sql.append("SELECT proname  FROM smbms_provider WHERE procode =?");
		Object [] param= {proCode};
		ResultSet rs=this.executeQuery(sql.toString(), param);
		try {
			while(rs!=null && rs.next()){
				str=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}

}
