package com.example.citizencrudproject.validation.validator;

import com.example.citizencrudproject.validation.ValidPattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternValidator implements ConstraintValidator<ValidPattern, String> {
    private String pattern;

    @Override
    public void initialize(ValidPattern constraintAnnotation) {
        pattern = constraintAnnotation.pattern();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern regexPattern =Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(s);

        return matcher.matches();
    }
}
