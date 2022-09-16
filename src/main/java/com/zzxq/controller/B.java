package com.zzxq.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;





/**
 * @Author: ZZXQ
 * @Date: 2021/11/28 23:28
 */
@Configuration
@Import(Register.class)
public class B {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(B.class);
        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println("beanDefinitionName = " + name);
        }
    }
}















