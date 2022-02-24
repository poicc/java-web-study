package com.crq.bookonline.servlet;

import com.crq.bookonline.entity.Book;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @description: 获取所以图书数据 并通过服务器转发跳转到主页
 * @author: crq
 * @create: 2022-02-23 21:09
 **/
@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得各个Servlet共享的对象
        ServletContext sc = this.getServletContext();
        //取得全局应用对象中的变量
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        //存入request
        req.setAttribute("bookList", bookList);
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().print(bookList.toString());
        //通过服务器端转发，将数据带过去，并保持地址栏不变
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
