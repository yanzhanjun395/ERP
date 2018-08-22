package com.supermarket.service;

public interface DeleteBillService {
	/**
	 * 根据编号删除信息,删除这个编号的所有信息
	 * @param billCode 编号
	 * @return 删除的行数
	 */
	public int deleteBillByCode(String billCode);
	/**
	 * 根据ID删除一条信息
	 * @param billid 信息的ID
	 * @return 删除的行数
	 */
	public int deleteBillById(String billid);
}
