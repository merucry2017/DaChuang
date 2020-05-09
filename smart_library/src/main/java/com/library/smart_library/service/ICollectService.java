package com.library.smart_library.service;

import com.library.smart_library.entity.Collect;
import com.library.smart_library.service.ex.BookDuplicateException;
import com.library.smart_library.service.ex.BookNotFoundException;
import com.library.smart_library.service.ex.InsertException;
import com.library.smart_library.service.ex.NotFoundException;

import java.util.List;

public interface ICollectService {

    /**
     * 收藏书籍
     * @param collect
     * @throws InsertException
     * @throws BookDuplicateException
     */
    void collectBook(Collect collect) throws InsertException, BookDuplicateException;

    /**
     * 取消收藏
     * @param collect
     * @throws BookNotFoundException
     */
    void cancelCollect(Collect collect) throws BookNotFoundException;

    /**
     * 查找某用户所有收藏
     * @param uid
     * @return
     * @throws NotFoundException
     */
    List<Collect> getByUid(Integer uid) throws NotFoundException;
}
