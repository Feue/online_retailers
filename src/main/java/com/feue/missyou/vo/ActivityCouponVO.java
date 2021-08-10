package com.feue.missyou.vo;

import com.feue.missyou.model.Activity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2021-08-06 15:07
 */
@Getter
@Setter
public class ActivityCouponVO extends ActivityPureVO {
    private List<CouponPureVO> coupons;

    public ActivityCouponVO(Activity activity) {
        super(activity);
        this.coupons = activity.getCouponList()
                .stream().map(CouponPureVO::new)
                .collect(Collectors.toList());
    }
}
