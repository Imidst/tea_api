package com.tea.entiey.dto;

import lombok.Data;

/**
 * @author wenlong
 * @create 2021/7/27 10:09
 */
@Data
public class UserEditDTO {
    /**
     * name写死，用于判断修改谁的数据
     */
    String name;
    String phone;
    String nick;
}
