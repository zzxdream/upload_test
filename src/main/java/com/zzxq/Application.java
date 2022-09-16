package com.zzxq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author: ZZXQ
 * @Date: 2021/10/24 19:00
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = "com.zzxq.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println(1);
        System.out.println(1);
    }
}
