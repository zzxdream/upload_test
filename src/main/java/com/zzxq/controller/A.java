package com.zzxq.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;


/**
 * @Author: ZZXQ
 * @Date: 2021/11/28 23:28
 */
public class A implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Logger.class.getName(), C.class.getName()};
    }
}
