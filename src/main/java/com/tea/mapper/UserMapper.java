package com.tea.mapper;

import com.tea.entiey.po.User;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author wenlong
 * @create 2021/7/23 15:21
 */

public interface UserMapper {
    /**
     * 创建用户：用于注册用户
     *
     * @param user
     * @return int
     */
    public int createUser(User user);


    /**
     * 查询一个用户：用于用户登录
     *
     * @param user
     * @return user
     */
    public User queryOne(User user);

    /**
     * 用名字查询一个用户：用于token验证
     *
     * @param name
     * @return user
     */
    public User queryOneByName(String name);
}
