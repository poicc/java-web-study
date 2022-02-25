package com.soft2176.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * 重定向
 * @author crq
 */
@WebServlet(urlPatterns = "/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ResponseDemo2被访问");
        ServletContext context = request.getServletContext();
        Object data = context.getAttribute("data");
//        Object msg = request.getAttribute("msg");
        System.out.println(data);
    }
}
