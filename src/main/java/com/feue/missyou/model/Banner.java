package com.feue.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Feue
 * @create 2021-07-23 10:19
 */
@Entity
@Getter
@Setter
// where delete_time == null
@Where(clause = "delete_time is null")
public class Banner extends BaseEntity{
    @Id
    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}
