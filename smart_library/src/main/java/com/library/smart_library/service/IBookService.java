package com.library.smart_library.service;

import com.library.smart_library.entity.Book;
import com.library.smart_library.service.ex.*;

import java.util.List;

public interface IBookService {

    /**
     * 插入书籍
     * @param book
     * @return
     * @throws BookDuplicateException
     * @throws InsertException
     */
    void insertbook(Book book) throws BookDuplicateException, InsertException;

    /**
     * 删除书籍
     * @param book
     * @return
     * @throws DeleteException
     * @throws BookNotFoundException
     */
    void deletebook(Book book) throws DeleteException, BookNotFoundException;

    /**
     * 修改书籍内容
     * @param book
     * @throws BookNotFoundException
     * @throws UpdateException
     */
    void updatebook(Book book) throws BookNotFoundException, UpdateException;

    /**
     * 展示固定书籍(某一类)
     * @return
     * @throws BookNotFoundException
     */
    List<Book> showBooks(String type) throws BookNotFoundException;

    /**
     * 搜索书籍
     * @param search
     * @return
     * @throws BookNotFoundException
     */
    List<Book> searchBooks(String search) throws BookNotFoundException;

    /**
     * 搜索书籍
     * @param bid
     * @return
     * @throws BookNotFoundException
     */
    Book getBookById(Integer bid) throws BookNotFoundException;

}
