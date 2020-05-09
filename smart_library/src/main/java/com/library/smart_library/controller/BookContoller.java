package com.library.smart_library.controller;

import com.library.smart_library.entity.Book;
import com.library.smart_library.entity.User;
import com.library.smart_library.service.IBookService;
import com.library.smart_library.service.IUserService;
import com.library.smart_library.util.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class BookContoller extends BaseController{

    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;

    @GetMapping("/show_books")
    public ResponseResult<List<Book>> showBooks(HttpSession session){
        //获取要推荐的书籍
        System.out.println("showBooks beginning......");
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        User user = userService.getByUid(uid);
        String[] type = user.getMajor().split("_");
//        System.out.println("can get major" + type[1]);
        List<Book> data = bookService.showBooks(type[1]);
        return new ResponseResult<>(SUCCESS, data);
    }

    @GetMapping("/{id}/details")
    public ResponseResult<Book> getBookById(
            @PathVariable("id") Integer bid) {
        System.out.println("/{id}/details beginning......");
        // 执行
        Book data = bookService.getBookById(bid);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }

    @GetMapping("/search")
    public ResponseResult<List<Book>> getBookBySearch(@Param("search") String search){

        System.out.println("search beginning......" + search);

        List<Book> data = bookService.searchBooks(search);
        return new ResponseResult<>(SUCCESS, data);
    }

}
