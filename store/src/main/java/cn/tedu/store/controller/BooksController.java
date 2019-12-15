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

import cn.tedu.store.entity.Books;
import cn.tedu.store.service.IBooksService;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/books")
public class BooksController extends BaseController{
	
	@Autowired 
	private IBooksService booksService;
	
	@GetMapping("/hot")
	public ResponseResult<List<Books>> getHotGoods() {
		// 获取数据
        List<Books> data = booksService.getHotBooks();
        // 返回
        return new ResponseResult<>(SUCCESS, data);
	}
	
	@GetMapping("/{id}/details")
	public ResponseResult<Books> getById(
	    @PathVariable("id") Long id) {
		
	    // 执行
	    Books data = booksService.getById(id);
	    // 返回
	    return new ResponseResult<>(SUCCESS, data);
	}
	
	@PostMapping("/")
	public ResponseResult<List<Books>> getByUid(
		@RequestParam("search") String search,
		HttpSession session) {
		System.out.println(search);
		
		List<Books> data = booksService.searchBooks(search);
		// 返回
		System.out.println(data.get(0).toString());
		return new ResponseResult<>(SUCCESS, data);
	}
}
