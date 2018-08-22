package com.supermarket.service.impl;

import com.supermarket.dao.DeleteBillDao;
import com.supermarket.dao.impl.DeleteBillDaoImpl;
import com.supermarket.service.DeleteBillService;

public class DeleteBillServiceImpl implements DeleteBillService {
	private DeleteBillDao dao=new DeleteBillDaoImpl();
	
	@Override
	public int deleteBillById(String billid) {
		return dao.deleteBillById(billid);
	}

	@Override
	public int deleteBillByCode(String billCode) {
		
		return dao.deleteBillByCode(billCode);
	}

}
