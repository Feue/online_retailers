package com.feue.missyou.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2021-07-25 13:23
 */
@Getter
@Setter
@Builder
public class PageCounter {
    private Integer page;
    private Integer count;
}
