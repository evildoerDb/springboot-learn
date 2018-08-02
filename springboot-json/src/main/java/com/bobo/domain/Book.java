package com.bobo.domain;

import lombok.Data;

/**
 * Created by evildoerDb on 2018/8/2 10:52
 */

@Data
public class Book {

    private String name;

    private String writer;

    public Book(String name, String writer) {
        this.name = name;
        this.writer = writer;
    }
}
