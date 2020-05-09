package com.library.smart_library.service;

import com.library.smart_library.entity.Question;
import com.library.smart_library.service.ex.InsertException;
import com.library.smart_library.service.ex.NotFoundException;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface IQuestionService {

    void insert();

    void update();

    void collectQuestion(Question question) throws InsertException;

    List<Question> findByBid(Integer bid) throws NotFoundException;

    List<Question> findByUid(Integer uid) throws NotFoundException;

    void cancelQuestion(Question question) throws NotFoundException;
}
