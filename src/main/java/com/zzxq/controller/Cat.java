package com.zzxq.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: ZZXQ
 * @Date: 2022/7/17 9:10
 * @Describe:
 */
//@ConfigurationProperties(prefix = "config.entity.cat")
//@Component
public class Cat {

    private String name;
    private String sex;
    private int age;
    private String family;

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFamily(String family) {
        this.family = family;
    }
    // 省略getter
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", family='" + family + '\'' +
                '}';
    }
}

