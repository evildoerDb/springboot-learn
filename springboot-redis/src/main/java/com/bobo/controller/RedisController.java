package com.bobo.controller;

import com.bobo.service.RedisService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by evildoerDb on 2018/8/1 15:01
 */

@RestController
@RequestMapping("/redis")
public class RedisController {


    @Autowired
    private RedisService redisService;

    @RequestMapping("/get")
    public String getKey(@RequestParam("key") String key){

        Gson gson = new Gson();
        return gson.toJson(redisService.getValueByKey(key));
    }

    @RequestMapping("/set")
    public String set(@RequestParam("key")String key, @RequestParam("value")String value){

        redisService.setKey(key,value);
        return key +" : " + value;
    }
}
