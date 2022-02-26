package com.crq.bookonline.service;

import com.crq.bookonline.entity.User;
import com.crq.bookonline.utils.Md5Util;

import java.util.List;

/**
 * @description:
 * @author: crq
 * @create: 2022-02-24 15:06
 **/
public class UserService {
    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 用户登陆功能
     *
     * @param account
     * @param password
     * @return user
     */
    public User signIn(String account, String password) {
        for (User user : userList) {
            if (user.getAccount().equals(account) && user.getPassword().equals(Md5Util.crypt(password))) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new UserService().signIn("18851699003", Md5Util.crypt("111"));
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("登录失败");
        }
    }
}

