package com.feue.missyou.dto;

import com.feue.missyou.core.enumeration.LoginType;
import com.feue.missyou.dto.validators.TokenPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Feue
 * @create 2021-07-30 15:35
 */
@Getter
@Setter
public class TokenGetDTO {
    @NotBlank(message = "Account cannot be null")
    private String account;
    @TokenPassword(max = 20, message = "{token.password}")
    private String password;

    private LoginType loginType;
}
