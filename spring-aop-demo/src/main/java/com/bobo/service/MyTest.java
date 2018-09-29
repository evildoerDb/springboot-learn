package com.bobo.service;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by evildoerdb_ on 2018/9/26
 */
public class MyTest {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new GreetImpl()); //创建目标对象
        proxyFactory.addAdvice(new GreetBeforeAndAfter()); //创建增强对象

        Greet greet = new GreetImpl();
        greet.sayHello("jack");
    }
}
