package com.zzxq.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: ZZXQ
 * @Date: 2022/4/17 19:52
 * @Describe:
 */
@Component
@Order(1)
public class Cal implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("我是第一");
        System.out.println(Thread.currentThread().getId());
    }
}
