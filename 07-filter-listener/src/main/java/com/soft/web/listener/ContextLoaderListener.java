package com.soft.web.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-04 14:17
 **/
@WebListener
public class ContextLoaderListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {
    private static Map<String, Object> sessionMap;

    public ContextLoaderListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //加载资源
        ServletContext servletContext = sce.getServletContext();
        System.out.println("ContextLoaderListener初始化，加载资源...");
        sessionMap = new HashMap<>(8);
        sce.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //释放资源
        System.out.println("ContextLoaderListener销毁，释放资源...");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated，创建了新的会话");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed，销毁了会话");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println(session.getAttribute("username") + "上线了...");
        sessionMap.put(session.getId(), session.getAttribute("username"));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        HttpSession session = event.getSession();
        System.out.println(session.getAttribute("username") + "下线了...");
        sessionMap.remove(session.getId(), session.getAttribute("username"));
    }

}
