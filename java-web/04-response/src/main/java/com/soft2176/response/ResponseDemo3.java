package com.soft2176.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * response对象练习 向客户端返回字符数据
 * @author crq
 */
@WebServlet(urlPatterns = "/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = "JavaWeb开发";
        response.setContentType("text/plain;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(info);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
