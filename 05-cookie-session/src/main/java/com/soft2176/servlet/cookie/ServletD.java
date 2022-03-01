package com.soft2176.servlet.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * URL编码
 *
 * @author crq
 */
@WebServlet("/servletD")
@Slf4j
public class ServletD extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getAttribute("name");
        name = URLDecoder.decode(name, StandardCharsets.UTF_8);
        log.info(name);
        response.setContentType("text/plain;charset=utf-8");
        response.getWriter().write(name);
        response.getWriter().close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
