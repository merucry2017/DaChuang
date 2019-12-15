package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.entity.Books;

public interface IBooksService {
	List<Books> getHotBooks();
	
	List<Books> searchBooks(String search);
	
	Books getById(Long id);
		
}
