//package com.zzxq.filter;
//
//import org.apache.catalina.Session;
//import org.apache.catalina.connector.Request;
//import org.apache.catalina.connector.RequestFacade;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//
///**
// * @Author: ZZXQ
// * @Date: 2021/11/22 13:27
// */
//@Configuration
//public class SessionFilter implements Filter {
//
//    Map<String, HttpSession> sessionMap = new HashMap<>();
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        String sessionId = null;
//        HttpSession session = null;
//
//        Cookie[] cookies = req.getCookies();
//        if(null != cookies) {
//            for (Cookie cookie : cookies) {
//                if(cookie.getName().equals("JSESSIONID")){
//                    sessionId = cookie.getValue();
//                }
//            }
//        }
//        if(null == sessionId) {
//            sessionId = UUID.randomUUID().toString();
//            Cookie ck = new Cookie("JSESSIONID", sessionId);
//            sessionMap.put(sessionId, ((HttpServletRequest) request).getSession());
//        }
//
//        session = sessionMap.get(sessionId);
//        System.out.println(session);
//        System.out.println("sessionId = " + sessionId);
////        System.out.println("===");
////        System.out.println(req.getSession().getId());
//
//    }
//}
