package com.crq.bookonline.entity;

/**
 * @description:
 * @author: crq
 * @create: 2022-02-23 21:03
 **/
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String author;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public Book setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book() {
    }

    public Book(Integer id, String name, String cover, String author) {
        this.id = id;
        this.name = name;
        this.cover = cover;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }
}
