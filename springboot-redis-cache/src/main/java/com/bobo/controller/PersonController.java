package com.bobo.controller;

import com.bobo.domain.Person;
import com.bobo.service.PersonService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by evildoerDb on 2018/8/2 11:35
 */
@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     *
     * @param person
     * @param bindingResult
     * @return
     */
    @RequestMapping("/add")
    public String add(@Valid Person person, BindingResult bindingResult){

        Gson gson = new Gson();
        if (bindingResult.hasErrors()){
            log.info(bindingResult.getFieldError().getDefaultMessage());
        }

        int result = personService.add(person);
        if (result == -1){
            return "出错了";
        }
        else {
            return gson.toJson(person);
        }
    }

    /**
     *
     * @param name
     * @return
     */
    @RequestMapping("/get")
    public Person getPerson(@RequestParam("name")String name){
        return personService.getPerson(name);
    }


    /**
     *
     * @param name  username
     * @param sex   usersex
     * @param age   userage
     * @return
     */
    @RequestMapping("/update")
    public Person update(@RequestParam("name")String name, @RequestParam("sex")String sex, @RequestParam("age")Integer age){
        return personService.updatePersonByName(name,sex,age);
    }

}
