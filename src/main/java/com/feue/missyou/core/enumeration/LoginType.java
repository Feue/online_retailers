package com.feue.missyou.core.enumeration;

/**
 * @author Feue
 * @create 2021-07-30 16:01
 */
public enum LoginType {
    USER_WX(0, "微信登录"),
    USER_EMAIL(0, "邮箱登录");

    private Integer value;

    LoginType(Integer value, String description) {
        this.value = value;
    }
}
