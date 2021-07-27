package com.tea.service.impl;

import com.tea.TeaApiApplicationTests;
import com.tea.entiey.dto.UserRepassDTO;
import com.tea.util.EncryptionUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author wenlong
 * @create 2021/7/23 15:30
 */
class UserServiceImplTest extends TeaApiApplicationTests {

//    @Autowired(required=false)
//    User user;
    @Autowired
    UserServiceImpl userService;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void createUser() {
//        System.out.println("test start!");
//        user.setName("test");
//        user.setNick("管理员");
//        user.setPassword("123456");
//        user.setPhone("1111112222");
//
//        System.out.println(userService.createUser(user));
    }

    @Test
    void queryOne() {
//        user.setPassword("1797ff3b24dc0e89086105194efd843a5");
//        user.setName("admin");
//
//        User user = userService.queryOne(this.user);
//        System.out.println(user==null);
    }

    @Test
    void queryOneByName() {
//        User admin = userService.queryOneByName("admin");
//        System.out.println(admin==null);
    }

    @Test
    void editUser() {
//        UserEditDTO user = new UserEditDTO();
//        user.setName("admin");
//        user.setNick("超级管理员");
//        user.setPhone("1124519374");
//
//        userService.editUser(user);
    }



    @Test
    void repass() {
        UserRepassDTO user = (UserRepassDTO)applicationContext.getBean("userRepassDTO");
        user.setName("admin");
        user.setNewPass(EncryptionUtil.encryptionMd5("123456"));
        userService.repass(user);
    }
}