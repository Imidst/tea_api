package com.tea.service.impl;

import com.tea.entiey.dto.UserEditDTO;
import com.tea.entiey.dto.UserLoginDTO;
import com.tea.entiey.dto.UserRegisterDTO;
import com.tea.entiey.po.User;
import com.tea.mapper.UserMapper;
import com.tea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wenlong
 * @create 2021/7/23 15:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public int editUser(UserEditDTO user) {
        return userMapper.editUser(user);
    }

    @Override
    public int createUser(UserRegisterDTO user) {
        return userMapper.createUser(user);
    }

    @Override
    public User queryOne(UserLoginDTO user) {
        return userMapper.queryOne(user);
    }

    @Override
    public User queryOneByName(String name){
        return userMapper.queryOneByName(name);
    }
}
