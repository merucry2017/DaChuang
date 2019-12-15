package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Collect;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

public interface ICollectService {

	/**
	 * 将用户选中的商品添加到购物车
	 * @param username 当前登录的用户的用户名
	 * @param cart 购物车数据
	 * @throws InsertException 插入数据异常
	 * @throws UpdateException 更新数据异常
	 */
	void addToCollect(String username, Collect collect) 
			throws InsertException, UpdateException;
	
	
	/**
	 * 获取某用户的购物车数据列表
	 * @param uid 用户的id
	 * @return 用户的购物车数据列表
	 */
	List<CartVO> getByUid(Integer uid);
	
	/**
	 * 获取指定的某些id的购物车数据列表
	 * @param cids 指定的一系列购物车数据id
	 * @return 购物车数据列表
	 */
	
	List<CartVO> getByCids(Integer[] cids);
}
