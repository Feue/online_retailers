package com.feue.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Feue
 * @create 2021-07-23 17:11
 */
@Entity
@Table(name = "spu_img", schema = "sleeve", catalog = "")
@Getter
@Setter
public class SpuImg extends BaseEntity {
    @Id
    private Long id;
    private String img;
    private Long spuId;
}
