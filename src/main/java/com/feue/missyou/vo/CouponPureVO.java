package com.feue.missyou.vo;

import com.feue.missyou.model.Coupon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2021-08-06 15:04
 */
@Getter
@Setter
@NoArgsConstructor
public class CouponPureVO {
    private Long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
    private Integer type;
    private String remark;
    private Boolean wholeStore;

    public CouponPureVO(Coupon coupon) {
        BeanUtils.copyProperties(coupon, this);
    }

    public static List<CouponPureVO> getList(List<Coupon> coupons) {
        return coupons.stream()
                .map(CouponPureVO::new)
                .collect(Collectors.toList());
    }
}
