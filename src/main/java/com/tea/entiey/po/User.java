package com.tea.entiey.po;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

/**
 * @author wenlong
 * @create 2021/7/23 15:13
 */
@Data
@EntityScan
public class User {
    String name;
    String password;
    String phone;
    String nick;
}
