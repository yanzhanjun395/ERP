package com.supermarket.service;

import java.util.List;

import com.supermarket.entity.providers;



/**
 * 业务逻辑层
 * @author Mr孙
 *  2017-2-20下午9:11:33
 */
public interface ProviderService {
	
	/**
	 * 根据每页显示的信息条数和总共的页数得到一个供应商信息的集合
	 * @param index 每页显示的条数
	 * @param page 总共的页数
	 * @return
	 */
	public List<providers> getProviderByIndex(String proName,int index,int page);
	
	/**
	 * 通过每页显示的条数得到总共的页数
	 * @param page
	 * @return
	 */
	public int showTotalPage(int page);

	/**
	 * 根据供应商编码得到供应商的信息
	 * @param proCode 供应商的编码
	 * @return 供应商的详细信息
	 */
	public providers showProvider(String proCode);
	
	/**
	 * 根据供应商的姓名得到供应商的详细信息
	 * @param proName 供应商的姓名,搜索显示
	 * @return
	 */
	public List<providers> getProvider(String proName);
	
	/**
	 * 是否添加成功
	 * @param provider
	 * @return boolean值
	 */
	public boolean addPro(providers provider);
	/**
	 * 是否删除成功
	 * @param code
	 * @return boolean值
	 */
	public boolean deleteProByCode(String code);
	
	/**
	 * 根据供应商的编码判断是否修改成功
	 * @param provider
	 * @return
	 */
	public boolean updateProvider(providers provider);
	
	
	
	
	
	
	
	
	
	
}
