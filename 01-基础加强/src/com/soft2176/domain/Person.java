package com.soft2176.domain;

/**
 * @description: Person类
 * @author: crq
 * @create: 2022-02-19 23:42
 **/
public class Person {
    private String name;
    private int age;
    public String a;
    protected String b;
    String c;
    private String d;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getA() {
        return a;
    }

    public Person setA(String a) {
        this.a = a;
        return this;
    }

    public String getB() {
        return b;
    }

    public Person setB(String b) {
        this.b = b;
        return this;
    }

    public String getC() {
        return c;
    }

    public Person setC(String c) {
        this.c = c;
        return this;
    }

    public String getD() {
        return d;
    }

    public Person setD(String d) {
        this.d = d;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("eat...");
    }

    public void eat(String food) {
        System.out.println("eat..." + food);
    }
}
