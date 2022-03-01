package com.soft2176.web.exercise.service;

import com.soft2176.web.exercise.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class UserServiceTest {

    @Test
    public void login() {
        UserService userService = new UserService();
        User user = userService.login("zhangsan", "123");
        if(user != null) {
            log.info(String.valueOf(user));
        }
    }
}