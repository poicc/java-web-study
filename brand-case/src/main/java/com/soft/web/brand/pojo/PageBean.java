package com.soft.web.brand.pojo;

import lombok.Data;

import java.util.List;

/**
 * @description: 分页查询的JavaBean
 * @author: crq
 * @create: 2022-03-04 14:46
 **/
@Data
public class PageBean<T> {
    /**
     * 总记录数
     */
    private int totalCount;

    /**
     * 当前页数据
     */
    private List<T> rows;

}
