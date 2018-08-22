package com.supermarket.service.impl;

import com.supermarket.dao.AddBillDao;
import com.supermarket.dao.impl.AddBillDaoImpl;
import com.supermarket.service.AddBillService;

public class AddBillServiceImpl implements AddBillService {
	private AddBillDao dao=new AddBillDaoImpl();

	@Override
	public int addBill(Object[] param) {
		
		return dao.addBill(param);
	}

	@Override
	public String getAPro(String proCode) {
		
		return dao.getAPro(proCode);
	}

}
