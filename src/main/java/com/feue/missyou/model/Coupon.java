package com.feue.missyou.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Feue
 * @create 2021-08-06 13:44
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "delete_time is null")
public class Coupon extends BaseEntity{
    @Id
    private Long id;
    private String title;
    private Date startTime;
    private Date endTime;
    private String description;
    private BigDecimal fullMoney;
    private BigDecimal minus;
    private BigDecimal rate;
    private Integer type;
    private Long activityId;
    private String remark;
    private Boolean wholeStore;

    @ManyToMany(mappedBy = "couponList")
    private List<Category> categoryList;
}
