package com.example.citizencrudproject.dto;

import com.example.citizencrudproject.constant.ValidationConstants;
import com.example.citizencrudproject.validation.MinAgeConstraint;
import com.example.citizencrudproject.validation.ValidPassportValue;
import com.example.citizencrudproject.validation.ValidPhonePattern;
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

    @MinAgeConstraint(message = "дата со дня рождения должна быть не менее 18 лет и 1 день")
    private LocalDate birthDate;

    @ValidPhonePattern(message = "номер указан неправильно (формат:+7(XXX)XXX-XX-XX)")
    private String phone;

    @ValidPhonePattern(message = "номер указан неправильно (формат:+7(XXX)XXX-XX-XX)")
    private String extraPhone;

    @ValidPassportValue(passportData = ValidationConstants.PassportData.DulSerie, message
            = "серия паспорта должна иметь 4 цифры")
    private String dulSerie;

    @ValidPassportValue(passportData = ValidationConstants.PassportData.DulNumber, message
            = "номер паспорта должен иметь 6 цифр")
    private String dulNumber;
}
