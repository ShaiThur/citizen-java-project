package com.example.citizencrudproject.constant;

import java.time.LocalDate;

public class ValidationConstants {
    public enum PassportData {
        DulSerie,
        DulNumber
    }
    public static final String PHONE_PATTERN = "\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}";
    public static final String DUL_SERIE_PATTERN = "\\d{4}";
    public static final String DUL_NUMBER_PATTERN = "\\d{6}";
    public static final LocalDate MIN_AGE = LocalDate.of(2006, 12, 31);
}
