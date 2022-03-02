package com.soft2176.web.exercise.web;

import com.soft2176.web.exercise.entity.User;
import com.soft2176.web.exercise.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description: 验证用户名是否可用
 * @author: crq
 * @create: 2022-03-02 10:24
 **/
@WebServlet(urlPatterns = "/check")
public class CheckUserServlet extends HttpServlet {
    private static UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = User.builder().username(username).build();
        boolean flag = userService.register(user);
        resp.getWriter().write(String.valueOf(flag));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
