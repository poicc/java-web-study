package com.crq.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * @author crq
 */
@WebServlet("/req")
public class ReqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Protocol:" + request.getProtocol());
        System.out.println("ContextPath:" + request.getContextPath());
        System.out.println("ServletPath:" + request.getServletPath());
        System.out.println("QueryString:" + request.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Protocol:" + request.getProtocol());
        System.out.println("ServletPath:" + request.getServletPath());
        System.out.println(request.getParameter("username"));

    }
}
