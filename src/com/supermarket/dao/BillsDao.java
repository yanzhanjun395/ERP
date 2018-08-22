package com.supermarket.dao;

import java.util.List;

import com.supermarket.entity.Provider;
import com.supermarket.entity.ShopprngBill;


public interface BillsDao {
	/**
	 * 分页查询账单信息
	 
	 * @return 账单的信息集合
	 */
	public List<ShopprngBill> getBills(Object [] params);
	/**
	 * 得到账单的总行数
	 * @return 返回行数
	 */
	public int getTotalRecordz(Object [] param);
	/**
	 * 得到指定单号的总行数
	 * @return 返回行数
	 */
	public int getCodeNum(String billCode);
	/**
	 * 初始化供应商信息
	 * @return 供应商信息集合
	 */
	public List<Provider> getProvider();
	/**
	 * 到的单个账单信息
	 * @param param 参数数组：billid
	 * @return 账单对象
	 */
	public ShopprngBill getBill(Object [] param);
	/**
	 * 到的单个账单信息
	 * @param param 参数数组：billid
	 * @return 账单对象
	 */
	public ShopprngBill getBillByCode(Object [] param);
	
	
	
	
}
