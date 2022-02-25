package com.soft2176.junit;

/**
 * @description: 计算机测试类
 * @author: crq
 * @create: 2022-02-19 23:06
 **/
public class CalculatorTest {
    public static void main(String[] args) {
        //创建对象
        Calculator c = new Calculator();
        //调用add方法
        int result1 = c.add(1, 2);
        System.out.println(result1);

        //调用sub方法
        int result2 = c.sub(1,1);
        System.out.println(result2);
    }
}
