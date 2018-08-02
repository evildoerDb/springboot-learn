package com.bobo.service;

import com.bobo.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by evildoerDb on 2018/8/2 11:29
 */
@Service
@Slf4j
public class PersonService {

    private HashMap<String,Person> personMap = new HashMap<>();


    public Integer add(Person person){

        try{
            personMap.put(person.getName(),person);
            return 0;
        }catch (Exception e){
            log.info(e.getLocalizedMessage());
        }
        return -1;
    }

    @Cacheable(value = "cache1")
    public Person getPerson(String name){
        return personMap.get(name);
    }

    @CachePut(value = "cache1")
    public Person updatePersonByName(String name,String sex,Integer age){
        Person person = new Person(name,sex,age);

        personMap.put(name,person);

        return person;
    }
}
