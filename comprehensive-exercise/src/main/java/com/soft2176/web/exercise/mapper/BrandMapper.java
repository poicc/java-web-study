package com.soft2176.web.exercise.mapper;

import com.soft2176.web.exercise.entity.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
     * 根据id查询
     *
     * @param id 主键id
     * @return Brand对象
     */
    @Select("SELECT * FROM tb_brand WHERE id = #{id} ")
    Brand selectById(int id);

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
