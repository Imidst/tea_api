package com.tea.util;

import org.springframework.util.DigestUtils;

/**
 * @author wenlong
 * @create 2021/7/23 17:00
 */
public class EncryptionUtil {
    private static String KEY = "kasdfweawdsvb";
    public static String encryptionMd5(String text){
        text += KEY;
        int i;
        int forNum = 5;
        for (i = 0; i < forNum; i++) {
            text = DigestUtils.md5DigestAsHex(text.getBytes());
        }
        return text;
    }
    public static String encryptionB64(String text){
        return "";
    }
}
