package com.feue.missyou.logic;

import com.feue.missyou.bo.SkuOrderBO;
import com.feue.missyou.dto.OrderDTO;
import com.feue.missyou.dto.SkuInfoDTO;
import com.feue.missyou.exception.http.ParameterException;
import com.feue.missyou.model.OrderSku;
import com.feue.missyou.model.Sku;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feue
 * @create 2021-08-10 10:07
 *
 * 订单 校验参数
 * 1. 商品 无货
 * 2. 商品最大购买数量
 *      总数量限制
 *      sku单品数量限制
 * 3. totalPrice
 * 4. finalTotalPrice
 *      前端 计算的订单价格
 *          计算的订单的折扣价（最终价）
 *      服务端 计算的订单价格
 *            计算的订单的折扣价（最终价）
 * 5. 用户是否拥有优惠券
 * 6. 优惠券是否可用（过期?门槛?）
 */
public class OrderChecker {
    // OrderService->OrderChecker->CouponChecker
    // facade 外观模式
    private OrderDTO orderDTO;
    private List<Sku> serverSkuList;
    private CouponChecker couponChecker;
    private Integer maxSkuLimit;
    @Getter
    private List<OrderSku> orderSkuList = new ArrayList<>();

    public OrderChecker(OrderDTO orderDTO, List<Sku> serverSkuList,
                        CouponChecker couponChecker, Integer maxSkuLimit) {
        this.orderDTO = orderDTO;
        this.serverSkuList = serverSkuList;
        this.couponChecker = couponChecker;
        this.maxSkuLimit = maxSkuLimit;
    }

    public String getLeaderImg() {
        return this.serverSkuList.get(0).getImg();
    }

    public String getLeaderTitle() {
        return this.serverSkuList.get(0).getTitle();
    }

    public Integer getTotalCount() {
        return this.orderDTO.getSkuInfoList().stream()
                .map(SkuInfoDTO::getCount)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void isOk() {
        // orderTotalPrice serverTotalPrice
        // 下架
        // 售罄
        // 超出库存
        BigDecimal serverTotalPrice = new BigDecimal("0");
        List<SkuOrderBO>  skuOrderBOList = new ArrayList<>();

        this.SkuNotOnSale(this.orderDTO.getSkuInfoList().size(), this.serverSkuList.size());
        for (int i = 0; i < this.serverSkuList.size(); i++) {
            Sku sku = this.serverSkuList.get(i);
            SkuInfoDTO skuInfoDTO = this.orderDTO.getSkuInfoList().get(i);
            this.containsSoldOutSku(sku);
            this.beyondSkuStock(sku, skuInfoDTO);
            this.beyondMaxSkuLimit(skuInfoDTO);

            serverTotalPrice.add(this.calculateSkuOrderPrice(sku, skuInfoDTO));
            skuOrderBOList.add(new SkuOrderBO(sku, skuInfoDTO));
            this.orderSkuList.add(new OrderSku(sku, skuInfoDTO));
        }
        this.totalPriceIsOk(orderDTO.getTotalPrice(), serverTotalPrice);

        // 优惠券校验
        if (this.couponChecker != null) {
            this.couponChecker.isOk();
            this.couponChecker.canBeUsed(skuOrderBOList, serverTotalPrice);
            this.couponChecker.finalTotalPriceIsOk(orderDTO.getFinalTotalPrice(), serverTotalPrice);
        }
    }

    private void totalPriceIsOk(BigDecimal orderTotalPrice, BigDecimal serverTotalPrice) {
        if (orderTotalPrice.compareTo(serverTotalPrice) != 0) {
            throw new ParameterException(50005);
        }
    }

    private BigDecimal calculateSkuOrderPrice(Sku sku, SkuInfoDTO skuInfoDTO) {
        if (skuInfoDTO.getCount() <= 0) {
            throw new ParameterException(50007);
        }
        return sku.getActualPrice().multiply(BigDecimal.valueOf(skuInfoDTO.getCount()));
    }

    private void SkuNotOnSale(int count1, int count2) { // 是否下架
        if (count1 != count2) {
            throw new ParameterException(50002);
        }
    }

    private void containsSoldOutSku(Sku sku) { // 是否包含已售罄的Sku
        if (sku.getStock() == 0) {
            throw new ParameterException(50001);
        }
    }

    private void beyondSkuStock(Sku sku, SkuInfoDTO skuInfoDTO) {
        if (sku.getStock() < skuInfoDTO.getCount()) {
            throw new ParameterException(50003);
        }
    }

    private void beyondMaxSkuLimit(SkuInfoDTO skuInfoDTO) {
        if (skuInfoDTO.getCount() > this.maxSkuLimit) {
            throw new ParameterException(50004);
        }
    }
}
