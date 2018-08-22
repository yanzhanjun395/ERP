package com.supermarket.service;

import java.util.List;

import com.supermarket.dao.BillsDao;
import com.supermarket.entity.Provider;
import com.supermarket.entity.ShopprngBill;

public interface BillsService {
	public void setDao(BillsDao dao);
	/**
	 * 分页查询账单信息
	 * @param pageIndex 页数
	 * @param pageSize 每页显示的数据数
	 * @return 账单的信息集合
	 */
	public List<ShopprngBill> getBills(Object [] params);
	/**
	 * 获得总页数
	 * @param pageSize 每页显示的数据数
	 * @return 总页数
	 */
	public int showTotalPage(int pageSize,Object [] param);
	/**
	 * 初始化供应商信息
	 * @return 供应商信息集合
	 */
	public List<Provider> getProvider();
	/**
	 * 得到一个账单对象
	 * @param param 参数数组：billid
	 * @return 账单对象
	 */
	public ShopprngBill getBill(Object [] param);
	/**
	 * 得到指定单号的总行数
	 * @return 返回行数
	 */
	public int getCodeNum(String billCode);
	/**
	 * 到的单个账单信息
	 * @param param 参数数组：billid
	 * @return 账单对象
	 */
	public ShopprngBill getBillByCode(Object [] param);
}
