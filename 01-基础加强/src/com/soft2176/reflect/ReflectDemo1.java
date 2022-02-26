package com.soft2176.reflect;

import com.soft2176.domain.Person;
import com.soft2176.domain.Student;

/**
 * @description: 反射练习1-获取Class对象的方式
 * @author: crq
 * @create: 2022-02-19 23:45
 **/
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException{
        //Class.forName("全类名")
        Class<?> cls1 = Class.forName("com.soft2176.domain.Person");
        System.out.println(cls1);
        //类名.class
        Class<?> cls2 = Person.class;
        System.out.println(cls2);
        //对象.getClass()
        Person p = new Person();
        Class<?> cls3 = p.getClass();
        System.out.println(cls3);
        //通过==比较三个对象 结果均为true
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
        //创建Student类的Class对象 然后比较 结果为false
        Class<?> c = Student.class;
        System.out.println(c == cls1);
    }
}
