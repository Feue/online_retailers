package com.feue.missyou.core.money;

import java.math.BigDecimal;

/**
 * @author Feue
 * @create 2021-08-10 10:54
 */
public interface IMoneyDiscount {
    BigDecimal discount(BigDecimal original, BigDecimal discount);
}
