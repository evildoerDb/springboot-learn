package com.bobo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by evildoerDb on 2018/7/31 10:01
 */

@RestController
@RequestMapping("/spring")
public class HelloController {


    @GetMapping("/hello")
    public String sayHello(){
        return "hello spring";
    }
}
