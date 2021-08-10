package com.feue.missyou.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Feue
 * @create 2021-08-06 13:44
 */
@Entity
@Table(name = "user_coupon", schema = "sleeve", catalog = "")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long  userId;
    private Long couponId;
    private Integer status;
    private Date createTime;
    private Long orderId;
//    private Date updateTime;
}
