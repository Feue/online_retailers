package com.feue.missyou.logic;

import com.feue.missyou.bo.SkuOrderBO;
import com.feue.missyou.core.enumeration.CouponType;
import com.feue.missyou.core.money.IMoneyDiscount;
import com.feue.missyou.exception.http.ForbiddenException;
import com.feue.missyou.exception.http.ParameterException;
import com.feue.missyou.model.Category;
import com.feue.missyou.model.Coupon;
import com.feue.missyou.model.UserCoupon;
import com.feue.missyou.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2021-08-10 10:07
 *
 * 优惠券校验
 *
 */
public class CouponChecker {
    private Coupon coupon;
    private IMoneyDiscount iMoneyDiscount;

    public CouponChecker(Coupon coupon, IMoneyDiscount iMoneyDiscount) {
        this.coupon = coupon;
        this.iMoneyDiscount = iMoneyDiscount;
    }

    public void isOk() {
        Date now = new Date();
        Boolean isInTimeLine = CommonUtil.isInTimeLine(now, this.coupon.getStartTime(), this.coupon.getEndTime());
        if (!isInTimeLine) {
            throw new ForbiddenException(40007);
        }
    }

    public void finalTotalPriceIsOk(BigDecimal orderFinalTotalPrice,
                                    BigDecimal serverTotalPrice) {
        BigDecimal serverFinalTotalPrice = null;
        switch (CouponType.toType(this.coupon.getType())) {
            case FULL_MINUS:
                serverFinalTotalPrice = serverTotalPrice.subtract(this.coupon.getMinus());
                break;
            case FULL_OFF:
                serverFinalTotalPrice = this.iMoneyDiscount.discount(serverTotalPrice, this.coupon.getRate());
                break;
            case NO_THRESHOLD_MINUS:
                serverFinalTotalPrice = serverTotalPrice.subtract(this.coupon.getMinus());
                if (serverFinalTotalPrice.compareTo(new BigDecimal("0")) <= 0) {
                    throw new ForbiddenException(50008);
                }
                break;
            default:
                throw new ParameterException(40009);
        }
        int compare = serverFinalTotalPrice.compareTo(orderFinalTotalPrice);
        if (compare != 0) {
            throw new ForbiddenException(50008);
        }
    }

    public void canBeUsed(List<SkuOrderBO> skuOrderBOList,
                          BigDecimal serverTotalPrice) {
        BigDecimal orderCategoryPrice;

        if (this.coupon.getWholeStore()) {
            orderCategoryPrice = serverTotalPrice;
        } else {
            List<Long> cidList = this.coupon.getCategoryList().stream()
                    .map(Category::getId)
                    .collect(Collectors.toList());
            orderCategoryPrice = this.getTotalPriceByCategoryList(skuOrderBOList, cidList);
        }
        this.couponCanBeUsed(orderCategoryPrice);
    }

    private void couponCanBeUsed(BigDecimal orderTotalPrice) {
        switch (CouponType.toType(this.coupon.getType())) {
            case FULL_MINUS:
            case FULL_OFF:
                int compare = this.coupon.getFullMoney().compareTo(orderTotalPrice);
                if (compare > 0) {
                    throw new ParameterException(40008);
                }
                break;
            case NO_THRESHOLD_MINUS:
                break;
            default:
                throw new ParameterException(40009);
        }
    }

    private BigDecimal getTotalPriceByCategory(List<SkuOrderBO> skuOrderBOList,
                                               Long cid) {
        return skuOrderBOList.stream()
                .filter(sku -> sku.getCategoryId().equals(cid))
                .map(SkuOrderBO::getTotalPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
    }

    private BigDecimal getTotalPriceByCategoryList(List<SkuOrderBO> skuOrderBOList,
                                                   List<Long> cidList) {
        return cidList.stream()
                .map(cid -> this.getTotalPriceByCategory(skuOrderBOList, cid))
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0"));
    }
}
