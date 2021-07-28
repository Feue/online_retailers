package com.feue.missyou.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Feue
 * @create 2021-07-28 14:28
 */
@Entity
@Table(name = "grid_category", schema = "sleeve", catalog = "")
@Getter
@Setter
@Where(clause = "delete_time is null")
public class GridCategory extends BaseEntity {
    @Id
    private Long id;
    private String title;
    private String img;
    private String name;
    private Long categoryId;
    private Long rootCategoryId;
}
