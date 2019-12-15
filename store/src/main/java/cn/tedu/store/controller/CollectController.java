package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Collect;
import cn.tedu.store.service.ICartService;
import cn.tedu.store.service.ICollectService;
import cn.tedu.store.util.ResponseResult;
import cn.tedu.store.vo.CartVO;

@RestController
@RequestMapping("/collect")
public class CollectController extends BaseController{

	@Autowired
	private ICollectService collectService;
	
	@RequestMapping("/add")
	public ResponseResult<Void> addToCollect(Collect collect, 
			@RequestParam("bid") Integer bid,
			HttpSession session) {
		// 注意：客户端提交的cart只会包含gid, num
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 从session中获取username
		String username = session.getAttribute("username").toString();
		// 将uid封装到cart中
		collect.setBid(bid);
		collect.setUid(uid);
		// 执行：service.addToCart(username, cart);
		collectService.addToCollect(username, collect);
		// 返回
		return new ResponseResult<>(SUCCESS);
	}

	
	@GetMapping("/")
	public ResponseResult<List<CartVO>> getByUid(
		HttpSession session) {
		// 从session中获取uid
		Integer uid = getUidFromSession(session);
		// 执行：service.addToCart(username, cart);
		List<CartVO> data = collectService.getByUid(uid);
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
	
	@GetMapping("/checked_list")
	public ResponseResult<List<CartVO>> getByCids(
			Integer[] cids) {
		// 执行
		List<CartVO> data = collectService.getByCids(cids);
		// 返回
		return new ResponseResult<>(SUCCESS, data);
	}
}
