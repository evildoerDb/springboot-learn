package com.bobo.controller;

import com.bobo.config.BookComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by evildoerDb on 2018/7/31 10:18
 */
@RestController
public class BookController {


    //两种配置方式
//    @Autowired
// private BookConfig bookConfig;

    @Autowired
    private BookComponent bookComponent;

    @RequestMapping("/book/getBook")
    public String getBook(){
        return "the name of book is " + bookComponent.getName() + "and the writer is " + bookComponent.getWriter();
    }
}
