package cn.tedu.store.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Collect;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.CollectMapper;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ICollectService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 * 处理购物车数据的业务层实现类
 */
@Service
public class CollectServiceImpl implements ICollectService {

	@Autowired
	private CollectMapper collectMapper;

	@Override
	public void addToCollect(String username, Collect collect) throws InsertException, UpdateException {
		// 根据uid和gid去查询数据：findByUidAndGid(cart.getUid(), cart.getGid())
		Integer uid = collect.getUid();
		Long bid = collect.getBid();
		Collect result = findByUidAndBid(uid, bid);
		
		// 判断查询结果是否为null
		Date now = new Date();
		if (result == null) {
			// 是：向参数cart中封装日志数据
			collect.setCreatedUser(username);
			collect.setCreatedTime(now);
			collect.setModifiedUser(username);
			collect.setModifiedTime(now);
			// 插入数据：insert(cart)
			insert(collect);
		} 
	}
	
	@Override
	public List<CartVO> getByUid(Integer uid) {
		return findByUid(uid);
	}

	@Override
	public List<CartVO> getByCids(Integer[] cids) {
		return findByCids(cids);
	}

	/**
	 * 插入购物车数据
	 * @param cart 购物车数据
	 */
	private void insert(Collect collect) {
		Integer rows = collectMapper.insert(collect);
		if (rows != 1) {
			throw new InsertException(
				"添加购物车数据出现未知错误！");
		}
	}

	/**
	 * 修改购物车数据中商品的数量 
	 * @param cid 购物车数据的id
	 * @param num 新的数量
	 * @param modifiedUser 修改执行人
	 * @param modifiedTime 修改时间
	 */
	private void updateNum(Integer cid, Integer num, String modifiedUser, Date modifiedTime) {
		Integer rows = collectMapper.updateNum(
				cid, num, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException(
				"修改购物车中商品数量出现未知错误！");
		}
	}

	/**
	 * 获取某用户在购物车中添加的指定商品的数据
	 * @param uid 用户的id
	 * @param gid 商品的id
	 * @return 匹配的购物车数据，如果没有匹配的数据，则返回null
	 */
	private Collect findByUidAndBid(Integer uid, Long bid) {
		return collectMapper.findByUidAndBid(uid, bid);
	}
	
	/**
	 * 根据购物车数据id获取购物车数据
	 * @param cid 购物车数据id
	 * @return 匹配的购物车数据，如果没有匹配的数据，则返回null
	 */
	private Collect findByCid(Integer cid) {
		return collectMapper.findByCid(cid);
	}
	
	/**
	 * 获取某用户的购物车数据列表
	 * @param uid 用户的id
	 * @return 用户的购物车数据列表
	 */
	private List<CartVO> findByUid(Integer uid) {
		return collectMapper.findByUid(uid);
	}

	/**
	 * 获取指定的某些id的购物车数据列表
	 * @param cids 指定的一系列购物车数据id
	 * @return 购物车数据列表
	 */
	private List<CartVO> findByCids(Integer[] cids) {
		return collectMapper.findByCids(cids);
	}
}