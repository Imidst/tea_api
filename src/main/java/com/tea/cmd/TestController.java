package com.tea.cmd;

import com.tea.annotation.UseToken;
import com.tea.util.TokenUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wenlong
 * @create 2021/7/23 15:15
 * 拦截异常并返回信息
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @UseToken
    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
}
