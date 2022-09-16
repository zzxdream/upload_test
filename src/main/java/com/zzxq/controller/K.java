package com.zzxq.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.ResponseEntity;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZZXQ
 * @Date: 2022/6/29 9:55
 * @Describe:
 */
@RestController("abc")
public class K implements InitializingBean {
    
    
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("11111111111111111111111111111111111");
    }

    
    
    public K() {
        System.out.println("构造函数");
    }
    
    @PostConstruct
    public void a() {
        System.out.println("postConstruct");
    }

}
