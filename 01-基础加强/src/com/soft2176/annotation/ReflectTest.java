package com.soft2176.annotation;

import java.lang.reflect.Method;

/**
 * @description: 注解测试类
 * @author: crq
 * @create: 2022-02-20 16:36
 **/
@Pro(className = "com.soft2176.annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //获取该类的字节码文件对象
        Class<?> reflectTestClass = ReflectTest.class;
        //获取该类上方的注解对象
        //在内存中生成了一个该注解接口的子类实现对象
//        public class ProImpl implements Pro{
//            public String className() {
//                return "com.soft2176.annotation.Demo1";
//            }
//            public String methodName() {
//                return "show";
//            }
//        }
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        //调用注解对象中定义的抽象方法 获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className + "," + methodName);
        //加载该类进内存
        Class<?> cls = Class.forName(className);
        //通过构造方法创建对象
        Object obj = cls.getConstructor().newInstance();
        //获取方法对象
        Method method = cls.getMethod(methodName);
        //执行方法
        method.invoke(obj);
    }
}
