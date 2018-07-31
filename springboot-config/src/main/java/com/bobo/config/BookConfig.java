package com.bobo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by evildoerDb on 2018/7/31 10:14
 */
@Component
@ConfigurationProperties(prefix = "book")
@Data
public class BookConfig {

    private String name;

    private String writer;

}
