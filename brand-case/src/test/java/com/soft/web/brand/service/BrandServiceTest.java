package com.soft.web.brand.service;

import com.soft.web.brand.pojo.Brand;
import com.soft.web.brand.pojo.PageBean;
import org.junit.jupiter.api.Test;

import java.util.List;

class BrandServiceTest {
    private final BrandService brandService = new BrandServiceImpl();

    @Test
    void selectAll() {
        List<Brand> brands = brandService.selectAll();
        brands.forEach(System.out::println);
    }

    @Test
    void add() {
        Brand brand = new Brand();
        brand.setBrandName("测试品牌");
        brand.setCompanyName("测试品牌公司");
        brand.setDescription("测试品牌");
        brand.setOrdered(111);
        brand.setStatus(1);
        brandService.add(brand);
    }

    @Test
    void deleteByIds() {
        int[] ids = {65, 66, 69};
        brandService.deleteByIds(ids);
    }

    @Test
    void selectByPage() {
        PageBean<Brand> brandPageBean = brandService.selectByPage(2, 6);
        List<Brand> brands = brandPageBean.getRows();
        brands.forEach(System.out::println);
    }

    @Test
    void selectByPageAndCondition() {
        Brand brand = new Brand();
        brand.setBrandName("小米");
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(1, 10, brand);
        List<Brand> brands = brandPageBean.getRows();
        brands.forEach(System.out::println);
    }
}