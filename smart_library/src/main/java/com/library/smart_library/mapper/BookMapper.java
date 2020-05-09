package com.library.smart_library.mapper;

import com.library.smart_library.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 插入书籍
     * @param book
     * @return
     */
    Integer insert(Book book);

    /**
     * 删除书籍
     * @param book
     * @return
     */
    Integer delete(Book book);

    /**
     * 更新书籍
     * @param book
     * @return
     */
    Integer update(Book book);

    /**
     * 通过writer和title查找书籍
     * @param title
     * @return
     */
    Book findByWriterAndTitle(@Param("writer") String writer ,@Param("title") String title);

    /**
     * 通过bid查找书名
     * @param bid
     * @return
     */
    Book findByBid(Integer bid);

    /**
     * 通过类型查找书籍
     * @param btype
     * @return
     */
    List<Book> findByBtype(String btype);

    /**
     * 通过关键字查找书籍
     * @param search
     * @return
     */
    List<Book> findBySearch(String search);

}
