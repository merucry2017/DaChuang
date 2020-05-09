package com.library.smart_library.service;

import com.library.smart_library.entity.Comment;
import com.library.smart_library.service.ex.DeleteException;
import com.library.smart_library.service.ex.InsertException;
import com.library.smart_library.service.ex.NotFoundException;
import com.library.smart_library.service.ex.UpdateException;

import java.util.List;

public interface ICommentService {

    /**
     * 插入评论
     * @param comment
     * @throws InsertException
     */
    void insertComment(Comment comment) throws InsertException;

    /**
     * 删除评论
     * @param comment
     * @throws NotFoundException
     */
    void deleteComment(Comment comment) throws NotFoundException, DeleteException;

    /**
     * 更新评论
     * @param comment
     * @throws NotFoundException
     * @throws UpdateException
     */
    void updateComment(Comment comment) throws NotFoundException, UpdateException;

    /**
     * 查找某个用户的所有评论
     * @param uid
     * @return
     * @throws NotFoundException
     */
    List<Comment> findByUid(Integer uid) throws NotFoundException;

    /**
     * 查找某本书的所有评论
     * @param bid
     * @return
     * @throws NotFoundException
     */
    List<Comment> findByBid(Integer bid) throws NotFoundException;
}
