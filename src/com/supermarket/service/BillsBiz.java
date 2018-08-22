package com.supermarket.service;

import java.util.List;

import com.supermarket.entity.Products;
import com.supermarket.entity.ShoppingBill;



public interface BillsBiz {
	public List<ShoppingBill> getAllBills();
	public List<ShoppingBill> getBillsBybid(int bid);
	public List<Products> getAllProname();

}
