//package com.zzxq.filter;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author: ZZXQ
// * @Date: 2021/11/21 2:11
// */
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public FilterRegistrationBean firstFilter(){
//        FilterRegistrationBean filter = new FilterRegistrationBean();
//        FirstFilter firstFilter = new FirstFilter();
//        filter.setFilter(firstFilter);
//        //配置多个过滤规则
////        List<String> urls = new ArrayList<>();
////        urls.add("/order/*");
////        urls.add("/user/*");
////        filterRegistrationBean.setUrlPatterns(urls);
//        //配置过滤规则
//        filter.addUrlPatterns("/*");
//        filter.setName("first");
//        filter.setOrder(1);
//        return filter;
//    }
//
//    @Bean
//    public FilterRegistrationBean secondFilter(){
//        FilterRegistrationBean filter = new FilterRegistrationBean();
//        SecondFilter secondFilter = new SecondFilter();
//        filter.setFilter(secondFilter);
//        //配置过滤规则
//        filter.addUrlPatterns("/*");
//        filter.setName("second");
//        filter.setOrder(2);
//        return filter;
//    }
//
//    @Bean
//    public FilterRegistrationBean aFilter(){
//        FilterRegistrationBean filter = new FilterRegistrationBean();
//        AFilter aFilter = new AFilter();
//        filter.setFilter(aFilter);
//        //配置过滤规则
//        filter.addUrlPatterns("/*");
//        filter.setName("third");
//        filter.setOrder(3);
//        return filter;
//    }
//
//    @Bean
//    public FilterRegistrationBean bFilter(){
//        FilterRegistrationBean filter = new FilterRegistrationBean();
//        BFilter bFilter = new BFilter();
//        filter.setFilter(bFilter);
//        //配置过滤规则
//        filter.addUrlPatterns("/*");
//        filter.setName("four");
//        filter.setOrder(4);
//        return filter;
//    }
//
//    @Bean
//    public FilterRegistrationBean cFilter(){
//        FilterRegistrationBean filter = new FilterRegistrationBean();
//        CFilter cFilter = new CFilter();
//        filter.setFilter(cFilter);
//        //配置过滤规则
//        filter.addUrlPatterns("/*");
//        filter.setName("five");
//        filter.setOrder(5);
//        return filter;
//    }
//}
