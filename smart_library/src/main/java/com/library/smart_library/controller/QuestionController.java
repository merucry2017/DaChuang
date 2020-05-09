package com.library.smart_library.controller;

import com.library.smart_library.entity.Question;
import com.library.smart_library.service.IQuestionService;
import com.library.smart_library.service.ex.ServiceException;
import com.library.smart_library.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @RequestMapping("/findQuestionByBid")
    public ResponseResult<List<Question>> findByBid(Integer bid){
        ResponseResult<List<Question>> rr = new ResponseResult<>();

        try{
            List<Question> data = questionService.findByBid(bid);
            System.out.println(data.get(0).getQuestion());
            rr.setState(200);
            rr.setData(data);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }

        return rr;
    }

    @RequestMapping("/findMyQuestionByUid")
    public ResponseResult<List<Question>> findByUid(HttpSession session){
        ResponseResult<List<Question>> rr = new ResponseResult<>();

        try{
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            List<Question> data = questionService.findByUid(uid);
            rr.setData(data);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }

        return rr;
    }

    @RequestMapping("/collectQuestion")
    public ResponseResult<Void> collectQuestion(Question question, HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<>();
        try{
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            question.setUid(uid);
            questionService.collectQuestion(question);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }
    @RequestMapping("/cancelQuestion")
    public ResponseResult<Void> cancelQuestion(Question question, HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<>();
        try{
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            question.setUid(uid);
            questionService.cancelQuestion(question);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }
}
