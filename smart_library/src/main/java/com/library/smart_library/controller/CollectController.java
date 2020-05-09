package com.library.smart_library.controller;

import com.library.smart_library.entity.Book;
import com.library.smart_library.entity.Collect;
import com.library.smart_library.service.ICollectService;
import com.library.smart_library.service.ex.ServiceException;
import com.library.smart_library.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.function.BinaryOperator;

@RestController
public class CollectController extends BaseController{

    @Autowired
    private ICollectService collectService;

    @PostMapping("/collect_book")
    public ResponseResult<Void> collectBook(Collect collect, HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<>();
        try {
            Integer uid = getUidFromSession(session);
            collect.setUid(uid);
            collectService.collectBook(collect);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    @PostMapping("/getCollectByUid")
    public ResponseResult<List<Collect>> getByUid(HttpSession session){
        ResponseResult<List<Collect>> rr = new ResponseResult<>();
        try{
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            List<Collect> data = collectService.getByUid(uid);
            rr.setState(200);
            rr.setData(data);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }

    @RequestMapping("/cancelCollect")
    public ResponseResult<Void> cancelCollect(Integer bid,HttpSession session){
        ResponseResult<Void> rr = new ResponseResult<>();
        try {
            Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
            Collect collect = new Collect();
            collect.setUid(uid);
            collect.setBid(bid);
            collectService.cancelCollect(collect);
            System.out.println("bid="+bid+"uid="+uid);
            rr.setState(200);
        }catch (ServiceException e){
            rr.setState(2);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }
}
