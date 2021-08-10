package com.feue.missyou.Service;

import com.feue.missyou.model.Coupon;

import java.util.List;

/**
 * @author Feue
 * @create 2021-08-06 15:24
 */
public interface CouponService {
    List<Coupon> getByCategory(Long cid);
    List<Coupon> getWholeStoreCoupons();
    void collectOneCoupon(Long id, Long couponId);
    List<Coupon> getMyAvailableCoupons(Long uid);
    List<Coupon> getMyUsedCoupons(Long uid);
    List<Coupon> getMyExpiredCoupons(Long uid);
}
