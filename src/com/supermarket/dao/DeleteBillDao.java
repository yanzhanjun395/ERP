package com.supermarket.dao;

public interface DeleteBillDao {
	/**
	 * 根据编号删除信息,整个编号的所有信息删除
	 * @param billCode 编号
	 * @return 删除的行数
	 */
	public int deleteBillByCode(String billCode);
	/**
	 * 根据id删除一行信息
	 * @param billid ID号
	 * @return 删除的行数
	 */
	public int deleteBillById(String billid);
	
}
