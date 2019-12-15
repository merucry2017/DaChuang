package cn.tedu.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.tedu.store.entity.Books;
import cn.tedu.store.entity.Goods;
@Mapper
public interface BooksMapper {

	List<Books> findHotBooks();
	
	List<Books> findBySearch(String search);
	
	Books findById(Long id);

}
