package com.feue.missyou.model;

import com.feue.missyou.dto.SkuInfoDTO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feue
 * @create 2021-08-11 17:00
 */
public class OrderSku {
    private Long id;
    private Long spuId;
    private BigDecimal finalPrice;
    private BigDecimal singlePrice;
    private List<String> specValues;
    private Integer count;
    private String img;
    private String title;

    public OrderSku(Sku sku, SkuInfoDTO skuInfoDTO) {
        this.id = sku.getId();
        this.spuId = sku.getSpuId();
        this.singlePrice = sku.getActualPrice();
        this.count = skuInfoDTO.getCount();
        this.finalPrice = this.singlePrice.multiply(BigDecimal.valueOf(this.count));
        this.img = sku.getImg();
        this.title = sku.getTitle();
        this.specValues = sku.getSpecValueList();
    }
}
