package com.library.smart_library.mapper;

import com.library.smart_library.entity.Book;
import com.library.smart_library.entity.Collect;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

@Mapper
public interface CollectMapper {

    /**
     * 插入书籍
     * @param collect
     * @return
     */
    Integer insert(Collect collect);

    /**
     * 删除书籍
     * @param collect
     * @return
     */
    Integer delete(Collect collect);

    /**
     * 通过uid和bid找收藏书籍
     * @param uid
     * @return
     */
    Book findByUidAndBid(@Param("uid") Integer uid,@Param("bid") Integer bid);

    /**
     * 通过uid查找收藏书籍
     * @param uid
     * @return
     */
    List<Collect> findByUid(Integer uid);

}
