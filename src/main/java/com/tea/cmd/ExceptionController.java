package com.tea.cmd;

import com.tea.entiey.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wenlong
 * @create 2021/7/26 14:55
 */
@ControllerAdvice
public class ExceptionController {
    @Autowired
    ResultVO result;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO handlerSellException(Exception e) {
        return result.result("E", e.getMessage());
    }
}
