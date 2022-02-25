package com.soft2176.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * response响应练习 设置响应体、重定向
 * @author crq
 */
@WebServlet(urlPatterns = "/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo1");
        //设置状态码为302:重定向
//        response.setStatus(302);
//        //设置响应头
//        response.setHeader("location","/responseDemo2");
        //通过request传递数据
        request.setAttribute("msg","hello response");
        request.getRequestDispatcher("/responseDemo2").forward(request,response);
//        response.setHeader("msg","hello");
//        //简单的写法 重定向 可以跨域
//        response.sendRedirect("https://www.baidu.com");
        //加一个时间 三秒后重定向
    }
}
