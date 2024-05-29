package com.example.citizencrudproject.validation.validator;

import com.example.citizencrudproject.constant.ValidationConstants;
import com.example.citizencrudproject.validation.ValidPhonePattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPhonePatternValidator implements ConstraintValidator<ValidPhonePattern, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s != null && !s.isEmpty()) {
            Pattern pattern =Pattern.compile(ValidationConstants.PHONE_PATTERN);
            Matcher matcher = pattern.matcher(s);
            return matcher.matches();
        }
        return true;
    }
}
