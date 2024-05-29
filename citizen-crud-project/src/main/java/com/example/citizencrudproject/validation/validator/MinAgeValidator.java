package com.example.citizencrudproject.validation.validator;

import com.example.citizencrudproject.constant.ValidationConstants;
import com.example.citizencrudproject.validation.MinAgeConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MinAgeValidator implements ConstraintValidator<MinAgeConstraint, LocalDate> {

    @Override
    public boolean isValid(LocalDate calendar, ConstraintValidatorContext constraintValidatorContext) {
        return calendar.getYear() <= ValidationConstants.MIN_AGE.getYear();
    }
}
