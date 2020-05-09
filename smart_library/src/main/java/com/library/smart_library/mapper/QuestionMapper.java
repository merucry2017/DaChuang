package com.library.smart_library.mapper;

import com.library.smart_library.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionMapper {

    Integer inserr();

    void delete();

    void update();

    List<Question> findByBid(Integer bid);

    List<Question> findByUid(Integer uid);

    /**
     * 查找收藏的问题
     * @param uid
     * @param qid
     * @return
     */
    Question findByUidAndQid(@Param("uid") Integer uid, @Param("qid") Integer qid);

    /**
     * 收藏问题
     * @param question
     */
    void collectQuestion(Question question);

    /**
     * 取消收藏问题
     * @param question
     */
    void cancelQuestion(Question question);
}
