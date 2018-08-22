package com.supermarket.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.supermarket.dao.UpdateBillsDao;
import com.supermarket.entity.Products;
import com.supermarket.entity.ShoppingBill;
import com.supermarket.until.BaseDao;

public class UpdateBillsDaoimpl extends BaseDao implements UpdateBillsDao {


@Override
public int updateBillsByBid(ShoppingBill shopbill,
		String billcode,String proname,String pid, double total,
		int ispay,int bid) {
	StringBuffer sql=new StringBuffer();
	sql.append(" UPDATE smbms_bill SET billcode=?, productname=?, ");
	sql.append("  procode=?,totalprice=?,isPayment=?, ");
	sql.append(" modifydate=SYSDATE WHERE  billid=? ");
	Object[] params={billcode,proname,pid,total,ispay,bid};
	return this.executeUpdate(sql.toString(), params);
	
}


@Override
public List<Products> getAllProname() {
	List<Products> list=new ArrayList<Products>();
	String sql=(" SELECT procode, proname FROM smbms_provider ");
	ResultSet rs=super.executeQuery(sql.toString(), null);
	try {
		while(rs!=null && rs.next()){
			Products pds=new Products();
			pds.setPid(rs.getString(1));
			pds.setProName(rs.getString(2));
			list.add(pds);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}


@Override
public List<ShoppingBill> getBillsByBid(int bid) {
	List<ShoppingBill> list=new ArrayList<ShoppingBill>();
	StringBuffer sql=new StringBuffer();
	sql.append(" SELECT b.billcode,b.productname,p.proname,  ");
	sql.append("  b.totalprice,i.pname,b.productcount,b.creationdate,b.billid   ");
	sql.append("  ,p.procode  FROM isPayment i,smbms_provider p,smbms_bill b   ");
	sql.append("   WHERE b.isPayment=i.payment AND b.procode=p.procode ");
	sql.append("  AND b.billid= ? ");
	Object[] params={bid};
	ResultSet rs=super.executeQuery(sql.toString(), params);
	try {
		while(rs!=null && rs.next()){
			ShoppingBill shopbill=new ShoppingBill();
			shopbill.setBillcode(rs.getString(1));
			shopbill.setProductName(rs.getString(2));
			shopbill.setProname(rs.getString(3));
			shopbill.setTotalPrice(rs.getDouble(4));
			shopbill.setPname(rs.getString(5));
			shopbill.setProductCount(rs.getDouble(6));
			shopbill.setCreationDate(rs.getDate(7));
			shopbill.setBid(rs.getInt(8));
			shopbill.setPid(rs.getString(9));
			list.add(shopbill);
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}


@Override
public ShoppingBill getBillsByBcode(int bid) {
	ShoppingBill shopbill=null;
	StringBuffer sql=new StringBuffer();
	sql.append(" SELECT b.billcode,b.productname,p.proname,  ");
	sql.append("  b.totalprice,i.pname,b.productcount,b.creationdate,b.billid   ");
	sql.append("  ,p.procode  FROM isPayment i,smbms_provider p,smbms_bill b   ");
	sql.append("   WHERE b.isPayment=i.payment AND b.procode=p.procode ");
	sql.append("  AND b.billid= ? ");
	Object[] params={bid};
	ResultSet rs=super.executeQuery(sql.toString(), params);
	try {
		while(rs!=null && rs.next()){
			shopbill=new ShoppingBill();
			shopbill.setBillcode(rs.getString(1));
			shopbill.setProductName(rs.getString(2));
			shopbill.setProname(rs.getString(3));
			shopbill.setTotalPrice(rs.getDouble(4));
			shopbill.setPname(rs.getString(5));
			shopbill.setProductCount(rs.getDouble(6));
			shopbill.setCreationDate(rs.getDate(7));
			shopbill.setBid(rs.getInt(8));
			shopbill.setPid(rs.getString(9));
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return shopbill;
}



//得到所有账单集合
public List<ShoppingBill> getAllBills() {
	List<ShoppingBill> list=new ArrayList<ShoppingBill>();
	StringBuffer sql=new StringBuffer();
	sql.append(" SELECT b.billcode,b.productname,p.proname,  ");
	sql.append("  b.totalprice,i.pname,b.creationdate   ");
	sql.append("   FROM isPayment i,smbms_provider p,smbms_bill b   ");
	sql.append("   WHERE b.isPayment=i.payment AND b.procode=p.procode ");
	
	ResultSet rs=super.executeQuery(sql.toString(), null);
	
	try {
		while(rs!=null && rs.next()){
			ShoppingBill shop=new ShoppingBill();
			
			shop.setBillcode(rs.getString(1));
			shop.setProductName(rs.getString(2));
			shop.setProname(rs.getString(3));
			shop.setTotalPrice(rs.getDouble(4));
			shop.setPname(rs.getString(5));
			shop.setCreationDate(rs.getDate(6));
			list.add(shop);
		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return list;
}



}
