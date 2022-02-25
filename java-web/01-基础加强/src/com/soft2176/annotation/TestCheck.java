package com.soft2176.annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;

/**
 * @description: 测试框架类
 * @author: crq
 * @create: 2022-02-20 14:35
 **/
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //创建计算器对象
        Calculator c = new Calculator();
        //获取字节码文件对象
        Class<?> cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();
        //出现异常的次数
        int number = 0;
        Writer out;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.test"));
        for (Method method : methods) {
            //判断方法上是否有Check注解
            if(method.isAnnotationPresent(Check.class)) {
                //有Check注解执行该方法
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常并记录到文件中
                    number++;
                    bw.write(method.getName() + "方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称:" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因:" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现" + number + " 次异常");
        bw.flush();
        bw.close();
    }
}
