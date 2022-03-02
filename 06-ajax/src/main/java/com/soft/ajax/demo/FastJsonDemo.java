package com.soft.ajax.demo;

import com.alibaba.fastjson.JSON;

/**
 * @description: FastJsonDemo
 * @author: crq
 * @create: 2022-03-02 14:04
 **/
public class FastJsonDemo {
    public static void main(String[] args) {
        //将Java对象转为JSON字符串
        User user = new User();
        user.setId(1);
        user.setUsername("zhansan");
        user.setPassword("123");

        String jsonStr = JSON.toJSONString(user);
        System.out.println(jsonStr);

        //将JSON字符串转为Java对象
        User u = JSON.parseObject("{\n" +
                "  \"id\": 1,\n" +
                "  \"password\": 123,\n" +
                "  \"username\": \"zhangsan\"\n" +
                "}",User.class);
        System.out.println(u);
    }
}
