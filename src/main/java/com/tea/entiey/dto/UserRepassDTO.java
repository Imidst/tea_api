package com.tea.entiey.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author wenlong
 * @create 2021/7/27 13:25
 */
@Data
@Component
public class UserRepassDTO {
    String name;
    String newPass;
    String oldPass;
}
