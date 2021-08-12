package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.OrderService;
import com.feue.missyou.Service.SkuService;
import com.feue.missyou.core.money.IMoneyDiscount;
import com.feue.missyou.dto.OrderDTO;
import com.feue.missyou.dto.SkuInfoDTO;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.exception.http.ParameterException;
import com.feue.missyou.logic.CouponChecker;
import com.feue.missyou.logic.OrderChecker;
import com.feue.missyou.model.Coupon;
import com.feue.missyou.model.Sku;
import com.feue.missyou.model.UserCoupon;
import com.feue.missyou.repository.CouponRepository;
import com.feue.missyou.repository.UserCouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2021-08-10 9:51
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SkuService skuService;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private UserCouponRepository userCouponRepository;
    @Autowired
    private IMoneyDiscount iMoneyDiscount;
    @Value("${missyou.order.max-sku-limit}")
    private Integer maxSkuLimit;
    @Value("${missyou.order.pay-time-limit}")
    private Integer payTimeLimit;

    @Override
    public OrderChecker isOk(Long uid, OrderDTO orderDTO) {
        if (orderDTO.getFinalTotalPrice().compareTo(new BigDecimal("0")) <= 0) {
            throw new ParameterException(50011);
        }

        List<Long> skuIdList = orderDTO.getSkuInfoList()
                .stream().map(SkuInfoDTO::getId)
                .collect(Collectors.toList());

        List<Sku> skuList = this.skuService.getSkuListByIds(skuIdList);

        // OrderChecker > CouponChecker
        Long couponId = orderDTO.getCouponId();
        CouponChecker couponChecker = null;
        if (couponId != null) {
            Coupon coupon = this.couponRepository.findById(couponId)
                    .orElseThrow(() -> new NotFoundException(40004));
            UserCoupon userCoupon = this.userCouponRepository.findFirstByUserIdAndCouponId(uid, couponId)
                    .orElseThrow(() -> new NotFoundException(50006));
            couponChecker = new CouponChecker(coupon, this.iMoneyDiscount);
        }
        OrderChecker orderChecker = new OrderChecker(orderDTO, skuList, couponChecker, this.maxSkuLimit);
        orderChecker.isOk();
        return orderChecker;
    }
}
