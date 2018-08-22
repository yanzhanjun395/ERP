package com.supermarket.dao;

public interface AddBillDao {
	/**
	 * 添加一个账单信息
	 * @param param 账单信息参数
	 * @return 改变的行数
	 */
	public int addBill(Object[] param);
	/**
	 * 通过供应商编号，得到这个编号的供应商的信息
	 * @param proCode 供应商编号
	 * @return 供应商对象
	 */
	public String getAPro(String proCode);
}
