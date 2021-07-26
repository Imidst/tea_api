package com.tea.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenlong
 * @create 2021/7/26 10:22
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultUtil {
    private String code;
    private String message;
    private Map data;

    public static ResultUtil result(String code,String message){
        return new ResultUtil(code,message,new HashMap(2));
    }
    public static ResultUtil result(String code,String message,Map data){
        return new ResultUtil(code,message,data);
    }
}