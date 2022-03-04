package com.soft.web.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-04 08:31
 **/
//@WebFilter(urlPatterns = "/*")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("111111");
        //放行 让请求访问其本该访问的资源
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("33333");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1销毁");
    }
}
