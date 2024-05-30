package com.example.citizencrudproject.dto;

import com.example.citizencrudproject.constant.ValidationConstants;
import com.example.citizencrudproject.validation.MinAge;
import com.example.citizencrudproject.validation.ValidPattern;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenDto {
    private Long id;

    @NotEmpty(message = "поле имени не должжно быть пустым")
    @NotNull(message = "поле не должно быть пустым")
    private String firstName;

    private String middleName;

    @NotEmpty(message = "поле фамилии не должжно быть пустым")
    @NotNull(message = "поле не должно быть пустым")
    private String lastName;

    @MinAge(minAge = ValidationConstants.MIN_AGE, message = "возраст должен быть не менее 18 лет")
    private LocalDate birthDate;

    @ValidPattern(pattern = ValidationConstants.PHONE_PATTERN,
            message = "номер указан неправильно (формат:+7(XXX)XXX-XX-XX)")
    private String phone;

    @ValidPattern(pattern = ValidationConstants.PHONE_PATTERN,
            message = "номер указан неправильно (формат:+7(XXX)XXX-XX-XX)")
    private String extraPhone;

    @ValidPattern(pattern = ValidationConstants.DUL_SERIE_PATTERN, message
            = "серия паспорта должна иметь 4 цифры")
    private String dulSerie;

    @ValidPattern(pattern = ValidationConstants.DUL_NUMBER_PATTERN, message
            = "серия паспорта должна иметь 4 цифры")
    private String dulNumber;
}
