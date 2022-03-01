package com.soft2176.servlet.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description:
 * @author: crq
 * @create: 2022-02-28 10:43
 **/
@WebServlet(urlPatterns = "/servletB")
@Slf4j
public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("username".equals(name)) {
                String value = cookie.getValue();
                log.info("name:" + value);
            }
            if ("info".equals(name)) {
                String value = cookie.getValue();
                log.info("info:" + value);
            }
            if ("info1".equals(name)) {
                String value = cookie.getValue();
                log.info("info1:" + value);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
