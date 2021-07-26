package com.tea.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wenlong
 * @create 2021/7/23 17:13
 */
class EncryptionUtilTest {

    @Test
    void encryption() {
        System.out.println(EncryptionUtil.encryptionMd5("123456"));
    }
}