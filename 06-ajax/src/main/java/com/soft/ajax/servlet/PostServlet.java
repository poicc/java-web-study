package com.soft.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description: 处理post请求
 * @author: crq
 * @create: 2022-03-02 08:52
 **/
@WebServlet(urlPatterns = "/postHandle")
@Slf4j
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean flag = false;
        if(username.equals("zhansan") && password.equals("123")) {
            flag = true;
        }
        resp.getWriter().write(String.valueOf(flag));
    }
}
