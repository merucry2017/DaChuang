package com.library.smart_library.controller;

import com.library.smart_library.entity.Comment;
import com.library.smart_library.service.ICommentService;
import com.library.smart_library.service.ex.ServiceException;
import com.library.smart_library.util.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController extends BaseController {

    @Autowired
    private ICommentService commentService;

    @PostMapping("/addComment")
    public ResponseResult<Void> addComment(Comment comment,
                                           HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<>();

        try{
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            comment.setUid(uid);
            commentService.insertComment(comment);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }

        return rr;
    }

    @PostMapping("/findCommentByBid")
    public ResponseResult<List<Comment>> findByBid(@Param("bid") Integer bid){
        ResponseResult<List<Comment>> rr = new ResponseResult<>();

        try{
            List<Comment> data = commentService.findByBid(bid);
            System.out.println(data.get(0).getCreated_time());
            rr.setState(200);
            rr.setData(data);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }
}
