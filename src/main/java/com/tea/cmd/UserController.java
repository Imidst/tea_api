package com.tea.cmd;

import com.tea.annotation.PassToken;
import com.tea.annotation.UseToken;
import com.tea.entiey.dto.UserEditDTO;
import com.tea.entiey.dto.UserLoginDTO;
import com.tea.entiey.dto.UserRegisterDTO;
import com.tea.entiey.dto.UserRepassDTO;
import com.tea.entiey.po.User;
import com.tea.service.impl.UserServiceImpl;
import com.tea.util.EncryptionUtil;
import com.tea.entiey.vo.ResultVO;
import com.tea.util.StringUtil;
import com.tea.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * @author wenlong
 * @create 2021/7/23 16:32
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ResultVO result;

    @Autowired
    ApplicationContext context;

    /**
     * 注销账号：删除一个用户
     *
     * @param name
     * @return ResultUtil
     */
    @UseToken
    @DeleteMapping("/del")
    public ResultVO del(String name){
        if(StringUtil.isEmpty(name)){
            return result.result("E","用户名为空");
        }
        int delNum = userService.del(name);
        if(delNum == 0){
            return result.result("E","无该用户");
        }
        return result.result("S","注销成功");
    }


    /**
     * 修改密码接口
     *
     * @param user
     * @return ResultUtil
     */
    @UseToken
    @PutMapping("/repass")
    public ResultVO repass(@RequestBody UserRepassDTO user){
        if(StringUtil.isEmpty(user.getName()) || StringUtil.isEmpty(user.getNewPass()) || StringUtil.isEmpty(user.getOldPass())){
            return result.result("E","用户名或密码为空");
        }

        UserLoginDTO userLogin = (UserLoginDTO)context.getBean("userLoginDTO");
        userLogin.setName(user.getName());
        userLogin.setPassword(EncryptionUtil.encryptionMd5(user.getOldPass()));
        User one = userService.queryOne(userLogin);
        if (one == null){
            return result.result("E","修改失败,密码错误");
        }

        user.setNewPass(EncryptionUtil.encryptionMd5(user.getNewPass()));
        return result.result("S","修改成功");
    }


    /**
     * 修改用户信息接口
     *
     * @param user
     * @return ResultUtil
     */
    @UseToken
    @PutMapping("/edit")
    public ResultVO edit(@RequestBody UserEditDTO user){
        if(StringUtil.isEmpty(user.getName())){
            return result.result("E","用户名为空");
        }
        int editNum = userService.editUser(user);
        if (editNum ==0 ){
            return result.result("E","修改失败");
        }
        return result.result("S","修改成功");
    }


    /**
     * 登录接口
     *
     * @param user
     * @return ResultUtil
     */
    @PassToken
    @PostMapping("/login")
    public ResultVO login(@RequestBody UserLoginDTO user){
        //数据校验
        if (StringUtil.isEmpty(user.getName()) || StringUtil.isEmpty(user.getPassword())){
            return result.result("E","用户名或密码为空");
        }
        //密码加密
        user.setPassword(EncryptionUtil.encryptionMd5(user.getPassword()));
        //登录验证
        User one = userService.queryOne(user);
        if(one == null){
            return result.result("E","用户名或密码错误");
        }
        //制作token
        String token = TokenUtil.getToken(one);
        return result.result("S","登录成功",token);
    }

    /**
     * 注册接口
     *
     * @param user
     * @return ResultUtil
     */
    @PassToken
    @PostMapping("/register")
    public ResultVO register(@RequestBody UserRegisterDTO user){
        //数据校验
        if (StringUtil.isEmpty(user.getName()) || StringUtil.isEmpty(user.getPassword())){
            return result.result("E","用户名或密码为空");
        }
        //密码加密
        user.setPassword(EncryptionUtil.encryptionMd5(user.getPassword()));
        //尝试创建
        if (userService.createUser(user) == 0){
            return result.result("E","用户名已经重复");
        }
        return result.result("S","注册成功");
    }
}
