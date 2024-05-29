package com.example.citizencrudproject.validation.validator;

import com.example.citizencrudproject.constant.ValidationConstants;
import com.example.citizencrudproject.validation.ValidPassportValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassportValidator implements ConstraintValidator<ValidPassportValue, String> {
    private ValidationConstants.PassportData passportData;

    @Override
    public void initialize(ValidPassportValue constraintAnnotation) {
        passportData = constraintAnnotation.passportData();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String validator = passportData == ValidationConstants.PassportData.DulSerie
                ? ValidationConstants.DUL_SERIE_PATTERN : ValidationConstants.DUL_NUMBER_PATTERN;

        Pattern pattern =Pattern.compile(validator);
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }
}
