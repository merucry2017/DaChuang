package com.library.smart_library.impl;

import com.library.smart_library.entity.Book;
import com.library.smart_library.entity.Collect;
import com.library.smart_library.mapper.CollectMapper;
import com.library.smart_library.service.ICollectService;
import com.library.smart_library.service.ex.BookDuplicateException;
import com.library.smart_library.service.ex.BookNotFoundException;
import com.library.smart_library.service.ex.InsertException;
import com.library.smart_library.service.ex.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectServiceImpl implements ICollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public void collectBook(Collect collect) throws InsertException, BookDuplicateException {
        Book result = collectMapper.findByUidAndBid(collect.getUid(),collect.getBid());
        if(result==null){
            System.out.println("collect beginning.....");
            collect.setIs_delete("0");
            //设置创建时间
            Date now = new Date();
//            System.out.println("Can find bid " + collect.getBid());
//            System.out.println("Can find btype "+ collect.getBtype());
            collect.setCreated_time(now);
            collectMapper.insert(collect);
        }else {
            throw new BookDuplicateException(
                 "收藏失败!尝试收藏的书籍 "+result.getTitle()+" 已经存在!"
            );
        }
    }

    @Override
    public void cancelCollect(Collect collect) throws BookNotFoundException {
        Book result = collectMapper.findByUidAndBid(collect.getUid(),collect.getBid());
        if(result!=null){
            System.out.println("cancelcollect beginning.....");
            collectMapper.delete(collect);
        }else {
            throw new BookNotFoundException(
                "取消收藏失败!尝试取消收藏的书籍 "+collect.getTitle()+" 不存在!"
            );
        }
    }

    @Override
    public List<Collect> getByUid(Integer uid) throws NotFoundException {
        return collectMapper.findByUid(uid);
    }
}
