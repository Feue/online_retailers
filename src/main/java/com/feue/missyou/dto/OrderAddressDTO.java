package com.feue.missyou.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Feue
 * @create 2021-08-10 9:38
 */
@Getter
@Setter
public class OrderAddressDTO {
    private String userName;
    private String province;
    private String city;
    private String country;
    private String mobile;
    private String nationalCode;
    private String postalCode;
    private String detail;
}
