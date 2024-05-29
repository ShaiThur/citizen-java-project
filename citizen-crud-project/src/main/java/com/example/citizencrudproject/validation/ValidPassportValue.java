package com.example.citizencrudproject.validation;

import com.example.citizencrudproject.constant.ValidationConstants;
import com.example.citizencrudproject.validation.validator.ValidPassportValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = ValidPassportValidator.class)
public @interface ValidPassportValue {
    ValidationConstants.PassportData passportData() default ValidationConstants.PassportData.DulNumber;
    String message() default "Invalid Passport";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
