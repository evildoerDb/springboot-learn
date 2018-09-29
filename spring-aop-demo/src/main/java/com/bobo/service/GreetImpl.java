package com.bobo.service;

/**
 * Created by evildoerdb_ on 2018/9/26
 */
public class GreetImpl implements Greet {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " +name);
    }
}
