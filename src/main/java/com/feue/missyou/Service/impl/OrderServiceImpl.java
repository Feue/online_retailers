package com.feue.missyou.Service.impl;

import com.feue.missyou.Service.OrderService;
import com.feue.missyou.Service.SkuService;
import com.feue.missyou.core.enumeration.OrderStatus;
import com.feue.missyou.core.money.IMoneyDiscount;
import com.feue.missyou.dto.OrderDTO;
import com.feue.missyou.dto.SkuInfoDTO;
import com.feue.missyou.exception.http.NotFoundException;
import com.feue.missyou.exception.http.ParameterException;
import com.feue.missyou.logic.CouponChecker;
import com.feue.missyou.logic.OrderChecker;
import com.feue.missyou.model.*;
import com.feue.missyou.repository.CouponRepository;
import com.feue.missyou.repository.OrderRepository;
import com.feue.missyou.repository.UserCouponRepository;
import com.feue.missyou.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feue
 * @create 2021-08-10 9:51
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private SkuService skuService;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private UserCouponRepository userCouponRepository;
    @Autowired
    private IMoneyDiscount iMoneyDiscount;
    @Autowired
    private OrderRepository orderRepository;
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

    @Override
    public Long placeOrder(Long uid, OrderDTO orderDTO, OrderChecker orderChecker) {
        String orderNo = OrderUtil.makeOrderNo();
        Order order = Order.builder()
                .orderNo(orderNo)
                .totalPrice(orderDTO.getTotalPrice())
                .finalTotalPrice(orderDTO.getFinalTotalPrice())
                .userId(uid)
                .totalCount(orderChecker.getTotalCount().longValue())
                .snapImg(orderChecker.getLeaderImg())
                .snapTitle(orderChecker.getLeaderTitle())
                .status(OrderStatus.UNPAID.value())
                .build();
//                .snapAddress(orderDTO.getAddress())
        order.setSnapAddress(orderDTO.getAddress());
        order.setSnapItems(orderChecker.getOrderSkuList());
        this.orderRepository.save(order);
        // reduce stock
        // 核销优惠券
        // 加入到延迟消息队列
        return order.getId();
    }

    private void reduceStock(OrderChecker orderChecker) {// 减库存
        List<OrderSku> orderSkuList = orderChecker.getOrderSkuList();
        for (OrderSku orderSku: orderSkuList) {

        }
    }
}
