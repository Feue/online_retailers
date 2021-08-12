package com.feue.missyou.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feue
 * @create 2021-08-10 9:17
 */
@Getter
@Setter
public class OrderDTO {
    private BigDecimal totalPrice;
    private BigDecimal finalTotalPrice;
    private Long couponId;
    private List<SkuInfoDTO> skuInfoList;
    private OrderAddressDTO address;
}
