package com.library.smart_library.impl;

import com.library.smart_library.entity.Book;
import com.library.smart_library.entity.User;
import com.library.smart_library.mapper.BookMapper;
import com.library.smart_library.service.IBookService;
import com.library.smart_library.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServicelmpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void insertbook(Book book) throws BookDuplicateException, InsertException {
        String writer = book.getWriter();
        String title = book.getTitle();
        Book result = findByWriterAndTitle(writer,title);
        if(result==null){
            book.setIs_delete("0");

            //设置创建时间和修改时间
            Date now = new Date();
            book.setCreated_time(now);
            book.setModified_time(now);

            insert(book);
        }else {
            throw new UsernameDuplicateException(
                    "插入失败！您尝试插入的书籍(" + title + ")已经存在！"
            );
        }
    }

    /**
     * 调用bookMapper方法
     * @param book
     */
    private void insert(Book book) {
        Integer rows = bookMapper.insert(book);
        if(rows!=1){
            throw new InsertException(String.valueOf(null));
        }
    }

    /**
     * 调用bookMapper的方法
     * @param writer
     * @param title
     * @return
     */
    private Book findByWriterAndTitle(String writer, String title) {
        return bookMapper.findByWriterAndTitle(writer,title);
    }

    @Override
    public void deletebook(Book book) throws DeleteException, BookNotFoundException {
        Integer bid = book.getBid();
        Book result = findByBid(bid);
        if(result!=null){
            bookMapper.delete(book);
        }else {
            throw new UsernameDuplicateException(
                    "删除失败！您尝试删除的书籍(" + book.getTitle() + ")不存在！"
            );
        }
    }

    /**
     * 调用bookMapper方法
     * @param bid
     * @return
     */
    private Book findByBid(Integer bid) {
        return bookMapper.findByBid(bid);
    }

    @Override
    public void updatebook(Book book) throws BookNotFoundException, UpdateException {
        Integer bid = book.getBid();
        Book result = findByBid(bid);
        if(result!=null){
            bookMapper.update(book);
        }else {
            throw new UsernameDuplicateException(
                    "修改失败！您尝试修改的书籍(" + book.getTitle() + ")不存在！"
            );
        }
    }

    /**
     * 根据类型搜索书籍
     * @param type
     * @return
     * @throws BookNotFoundException
     */
    @Override
    public List<Book> showBooks(String type) throws BookNotFoundException {
        return bookMapper.findByBtype(type);
    }

    /**
     * 根据关键字搜索
     * @param search
     * @return
     * @throws BookNotFoundException
     */
    @Override
    public List<Book> searchBooks(String search) throws BookNotFoundException {
        return bookMapper.findBySearch(search);
    }

    /**
     * 通过bid查找书本详细信息
     * @param bid
     * @return
     * @throws BookNotFoundException
     */
    @Override
    public Book getBookById(Integer bid) throws BookNotFoundException {
        return bookMapper.findByBid(bid);
    }

}
