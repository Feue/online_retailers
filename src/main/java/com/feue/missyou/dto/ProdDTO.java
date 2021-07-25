package com.feue.missyou.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Feue
 * @create 2021-07-22 14:37
 */
@Getter
@Setter
public class ProdDTO {
    private Long id;
    private String name;
    private Date ctime;
}
