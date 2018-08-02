package com.bobo.domain;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by evildoerDb on 2018/8/2 11:25
 */

@Data
public class Person {

    @NotNull
    private String name;

    @NotNull
    private String sex;

    @Max(value = 60)
    @Min(value = 18)
    private Integer age;

    public Person(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Person() {
    }
}
