package com.crq.bookonline.entity;

import java.time.LocalDate;

/**
 * @description:
 * @author: crq
 * @create: 2022-02-24 13:15
 **/
public class User {
    private Integer id;
    private String account;
    private String password;
    private String nickname;
    private String avatar;
    private String address;
    private LocalDate joinDate;

    public User() {
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public User(Integer id, String account, String password, String nickname, String avatar, String address, LocalDate joinDate) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.address = address;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", joinDate=" + joinDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public User setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public User setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
        return this;
    }
}
