package com.tea.cmd;

import com.tea.annotation.PassToken;
import com.tea.annotation.UseToken;
import com.tea.entiey.dto.UserEditDTO;
import com.tea.entiey.dto.UserLoginDTO;
import com.tea.entiey.dto.UserRegisterDTO;
import com.tea.entiey.po.User;
import com.tea.service.impl.UserServiceImpl;
import com.tea.util.EncryptionUtil;
import com.tea.util.ResultUtil;
import com.tea.util.StringUtil;
import com.tea.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 修改用户信息接口
     *
     * @param user
     * @return ResultUtil
     */
    @UseToken
    @PutMapping
    public ResultUtil editMessage(@RequestBody UserEditDTO user){
        if(StringUtil.isEmpty(user.getName())){
            return ResultUtil.result("E","用户名为空");
        }
        int editNum = userService.editUser(user);
        if (editNum ==0 ){
            return ResultUtil.result("E","修改失败");
        }
        return ResultUtil.result("S","修改失败");
    }

    /**
     * 登录接口
     *
     * @param user
     * @return ResultUtil
     */
    @PassToken
    @PostMapping("/login")
    public ResultUtil login(@RequestBody UserLoginDTO user){
        //数据校验
        if (StringUtil.isEmpty(user.getName()) || StringUtil.isEmpty(user.getPassword())){
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
        String token = TokenUtil.getToken(one);
        return ResultUtil.result("S","登录成功",token);
    }

    /**
     * 注册接口
     *
     * @param user
     * @return ResultUtil
     */
    @PassToken
    @PostMapping("/register")
    public ResultUtil register(@RequestBody UserRegisterDTO user){
        //数据校验
        if (StringUtil.isEmpty(user.getName()) || StringUtil.isEmpty(user.getPassword())){
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
