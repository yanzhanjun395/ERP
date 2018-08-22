package com.supermarket.service.impl;

import java.util.List;

import com.supermarket.dao.ProviderDao;
import com.supermarket.dao.impl.ProviderDaoImpl;
import com.supermarket.entity.providers;

import com.supermarket.service.ProviderService;
import com.supermarket.until.BaseDao;
/**
 * 业务逻辑实现类
 * @author Mr孙
 *  2017-2-20下午9:15:11
 */
public class ProviderServiceImpl extends BaseDao implements ProviderService {

	ProviderDao dao = new ProviderDaoImpl();
	
	/**
	 * 供应商的详细信息
	 */
	@Override
	public List<providers> getProviderByIndex(String proName,int index, int page) {
		
		return dao.getProviders(proName,index, page);
	}

	
	/**
	 * 得到总共的条数
	 */
	@Override
	public int showTotalPage(int page) {
		
		int totalPage=dao.getTotalProviders();
		
		int temp=totalPage/page;
		
		return totalPage % page == 0 ? temp : temp+1;
	}




	/**
	 * 根据供应商的编码得到供应商的详细信息
	 */
	@Override
	public providers showProvider(String proCode) {
		
		return dao.getProviderByProCode(proCode);
	}

	/**
	 * 根据供应商的姓名得到供应商的详细信息，搜索显示
	 */
	@Override
	public List<providers> getProvider(String proName) {
		
		return dao.getProviderByProName(proName);
		
	}

	@Override
	public boolean addPro(providers provider) {
		boolean flag = false;
		if(dao.addPro(provider)==1){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteProByCode(String code) {
		boolean flag = false;
		if(dao.deleteProByCode(code)==1){
			flag = true;
		}
		return flag;
	}

	/**
	 * 修改供应商信息
	 */
	@Override
	public boolean updateProvider(providers provider) {
		
		if(dao.updateProvider(provider)==1){
			return true;
		}
		
		return false;
	}
	
}
