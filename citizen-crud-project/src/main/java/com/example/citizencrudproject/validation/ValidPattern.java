package com.example.citizencrudproject.validation;

import com.example.citizencrudproject.validation.validator.PatternValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = PatternValidator.class)
public @interface ValidPattern {
    String pattern() default "";
    String message() default "Invalid pattern";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
