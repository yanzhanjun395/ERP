package com.supermarket.dao;

import java.util.List;

import com.supermarket.entity.providers;



/**
 * 存储和处理数据库中供应商的数据
 * @author Mr孙
 *  2017-2-20下午8:22:05
 */
public interface ProviderDao {
	
	/**
	 * 通过页码和每页显示条数得到一个供应商信息的集合
	 * @param index 页码
	 * @param page 每页显示条数
	 * @return
	 */
	public List<providers> getProviders(String proName,int index,int page);
	
	/**
	 * 得到总共的条数
	 * @return
	 */
	public int getTotalProviders();
	
	/**
	 * 通过供应商编码得到供应商信息
	 * @param proCode 供应商的编码
	 * @return  供应商的具体信息
	 */
	public providers getProviderByProCode(String proCode);
	
	/**
	 * 根据供应商的名字得到供应商的信息
	 * @param proName 供应商的名字,搜索显示
	 * @return 供应商的详细信息
	 */
	public List<providers> getProviderByProName(String proName);
	
	
	/**
	 * 根据传来的供应商对象，添加一个供应商
	 * @param provider
	 * @return 受影响的行数
	 */
	public int addPro(providers provider);
	/**
	 * 根据供应商编号，删除供应商
	 * @param code
	 * @return 受影响的行数
	 */
	public int deleteProByCode(String code);
	
	/**
	 * 根据供应商的编码修改供应商的信息
	 * @param proCode 供应商的编码
	 * @return 
	 */
	public int updateProvider(providers provider);
	
	
}
