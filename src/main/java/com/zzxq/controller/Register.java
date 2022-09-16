package com.zzxq.controller;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: ZZXQ
 * @Date: 2021/11/29 0:43
 */
public class Register implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition logger = new RootBeanDefinition(Logger.class);
        RootBeanDefinition a = new RootBeanDefinition(A.class);
        registry.registerBeanDefinition("logger", logger);
        registry.registerBeanDefinition("a", a);
    }
}
