package com.feue.missyou.core.enumeration;

import java.util.stream.Stream;

/**
 * @author Feue
 * @create 2021-08-12 10:59
 */
public enum OrderStatus {
    ALL(0, "全部"),
    UNPAID(1, "待支付"),
    PAID(2, "已支付"),
    DELIVERED(3, "已发货"),
    FINISHED(4, "已完成"),
    CANCELLED(5, "已取消"),
    // 预扣除库存不存在以下这两种情况
    PAID_BUT_OUT_OF(21, "已支付，但无货或库存不足"),
    DEAL_OUT_OF(22, "已处理缺货但支付的情况");

    private int value;

    private OrderStatus(int value, String description) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static OrderStatus toType(int value) {
        return Stream.of(OrderStatus.values())
                .filter(status -> status.value == value)
                .findAny()
                .orElse(null);
    }
}
