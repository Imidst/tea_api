package com.tea.service;

import com.tea.entiey.dto.UserEditDTO;
import com.tea.entiey.dto.UserLoginDTO;
import com.tea.entiey.dto.UserRegisterDTO;
import com.tea.entiey.dto.UserRepassDTO;
import com.tea.entiey.po.User;

/**
 * @author wenlong
 * @create 2021/7/23 15:21
 */
public interface UserService {

    /**
     * 注销用户
     *
     * @param name
     * @return int
     */
    public int del(String name);

    /**
     * 修改密码
     *
     * @param user
     * @return int
     */
    public int repass(UserRepassDTO user);


    /**
     * 修改用户信息：修改用户信息
     *
     * @param user
     * @return int
     */
    public int editUser(UserEditDTO user);


    /**
     * 创建用户：用于用户注册
     *
     * @param user
     * @return int
     */
    public int createUser(UserRegisterDTO user);


    /**
     * 查询一个用户：用于用户登录
     *
     * @param user
     * @return user
     */
    public User queryOne(UserLoginDTO user);


    /**
     * 用名字查询一个用户：用于token验证
     *
     * @param name
     * @return user
     */
    public User queryOneByName(String name);
}
