package com.soft.web.brand.mapper;

import com.soft.web.brand.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description: BrandMapper
 * @author: crq
 * @create: 2022-03-01 14:27
 **/
public interface BrandMapper {
    /**
     * 查询所有
     *
     * @return List<Brand>
     */
    @Select("SELECT * FROM tb_brand ORDER BY ordered ")
    List<Brand> selectAll();

    /**
     * 新增
     *
     * @param brand brand对象
     */
    @Insert("INSERT INTO tb_brand VALUES (null,#{brandName},#{companyName},#{ordered},#{description},#{status}) ")
    void add(Brand brand);

    /**
     * 批量删除
     * @param ids 删除记录的id数组
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页删除
     * @param begin 起始索引
     * @param size 每页熟练
     * @return 当前页数数据集合
     */
    @Select("SELECT * FROM tb_brand LIMIT #{begin},#{size}")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查看总记录数
     * @return list
     */
    @Select("SELECT COUNT(*) FROM th_brand")
    int selectTotalCount();

    /**
     * 分页条件查询
     * @param begin 起始记录索引
     * @param size 每页数量
     * @param brand 查询条件对象
     * @return 当前页数数据集合
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin,@Param("size") int size,@Param("brand") Brand brand);

    /**
     * 根据条件查询总记录数
     * @param brand 查询条件对象
     * @return int
     */
    int selectTotalCountByCondition(Brand brand);

    /**
     * 修改
     *
     * @param brand brand对象
     */
    @Update("UPDATE tb_brand SET brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} WHERE id = #{id} ")
    void update(Brand brand);

    /**
     * 根据id删除
     * @param id id
     */
    @Delete("DELETE FROM tb_brand WHERE id = #{id}")
    void delete(Integer id);
}
