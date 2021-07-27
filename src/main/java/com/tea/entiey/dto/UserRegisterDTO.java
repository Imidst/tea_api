package com.tea.entiey.dto;

import lombok.Data;

/**
 * @author wenlong
 * @create 2021/7/27 9:51
 */
@Data
public class UserRegisterDTO {
    String name;
    String password;
    String phone;
    String nick;
}
