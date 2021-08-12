package com.feue.missyou.core.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Feue
 * @create 2021-08-10 10:56
 */
public class HalfUpRound implements IMoneyDiscount{
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actual = original.multiply(discount);
        BigDecimal finalMoney = actual.setScale(2, RoundingMode.HALF_UP);
        return finalMoney;
    }
}
