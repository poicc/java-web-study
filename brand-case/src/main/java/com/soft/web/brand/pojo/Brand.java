package com.soft.web.brand.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 品牌实体
 * @author: crq
 * @create: 2022-02-28 15:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    /**
     * id 主键
     */
    private Integer id;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 排序字段
     */
    private Integer ordered;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 状态：0：禁用  1：启用
     */
    private Integer status;

    public String getStatusStr() {
        if(status == null) {
            return "未知";
        }
        return status == 0 ? "禁用" : "启用";
    }

}
