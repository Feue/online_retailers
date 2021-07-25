package com.feue.missyou.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * @author Feue
 * @create 2021-07-19 12:37
 */
@Getter
@Setter
public class SchoolDTO {
    @Length(min = 2, max = 10)
    private String schoolName;
}
