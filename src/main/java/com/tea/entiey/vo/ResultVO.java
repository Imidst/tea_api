package com.tea.entiey.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author wenlong
 * @create 2021/7/26 10:22
 */

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private String code;
    private String message;
    private Object data;

    public ResultVO result(String code, String message){
        return new ResultVO(code,message,"");
    }
    public ResultVO result(String code, String message, Object data){
        return new ResultVO(code,message,data);
    }
}