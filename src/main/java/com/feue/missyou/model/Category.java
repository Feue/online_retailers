package com.feue.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author Feue
 * @create 2021-07-28 12:53
 */
@Entity
@Getter
@Setter
@Where(clause = "delete_time is null and online = 1")
public class Category extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private String description;
    private Boolean isRoot;
    private Long parentId;
    private String img;
    private Long index;
    private Boolean online;
    private Long level;

    @ManyToMany
    @JoinTable(name = "coupon_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "coupon_id"))
    private List<Coupon> couponList;
}
