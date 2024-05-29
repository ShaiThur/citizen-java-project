package com.example.citizencrudproject.validation;

import com.example.citizencrudproject.validation.validator.MinAgeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = MinAgeValidator.class)
public @interface MinAgeConstraint {
    String message() default "Age must must be more than 18";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
