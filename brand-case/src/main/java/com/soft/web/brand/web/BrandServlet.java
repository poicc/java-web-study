package com.soft.web.brand.web;

import com.alibaba.fastjson.JSON;
import com.soft.web.brand.pojo.Brand;
import com.soft.web.brand.pojo.PageBean;
import com.soft.web.brand.service.BrandService;
import com.soft.web.brand.service.BrandServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-03-04 17:41
 **/
@WebServlet("/brand/**")
public class BrandServlet extends BaseServlet {
    private final BrandService brandService = new BrandServiceImpl();

    /**
     * 查询所有
     * @param request 请求对象
     * @param response 响应对象
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 添加
     * @param request 请求对象
     * @param response 响应对象
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while((line = reader.readLine()) != null) {
            json.append(line);
        }
        Brand brand = JSON.parseObject(json.toString(), Brand.class);
        brandService.add(brand);
        response.getWriter().write("success");
    }

    /**
     * 批量删除
     * @param request 请求对象
     * @param response 响应对象
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        int[] ids = JSON.parseObject(params,int[].class);
        brandService.deleteByIds(ids);
        response.getWriter().write("success");
    }

    /**
     * 分页查询
     * @param request 请求对象
     * @param response 响应对象
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);

        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    /**
     * 分页条件查询
     * @param request 请求对象
     * @param response 响应对象
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");

        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);

        StringBuilder json = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while((line = reader.readLine()) != null) {
            json.append(line);
        }
        Brand brand = JSON.parseObject(json.toString(), Brand.class);
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
