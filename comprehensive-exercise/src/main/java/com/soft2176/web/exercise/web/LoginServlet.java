package com.soft2176.web.exercise.web;

import com.soft2176.web.exercise.entity.User;
import com.soft2176.web.exercise.service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * 登录逻辑处理
 *
 * @author crq
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调用service进行登录
        User user = userService.login(username, password);
        //判断
        if(user != null) {
            //是否勾选了“记住我”
            String remember = request.getParameter("remember");
            if("on".equals(remember)) {
                System.out.println("需要记录Cookie");
                //创建Cookie对象
                Cookie cUserName = new Cookie("username", username);
                Cookie cPassword = new Cookie("password", password);
                //设置存货时间
                cUserName.setMaxAge(60 * 60 * 24 * 7);
                cPassword.setMaxAge(60 * 60 * 24 * 7);

                response.addCookie(cUserName);
                response.addCookie(cPassword);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/index");
        } else {
            //登录失败 记录信息
            request.setAttribute("msg","用户名或密码错误");
            //转发
            request.getRequestDispatcher("/result.jsp").forward(request,response);

        }
    }
}
