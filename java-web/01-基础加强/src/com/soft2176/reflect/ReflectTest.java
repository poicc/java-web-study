package com.soft2176.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @description: 反射综合案例-框架类
 * @author: crq
 * @create: 2022-02-20 14:20
 **/
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //创建Properties对象
        Properties pro = new Properties();
        //获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        //加载配置文件
        pro.load(is);
        //获取文职文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //加载该类进内存
        Class<?> cls = Class.forName(className);
        //创建对象
        Object obj =  cls.getConstructor().newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        //执行目标方法
        method.invoke(obj);
    }
}
