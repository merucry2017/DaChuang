package com.library.smart_library.impl;

import com.library.smart_library.entity.Question;
import com.library.smart_library.mapper.QuestionMapper;
import com.library.smart_library.service.IQuestionService;
import com.library.smart_library.service.ex.DuplicateException;
import com.library.smart_library.service.ex.InsertException;
import com.library.smart_library.service.ex.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void insert() {

    }

    @Override
    public void update() {

    }

    @Override
    public void collectQuestion(Question question) throws InsertException {
        Question result = questionMapper.findByUidAndQid(question.getUid(),question.getQid());
        if(result==null){
            System.out.println(question.getUid());
            question.setIs_delete("0");
            Date now = new Date();
            question.setCreated_time(now);
            questionMapper.collectQuestion(question);
        }else {
            throw new DuplicateException(
               "该问题已经存在于收藏表中！不能重复收藏"
            );
        }
    }

    @Override
    public List<Question> findByBid(Integer bid) throws NotFoundException {
        return questionMapper.findByBid(bid);
    }

    @Override
    public List<Question> findByUid(Integer uid) throws NotFoundException {
        return questionMapper.findByUid(uid);
    }

    @Override
    public void cancelQuestion(Question question) throws NotFoundException {
        Question result = questionMapper.findByUidAndQid(question.getUid(),question.getQid());
        if(result!=null){
            questionMapper.cancelQuestion(question);
        }else{
            throw new NotFoundException(
                "该收藏问题不存在！无法取消收藏"
            );
        }
    }
}
