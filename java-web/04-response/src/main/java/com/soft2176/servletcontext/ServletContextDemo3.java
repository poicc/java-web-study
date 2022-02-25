package com.soft2176.servletcontext;

import com.soft2176.domain.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @description: 通过ServletContext共享数据
 * @author: crq
 * @create: 2022-02-25 16:19
 **/
@WebServlet("/context3")
public class ServletContextDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request对象获取
        ServletContext context = req.getServletContext();
        User user = new User(2, "18851699003", "698d51a19d8a121ce581499d7b701668", "poicc", "user2.jpg", "湖南衡阳", LocalDate.of(2022, 2, 24));
        context.setAttribute("data",user);
        resp.sendRedirect("/responseDemo2");
    }
}
