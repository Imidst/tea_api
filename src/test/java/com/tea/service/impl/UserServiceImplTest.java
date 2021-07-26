package com.tea.service.impl;

import com.tea.TeaApiApplicationTests;
import com.tea.entiey.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wenlong
 * @create 2021/7/23 15:30
 */
class UserServiceImplTest extends TeaApiApplicationTests {

    @Autowired(required=false)
    User user;
    @Autowired
    UserServiceImpl userService;

    @Test
    void createUser() {
        System.out.println("test start!");
        user.setName("test");
        user.setNick("管理员");
        user.setPassword("123456");
        user.setPhone("1111112222");

        System.out.println(userService.createUser(user));
    }

    @Test
    void queryOne() {
        user.setPassword("1797ff3b24dc0e89086105194efd843a5");
        user.setName("admin");

        User user = userService.queryOne(this.user);
        System.out.println(user==null);
    }

    @Test
    void queryOneByName() {
        User admin = userService.queryOneByName("admin");
        System.out.println(admin==null);
    }
}