package com.supermarket.dao;

import java.util.Date;
import java.util.List;

import com.supermarket.entity.Products;
import com.supermarket.entity.ShoppingBill;

public interface UpdateBillsDao {

	//得到所有的账单集合
		public List<ShoppingBill> getAllBills();
	//根据编号得到账单对象
		public ShoppingBill getBillsByBcode(int bid);
	//根据单据ID修改订单
	public int updateBillsByBid(ShoppingBill shopbill,
			String billcode,String proname,String pid, double total,
			int ispay,int bid);
	//得到所有供应商集合
	public List<Products> getAllProname();
	//根据账单编号和商品名称查询账单
	public List<ShoppingBill> getBillsByBid(int bid);
	

}
