package com.supermarket.service;

public interface AddBillService {
	public int addBill(Object[] param);
	/**
	 * 通过供应商编号，得到这个编号的供应商的信息
	 * @param proCode 供应商编号
	 * @return 供应商对象
	 */
	public String getAPro(String proCode);
}
