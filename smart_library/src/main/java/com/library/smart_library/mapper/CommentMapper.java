package com.library.smart_library.mapper;

import com.library.smart_library.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    Integer insert(Comment comment);

    Integer delete(Integer uid,Integer bid,String comment);

    void update(Comment comment);

    Comment findByCid(Integer cid);

    List<Comment> findByUid(Integer uid);

    List<Comment> findByBid(Integer bid);
}
