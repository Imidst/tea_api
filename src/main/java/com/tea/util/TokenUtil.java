package com.tea.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.tea.entiey.po.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wenlong
 * @create 2021/7/26 9:24
 */
public class TokenUtil {

    public static String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getName())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
