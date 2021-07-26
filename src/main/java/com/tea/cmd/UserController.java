package com.tea.cmd;

import com.tea.entiey.po.User;
import com.tea.service.impl.UserServiceImpl;
import com.tea.util.EncryptionUtil;
import com.tea.util.ResultUtil;
import com.tea.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenlong
 * @create 2021/7/23 16:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/login")
    public ResultUtil login(@RequestBody User user){
        //数据校验
        if ("".equals(user.getName()) || "".equals(user.getPassword())){
            return ResultUtil.result("E","用户名或密码为空");
        }

        //密码加密
        user.setPassword(EncryptionUtil.encryptionMd5(user.getPassword()));

        //登录验证
        User one = userService.queryOne(user);
        if(one == null){
            return ResultUtil.result("E","用户名或密码错误");
        }

        //制作token
        String token = TokenUtil.getToken(user);
        Map map = new HashMap(2);
        map.put("token",token);
        return ResultUtil.result("S","登录成功",map);
    }

    /**
     * @param user
     * @return ResultUtil
     */
    @PostMapping("/register")
    public ResultUtil register(@RequestBody User user){
        //数据校验
        if ("".equals(user.getName()) || "".equals(user.getPassword())){
            return ResultUtil.result("E","用户名或密码为空");
        }
        //密码加密
        user.setPassword(EncryptionUtil.encryptionMd5(user.getPassword()));
        //尝试创建
        if (userService.createUser(user) == 0){
            return ResultUtil.result("E","用户名已经重复");
        }
        return ResultUtil.result("S","注册成功");
    }
}
