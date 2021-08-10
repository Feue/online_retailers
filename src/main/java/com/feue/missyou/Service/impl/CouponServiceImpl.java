package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.CouponService;
import com.feue.missyou.core.enumeration.CouponStatus;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.exception.http.ParameterException;
import com.feue.missyou.model.Activity;
import com.feue.missyou.model.Coupon;
import com.feue.missyou.model.UserCoupon;
import com.feue.missyou.repository.ActivityRepository;
import com.feue.missyou.repository.CouponRepository;
import com.feue.missyou.repository.UserCouponRepository;
import com.feue.missyou.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Feue
 * @create 2021-08-06 15:24
 */
@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserCouponRepository userCouponRepository;

    @Override
    public List<Coupon> getByCategory(Long cid) {
        return this.couponRepository.findByCategory(cid, new Date());
    }

    @Override
    public List<Coupon> getWholeStoreCoupons() {
        return this.couponRepository.findByWholeStore(true, new Date());
    }

    @Override
    public void collectOneCoupon(Long uid, Long couponId) {
        this.couponRepository
                .findById(couponId)
                .orElseThrow(() -> new NotFoundException(40004));

        // 优惠券是否过期
        Activity activity = this.activityRepository
                .findByCouponListId(couponId)
                .orElseThrow(() -> new NotFoundException(40010));
        Date now = new Date();
        Boolean inTimeLine = CommonUtil.isInTimeLine(now, activity.getStartTime(), activity.getEndTime());
        if (!inTimeLine) {
            throw new ParameterException(40005);
        }

        // 优惠券是否已领取
        this.userCouponRepository
                .findFirstByUserIdAndCouponId(uid, couponId)
                .ifPresent((uc) -> {throw new ParameterException(40006);});

        UserCoupon userCouponNew = UserCoupon.builder()
                .userId(uid)
                .couponId(couponId)
                .status(CouponStatus.AVAILABLE.getValue())
                .createTime(now)
                .build();
        this.userCouponRepository.save(userCouponNew);
    }

    @Override
    public List<Coupon> getMyAvailableCoupons(Long uid) {
        Date now = new Date();
        return this.couponRepository.findMyAvailable(uid, now);
    }

    @Override
    public List<Coupon> getMyUsedCoupons(Long uid) {
        return this.couponRepository.findMyUsed(uid);
    }

    @Override
    public List<Coupon> getMyExpiredCoupons(Long uid) {
        Date now = new Date();
        return this.couponRepository.findMyExpired(uid, now);
    }
}
