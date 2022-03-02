package com.soft.ajax.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description: AxiosServlet-接收axios请求
 * @author: crq
 * @create: 2022-03-02 08:52
 **/
@WebServlet(urlPatterns = "/axiosServlet")
@Slf4j
public class AxiosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        log.info("username:" + username);
//        resp.getWriter().write("Hello Ajax~" + username);
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        log.info("username:" + username);
        resp.getWriter().write("Hello Ajax~" + username);
    }
}
