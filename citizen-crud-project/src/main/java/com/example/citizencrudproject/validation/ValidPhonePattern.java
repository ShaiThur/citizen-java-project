package com.example.citizencrudproject.validation;

import com.example.citizencrudproject.validation.validator.ValidPhonePatternValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = ValidPhonePatternValidator.class)
public @interface ValidPhonePattern {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
