package com.supermarket.service.impl;

import java.util.List;

import com.supermarket.dao.UpdateBillsDao;
import com.supermarket.dao.impl.UpdateBillsDaoimpl;
import com.supermarket.entity.Products;
import com.supermarket.entity.ShoppingBill;
import com.supermarket.service.BillsBiz;





public class BillBizimpl implements BillsBiz {
	private UpdateBillsDao dao =new UpdateBillsDaoimpl();

	@Override
	public List<ShoppingBill> getAllBills() {
		return dao.getAllBills();
	}

	@Override
	public List<ShoppingBill> getBillsBybid(int bid) {
		return dao.getBillsByBid(bid);
	}

	@Override
	public List<Products> getAllProname() {
		return dao.getAllProname();
	}

}
