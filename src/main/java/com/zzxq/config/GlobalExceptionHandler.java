//package com.zzxq.config;
//
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: ZZXQ
// * @Date: 2021/12/10 19:44
// */
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Map<String, Object> handleException(Exception e) {
//        Map<String, Object> result = new HashMap<>();
//        result.put("code", "500");
//        result.put("msg", "报错啦");
//        return result;
//    }
//
//    @ExceptionHandler(value =NullPointerException.class)
//    @ResponseBody
//    public Map<String, Object> exceptionHandler(HttpServletRequest req, NullPointerException e){
//        Map<String, Object> result = new HashMap<>();
//        result.put("code", "500");
//        result.put("msg", "空指针");
//        return result;
//    }
//}
