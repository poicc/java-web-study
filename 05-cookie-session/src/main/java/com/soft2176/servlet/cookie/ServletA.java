package com.soft2176.servlet.cookie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * 存cookie
 * @author crq
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("username","张三");
        Cookie cookie1 = new Cookie("info","zhangsan");
        Cookie cookie2 = new Cookie("info1","♥");
        //对Cookie持久化
        cookie.setMaxAge(60 * 60 * 24 * 7);

        //通过response发送Cookie
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
