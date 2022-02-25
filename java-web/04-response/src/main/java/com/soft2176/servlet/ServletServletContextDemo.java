package com.soft2176.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * 获取文件的真实路径（服务器）
 * @author crq
 */
@WebServlet(urlPatterns = "/path")
public class ServletServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到ServletContext对象
        ServletContext context = this.getServletContext();
        //访问webapp目录下的文件
        String bPath = context.getRealPath("/b.txt");
        System.out.println(bPath);
        //WEB-INF目录下的资源访问
        String aPath = context.getRealPath("/WEB-INF/a.txt");
        System.out.println(aPath);
        //src目录或子目录下的资源访问
        String cPath = context.getRealPath("/WEB-INF/classes/com/soft2176/servlet/c.txt");
        System.out.println(cPath);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
