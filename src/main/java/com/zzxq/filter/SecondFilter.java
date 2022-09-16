package com.zzxq.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: ZZXQ
 * @Date: 2021/11/21 1:55
 */
public class SecondFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我是过滤器2开始");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("我是过滤器2结束");
    }
}
