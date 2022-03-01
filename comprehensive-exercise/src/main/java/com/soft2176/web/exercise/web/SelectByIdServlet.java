package com.soft2176.web.exercise.web;

import com.soft2176.web.exercise.entity.Brand;
import com.soft2176.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @description: 根据id查询品牌处理逻辑
 * @author: crq
 * @create: 2022-03-01 16:34
 **/
@WebServlet(urlPatterns = "/selectById")
@Slf4j
public class SelectByIdServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收id
        String id = request.getParameter("id");
        log.info(id);
        //2. 调用service查询
        Brand brand = brandService.selectById(Integer.parseInt(id));
        //3. 存储到request中
        request.setAttribute("brand", brand);
        //4. 转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }
}
