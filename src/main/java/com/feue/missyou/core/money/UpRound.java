package com.feue.missyou.core.money;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Feue
 * @create 2021-08-10 11:01
 */
@Component
public class UpRound implements IMoneyDiscount{
    @Override
    public BigDecimal discount(BigDecimal original, BigDecimal discount) {
        BigDecimal actual = original.multiply(discount);
        BigDecimal finalMoney = actual.setScale(2, RoundingMode.UP);
        return finalMoney;
    }
}
