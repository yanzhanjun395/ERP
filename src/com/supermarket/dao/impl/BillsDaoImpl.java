package com.supermarket.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.supermarket.dao.BillsDao;
import com.supermarket.entity.Provider;
import com.supermarket.entity.ShopprngBill;
import com.supermarket.until.BaseDao;

public class BillsDaoImpl extends BaseDao implements BillsDao {
	private ShopprngBill bills;
	@Override
	public List<ShopprngBill> getBills(Object [] params) {
		List<ShopprngBill> list= new ArrayList<ShopprngBill>();
		try {
			StringBuffer sql=new StringBuffer();
			//sql语句的前后都加空格，免得又sql语法错误
			sql.append(" SELECT s.billcode,s.productname, ");
			sql.append(" pro.proname,s.totalprice,ip.pname, ");
			sql.append(" s.creationdate,s.billId FROM smbms_provider pro, ");
			sql.append(" isPayment ip,(SELECT n.*,row_number()");
			sql.append(" OVER (ORDER BY billcode DESC)tn ");
			sql.append(" FROM (SELECT * FROM smbms_bill WHERE ");
			sql.append(" productname LIKE ? AND procode ");
			sql.append(" LIKE ? AND ispayment LIKE ? AND billcode LIKE ?) n) s  ");
			sql.append(" WHERE pro.procode=s.procode AND tn>? AND tn<=? ");
			sql.append(" AND ip.payment=s.ispayment  ORDER BY TN ASC");
			//Object [] params={(pageIndex-1)*pageSize,pageIndex*pageSize};
			ResultSet rs=this.executeQuery(sql.toString(), params);
			while(rs!=null&&rs.next()){
				bills=new ShopprngBill();
				bills.setBillCode(rs.getString(1));
				bills.setProductName(rs.getString(2));
				bills.setProName(rs.getString(3));
				bills.setTotalPrice(rs.getDouble(4));
				bills.setPname(rs.getString(5));
				bills.setCreationDate(rs.getDate(6));
				bills.setBillId(rs.getInt(7));
				list.add(bills);
			}
			super.closed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int getTotalRecordz(Object [] param) {
		String sql=" SELECT COUNT(1) FROM smbms_bill WHERE 1=1 " +
				" AND productname LIKE ? AND procode " +
				" LIKE ? AND ispayment LIKE ? AND billcode LIKE ? ";
		int row =0;
		try {
			ResultSet rs=super.executeQuery(sql, param);
			if(rs!=null&&rs.next()){
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	@Override
	public List<Provider> getProvider() {
		List<Provider> list= new ArrayList<Provider>();
		try {
			StringBuffer sql=new StringBuffer();
			//sql语句的前后都加空格，免得又sql语法错误
			sql.append(" SELECT procode,proname FROM smbms_provider ");
			ResultSet rs=this.executeQuery(sql.toString(), null);
			while(rs!=null&&rs.next()){
				Provider provider=new Provider();
				provider.setProCode(rs.getString(1));
				provider.setProName(rs.getString(2));
				list.add(provider);
			}
			super.closed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public ShopprngBill getBill(Object [] param) {
		try {
			StringBuffer sql=new StringBuffer();
			//sql语句的前后都加空格，免得又sql语法错误
			sql.append(" SELECT n.billcode,n.productname, ");
			sql.append(" s.proname,n.totalprice, ");
			sql.append(" ip.pname,n.productunit, ");
			sql.append(" n.productCount,n.ispayment FROM smbms_provider s,isPayment ip, ");
			sql.append(" (SELECT billcode,productname, ");
			sql.append("  procode,totalprice,ispayment, ");
			sql.append("  productUnit,productCount FROM  ");
			sql.append(" smbms_bill WHERE billid= ? ) n ");
			sql.append(" WHERE s.procode=n.procode AND ip.payment=n.ispayment");
			//Object [] params={(pageIndex-1)*pageSize,pageIndex*pageSize};
			ResultSet rs=this.executeQuery(sql.toString(), param);
			while(rs!=null&&rs.next()){
				bills=new ShopprngBill();
				bills.setBillCode(rs.getString(1));
				bills.setProductName(rs.getString(2));
				bills.setProName(rs.getString(3));
				bills.setTotalPrice(rs.getDouble(4));
				bills.setPname(rs.getString(5));
				bills.setProductUnit(rs.getString(6));
				bills.setProductCount(rs.getInt(7));
				bills.setIsPayment(rs.getInt(8));
			}
			super.closed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}
	@Override
	public int getCodeNum(String billCode) {
		String sql="  SELECT COUNT(*) FROM smbms_bill WHERE  billcode = ? ";
		int row =0;
		Object [] param={billCode};
		try {
			ResultSet rs=super.executeQuery(sql, param);
			if(rs!=null&&rs.next()){
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	@Override
	public ShopprngBill getBillByCode(Object[] param) {
		try {
			StringBuffer sql=new StringBuffer();
			//sql语句的前后都加空格，免得又sql语法错误
			sql.append(" SELECT n.billcode,n.productname, ");
			sql.append(" s.proname,n.totalprice, ");
			sql.append(" ip.pname,n.productunit, ");
			sql.append(" n.productCount FROM smbms_provider s,isPayment ip, ");
			sql.append(" (SELECT billcode,productname, ");
			sql.append("  procode,totalprice,ispayment, ");
			sql.append("  productUnit,productCount FROM  ");
			sql.append(" smbms_bill WHERE billcode= ? ) n ");
			sql.append(" WHERE s.procode=n.procode AND ip.payment=n.ispayment");
			//Object [] params={(pageIndex-1)*pageSize,pageIndex*pageSize};
			ResultSet rs=this.executeQuery(sql.toString(), param);
			while(rs!=null&&rs.next()){
				bills=new ShopprngBill();
				bills.setBillCode(rs.getString(1));
				bills.setProductName(rs.getString(2));
				bills.setProName(rs.getString(3));
				bills.setTotalPrice(rs.getDouble(4));
				bills.setPname(rs.getString(5));
				bills.setProductUnit(rs.getString(6));
				bills.setProductCount(rs.getInt(7));
			}
			super.closed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bills;
	}

}
