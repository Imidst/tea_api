package com.tea.cmd;

import com.tea.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wenlong
 * @create 2021/7/26 14:55
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultUtil handlerSellException(Exception e) {
        return ResultUtil.result("E", e.getMessage());
    }
}
