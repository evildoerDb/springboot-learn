package com.bobo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by evildoerDb on 2018/7/31 10:21
 */
@Component
@Data
public class BookComponent {

    @Value("${book.name}")
    private String name;

    @Value("${book.writer}")
    private String writer;
}
