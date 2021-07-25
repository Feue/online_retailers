package com.feue.missyou.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2021-07-23 17:39
 */
@Getter
@Setter
public class SpuSimplifyVO {
    private Long id;
    private String title;
    private String subtitle;
    private String price;
    private Long sketchSpecId;
    private String img;
    private String discountPrice;
    private String description;
    private String tags;
    private String forThemeImg;
}
