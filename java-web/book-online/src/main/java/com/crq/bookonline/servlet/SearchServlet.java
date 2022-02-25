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
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description:
 * @author: crq
 * @create: 2022-02-24 21:32
 **/
@WebServlet(urlPatterns = "/index.do")
public class SearchServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("searchName");
        ServletContext sc = this.getServletContext();
        List<Book> bookList = (List<Book>) sc.getAttribute("bookList");
        System.out.println(searchName);
        Stream<Book> bookStream = bookList.stream().filter(
                book1 -> book1.getName().contains(searchName)
        );
        List<Book> books = bookStream.collect(Collectors.toList());
//        for (int i = 0;i<bookList.size();i++) {
//            Pattern p = Pattern.compile(searchName);
//            Matcher m  = p.matcher(bookList.get(i).getName());
//            while (!m.find()) {
//                bookList.remove(i);
//            }
//        }
        req.setAttribute("bookList", books);
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().print(bookList.toString());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
