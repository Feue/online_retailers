package com.feue.missyou.model;

import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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
    private String prepayId;
    private BigDecimal finalTotalPrice;
    private Integer status;

//    private Object snapItems;
//    private Object snapAddress;
}
