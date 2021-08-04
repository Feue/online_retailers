package com.feue.missyou.dto.validators;

import com.feue.missyou.dto.TokenGetDTO;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feue
 * @create 2021-07-30 15:50
 */
public class TokenPasswordValidator implements ConstraintValidator<TokenPassword, String> {
    private Integer min;

    private Integer max;

    @Override
    public void initialize(TokenPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        int len = value.length();
        return len >= this.min && len <= this.max;
    }
}
