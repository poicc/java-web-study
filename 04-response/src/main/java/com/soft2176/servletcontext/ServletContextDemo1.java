package com.soft2176.servletcontext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description: 两种方式获取ServletContext对象
 * @author: crq
 * @create: 2022-02-25 16:19
 **/
@WebServlet("/context1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取
        ServletContext ctx1 = req.getServletContext();
        //通过当前的servlet对象获取
        ServletContext ctx2 = this.getServletContext();
        System.out.println(ctx1 == ctx2);
    }
}
