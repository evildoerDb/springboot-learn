package com.bobo.controller;

import com.bobo.domain.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by evildoerDb on 2018/8/2 10:55
 */

@RestController
@RequestMapping("/spring")
public class BookController {


    @RequestMapping("/create")
    public Book createBook(@RequestParam("name") String name, @RequestParam("writer") String writer){

        return new Book(name,writer);
    }
}
