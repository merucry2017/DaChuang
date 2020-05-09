package com.library.smart_library.impl;

import com.library.smart_library.entity.Comment;
import com.library.smart_library.mapper.CommentMapper;
import com.library.smart_library.service.ICommentService;
import com.library.smart_library.service.ex.DeleteException;
import com.library.smart_library.service.ex.InsertException;
import com.library.smart_library.service.ex.NotFoundException;
import com.library.smart_library.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void insertComment(Comment comment) throws InsertException {
        System.out.println("insert comment........");
        comment.setIs_delete("0");
        //设置创建时间
        Date now = new Date();
        comment.setCreated_time(now);
        commentMapper.insert(comment);
    }

    @Override
    public void deleteComment(Comment comment) throws NotFoundException, DeleteException {
        Comment result = commentMapper.findByCid(comment.getCid());
        if(result!=null){
            commentMapper.delete(comment.getUid(),comment.getBid(),comment.getComment());
        }else {
            throw new NotFoundException(
                 "该记录已删除！"
            );
        }
    }

    @Override
    public void updateComment(Comment comment) throws NotFoundException, UpdateException {
        Comment result = commentMapper.findByCid(comment.getCid());
        if(result!=null){
            commentMapper.update(comment);
        }else {
            throw new NotFoundException(
                    "该记录已删除！"
            );
        }
    }

    @Override
    public List<Comment> findByUid(Integer uid) throws NotFoundException {
        return commentMapper.findByUid(uid);
    }

    @Override
    public List<Comment> findByBid(Integer bid) throws NotFoundException {
        return commentMapper.findByBid(bid);
    }

}
