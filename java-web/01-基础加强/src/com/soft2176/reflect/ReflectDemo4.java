package com.soft2176.reflect;

import com.soft2176.domain.Person;

import java.lang.reflect.Method;

/**
 * @description: 反射练习4-执行指定的方法
 * @author: crq
 * @create: 2022-02-20 14:13
 **/
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception{
        //获取Person的Class对象
        Class<Person> personClass = Person.class;
        //获取指定名称的方法eat(无参的)
        Method eatMethod = personClass.getMethod("eat");
        Person p = new Person();
        //通过invoke执行目标方法
        eatMethod.invoke(p);
        //获取带string类型参数的eat方法
        Method eatMethod2 = personClass.getMethod("eat",String.class);
        //执行带参的eat方法
        eatMethod2.invoke(p,"饭");
        System.out.println("===================");
        //获取所有Public修饰的方法
        Method[] methods = personClass.getMethods();
        for(Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
            method.setAccessible(true);

        }
        //获取类名
        String className = personClass.getName();
        System.out.println(className);
    }
}
