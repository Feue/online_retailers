package com.feue.missyou.dto.validators;

import com.feue.missyou.dto.PersonDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Feue
 * @create 2021-07-19 13:05
 */
public class PasswordValidator implements ConstraintValidator<PasswordEqual, PersonDTO> {
    private Integer min;

    private Integer max;

    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(PersonDTO personDTO, ConstraintValidatorContext constraintValidatorContext) {
        String password1 = personDTO.getPassword1();
        String password2 = personDTO.getPassword2();
        boolean match = password1.length() >= this.min
                && password1.length() <= this.max
                && password2.length() >= this.min
                && password2.length() <= this.max
                && password1.equals(password2);
        return match;
    }
}
