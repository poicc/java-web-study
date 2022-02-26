package com.crq.bookonline.listener;

import com.crq.bookonline.entity.Book;
import com.crq.bookonline.entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 上下文加载监听 在服务器启动的时候即刻生效 用来生成用户数据和图书数据
 * @author: crq
 * @create: 2022-02-24 13:23
 **/
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 容器初始化方法
     * @param sce sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        //创建并生成用户数据列表
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1, "aaa@qq.com", "698d51a19d8a121ce581499d7b701668", "mqxu", "user1.jpg", "江苏南京", LocalDate.of(2018, 6, 11)),
                new User(2, "18851699003", "698d51a19d8a121ce581499d7b701668", "poicc", "user2.jpg", "湖南衡阳", LocalDate.of(2022, 2, 24))
        };
        userList = Arrays.asList(users);

        //创建并生成图书数据列表
        List<Book> bookList = new ArrayList<>(10);
        Book[] books = {
                new Book(1, "鬼灭之刃 粤配版", "1.png", "更新至第11话"),
                new Book(2, "秘密内幕 女警的反击", "2.jpg", "更新至第8话"),
                new Book(3, "东方少年", "3.png", "更新至第8话"),
                new Book(4, "东京24区", "4.png", "更新至第4话"),
                new Book(5, "里亚德录大地", "5.png", "更新至第8话"),
                new Book(6, "鬼灭之刃 粤配版", "6.png", "更新至第10话"),
                new Book(7, "在下坂本,有何贵干？总配版", "7.png", "更新至第9话"),
                new Book(8, "自从贤者弟子的闲着", "8.png", "更新至第7话")

        };
        bookList = Arrays.asList(books);

        //获得全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和图书列表数据记入，整个应用可以共享
        servletContext.setAttribute("userList", userList);
        servletContext.setAttribute("bookList", bookList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");
    }
}
