package com.feue.missyou.core.enumeration;

import java.util.stream.Stream;

/**
 * @author Feue
 * @create 2021-08-09 14:31
 */
public enum CouponStatus {
    AVAILABLE(1, "可以使用，未过期"),
    USED(2, "已使用"),
    EXPIRED(3, "未使用，已过期");

    private Integer value;

    CouponStatus(Integer value, String description) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static CouponStatus toType(int value) {
        return Stream.of(CouponStatus.values())
                .filter(c -> c.value == value)
                .findAny()
                .orElse(null);
    }
}
