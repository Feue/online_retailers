package com.feue.missyou.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Feue
 * @create 2021-08-06 13:44
 */
@Entity
@Table(name = "activity_coupon", schema = "sleeve", catalog = "")
public class ActivityCoupon {
    @Id
    private Long id;
    private Long  couponId;
    private Long activityId;
}
