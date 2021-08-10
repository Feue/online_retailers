package com.feue.missyou.api.v1;

import com.feue.missyou.Service.CouponService;
import com.feue.missyou.core.LocalUser;
import com.feue.missyou.core.UnifyResponse;
import com.feue.missyou.core.enumeration.CouponStatus;
import com.feue.missyou.core.interceptors.ScopeLevel;
import com.feue.missyou.exception.http.ParameterException;
import com.feue.missyou.model.Coupon;
import com.feue.missyou.model.User;
import com.feue.missyou.vo.CouponCategoryVO;
import com.feue.missyou.vo.CouponPureVO;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2021-08-06 15:22
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @GetMapping("/by/category/{cid}")
    public List<CouponPureVO> getCouponListByCategory(@PathVariable Long cid) {
        List<Coupon> coupons = this.couponService.getByCategory(cid);
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        List<CouponPureVO> vos = CouponPureVO.getList(coupons);
        return vos;
    }

    @GetMapping("/whole_store")
    public List<CouponPureVO> getWholeStoreCouponList() {
        List<Coupon> coupons = this.couponService.getWholeStoreCoupons();
        if (coupons.isEmpty()) {
            return Collections.emptyList();
        }
        return CouponPureVO.getList(coupons);
    }

    @ScopeLevel
    @PostMapping("/collect/{id}")
    public void collectCoupon(@PathVariable Long id) {
        Long uid = LocalUser.getUser().getId();
        this.couponService.collectOneCoupon(uid, id);
        UnifyResponse.createSuccess(0);
    }

    @ScopeLevel
    @GetMapping("/myself/by/status/{status}")
    public List<CouponPureVO> getMyCouponByStatus(@PathVariable Integer status) {
        Long uid = LocalUser.getUser().getId();
        List<Coupon> couponList;
        switch (CouponStatus.toType(status)) {
            case AVAILABLE:
                couponList = this.couponService.getMyAvailableCoupons(uid);
                break;
            case USED:
                couponList = this.couponService.getMyUsedCoupons(uid);
                break;
            case EXPIRED:
                couponList = this.couponService.getMyExpiredCoupons(uid);
                break;
            default:
                throw new ParameterException(40001);
        }
        return CouponPureVO.getList(couponList);
    }

    @ScopeLevel
    @GetMapping("/myself/available/with_category")
    public List<CouponCategoryVO> getUserCouponWithCategory() {
        User user = LocalUser.getUser();
        List<Coupon> couponList = this.couponService.getMyAvailableCoupons(user.getId());
        if (couponList.isEmpty()) {
            return Collections.emptyList();
        }
        return couponList.stream().map(CouponCategoryVO::new).collect(Collectors.toList());
    }
}
