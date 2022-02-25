package com.soft2176.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author crq
 */
@WebServlet(urlPatterns = "/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String info = ;
        response.setContentType("text/html;charset=utf-8");
        ServletOutputStream out = response.getOutputStream();
        out.write("<h1>JavaWeb开发</h1>".getBytes(StandardCharsets.UTF_8));
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
