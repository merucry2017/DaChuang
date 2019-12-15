package cn.tedu.store.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Books;
import cn.tedu.store.entity.Goods;
import cn.tedu.store.mapper.BooksMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.service.IBooksService;
import cn.tedu.store.service.IGoodsService;
@Service
public class BooksServiceImpl implements IBooksService{
	
	@Autowired 
	private BooksMapper booksMapper;
	
	 @Override
	    public List<Books> getHotBooks() {
	        return findHotbooks();
	    }

	    /**
	     * 获取热销商品列表
	     * @return 热销商品列表
	     */
	    private List<Books> findHotbooks() {
	        return booksMapper.findHotBooks();
	    }
	    
	   
	    /**
	     * 根据id查询商品详情
	     * @param id 商品的id
	     * @return 匹配的商品的详情，如果没有匹配的数据，则返回null
	     */
	    private Books findById(Long id) {
	        return booksMapper.findById(id);
	    }
	    
	    @Override
	    public Books getById(Long id) {
	        return findById(id);
	    }

		@Override
		public List<Books> searchBooks(String search) {
			return booksMapper.findBySearch(search);
		}
		
}
