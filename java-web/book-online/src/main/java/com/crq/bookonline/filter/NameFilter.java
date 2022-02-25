package com.crq.bookonline.filter;

import com.crq.bookonline.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @description: 番剧名搜索过滤
 * @author: crq
 * @create: 2022-02-24 21:10
 **/
@WebFilter(urlPatterns = "/user")
public class NameFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            ((HttpServletResponse)response).sendRedirect("/index");
        } else {
            chain.doFilter(request, response);
        }
    }
}


