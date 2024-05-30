package com.example.citizencrudproject.validation.validator;

import com.example.citizencrudproject.validation.MinAge;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MinAgeValidator implements ConstraintValidator<MinAge, LocalDate> {
    private LocalDate minAge;

    @Override
    public void initialize(MinAge constraintAnnotation) {
        minAge = LocalDate.parse(constraintAnnotation.minAge());
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        return date.getYear() <= minAge.getYear() && date.getDayOfYear() < minAge.getDayOfYear();
    }
}
