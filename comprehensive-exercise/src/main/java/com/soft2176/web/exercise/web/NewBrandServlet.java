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

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @description: 接收json参数，新建brand
 * @author: crq
 * @create: 2022-03-03 11:24
 **/
@WebServlet(urlPatterns = "/newBrand")
@Slf4j
public class NewBrandServlet extends HttpServlet {
    private final BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //如果⽤ request.getParameter 是错的，不能接收json的数据
//        String brandName = request.getParameter("brandName");
//        System.out.println(brandName);
        //⽤缓冲字符输⼊流来获取请求体数据
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader br = request.getReader();
        while ((line = br.readLine()) != null) {
            json.append(line);
        }
        log.info(String.valueOf(json));
        //将JSON字符串转为Java对象
        Brand brand = JSON.parseObject(json.toString(), Brand.class);
        //调⽤service 添加
        brandService.add(brand);
        //响应成功
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}