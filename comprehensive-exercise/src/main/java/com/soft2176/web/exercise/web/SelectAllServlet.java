package com.soft2176.web.exercise.web;

import com.alibaba.fastjson.JSON;
import com.soft2176.web.exercise.entity.Brand;
import com.soft2176.web.exercise.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * @description: 根据id查询品牌处理逻辑
 * @author: crq
 * @create: 2022-03-01 16:34
 **/
@WebServlet(urlPatterns = "/selectAllServlet")
@Slf4j
public class SelectAllServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用Service查询
        List<Brand> brands=brandService.selectAll();
        //将集合转换为JSON数据 序列化
        String jsonString = JSON.toJSONString(brands);
        //响应数据 application/json
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

