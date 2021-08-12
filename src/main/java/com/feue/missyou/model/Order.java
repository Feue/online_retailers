package com.feue.missyou.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.feue.missyou.dto.OrderAddressDTO;
import com.feue.missyou.util.GenericAndJson;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Feue
 * @create 2021-08-10 9:19
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "delete_time is null")
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNo;
    private Long userId;
    private BigDecimal totalPrice;
    private Long totalCount;
    private Date expiredTime;
    private Date placedTime;
    private String snapImg;
    private String snapTitle;

    private String snapItems;

    private String snapAddress;

    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Integer status;

    public OrderAddressDTO getSnapAddress() {
        if (this.snapAddress == null) {
            return null;
        }
        OrderAddressDTO dto = GenericAndJson.jsonToObject(this.snapAddress, new TypeReference<OrderAddressDTO>() {});
        return dto;
    }

    public void setSnapAddress(OrderAddressDTO address) {
        this.snapAddress = GenericAndJson.objectToJson(address);
    }

    public List<OrderSku> getSnapItem() {
        if (this.snapItems == null) {
            return null;
        }
        List<OrderSku> orderSkuList = GenericAndJson.jsonToObject(this.snapItems, new TypeReference<List<OrderSku>>() {});
        return orderSkuList;
    }

    public void setSnapItems(List<OrderSku> orderSkuList) {
        this.snapItems = GenericAndJson.objectToJson(orderSkuList);
    }
}
