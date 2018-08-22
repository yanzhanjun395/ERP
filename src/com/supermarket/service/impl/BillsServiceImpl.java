package com.supermarket.service.impl;

import java.util.List;

import com.supermarket.dao.BillsDao;
import com.supermarket.entity.Provider;
import com.supermarket.entity.ShopprngBill;
import com.supermarket.service.BillsService;

public class BillsServiceImpl implements BillsService {
	private BillsDao dao;
	
	public void setDao(BillsDao dao) {
		this.dao = dao;
	}

	@Override
	public List<ShopprngBill> getBills(Object [] params) {
		
		return dao.getBills(params);
	}

	@Override
	public int showTotalPage(int pageSize,Object [] param) {
		//求总记录数
		int total= dao.getTotalRecordz(param);
		int temp=total/pageSize;
		return total%pageSize==0 ? temp : temp+1;
	}

	@Override
	public List<Provider> getProvider() {
		
		return dao.getProvider();
	}

	@Override
	public ShopprngBill getBill(Object[] param) {
		
		return dao.getBill(param);
	}

	@Override
	public int getCodeNum(String billCode) {
		
		return dao.getCodeNum(billCode);
	}

	@Override
	public ShopprngBill getBillByCode(Object[] param) {
		
		return dao.getBillByCode(param);
	}

}
