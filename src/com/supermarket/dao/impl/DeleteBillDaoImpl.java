package com.supermarket.dao.impl;

import com.supermarket.dao.DeleteBillDao;
import com.supermarket.until.BaseDao;

public class DeleteBillDaoImpl extends BaseDao implements DeleteBillDao {

	@Override
	public int deleteBillById(String billid) {
		StringBuffer sql =new StringBuffer();
		sql.append("DELETE  FROM smbms_bill WHERE billid= ? ");
		Object[] params={billid};
		int row =this.executeUpdate(sql.toString(), params);
		return row;
	}

	@Override
	public int deleteBillByCode(String billCode) {
		StringBuffer sql =new StringBuffer();
		sql.append(" DELETE FROM smbms_bill WHERE Billid IN  ");
		sql.append(" (SELECT billID FROM smbms_bill WHERE billcode = ?)");
		Object[] params={billCode};
		int row =this.executeUpdate(sql.toString(), params);
		return row;
	}

}
