package com.example.citizencrudproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "citizens", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name", "middle_name", "last_name", "birth_date"})
})
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "extra_phone")
    private String extraPhone;

    @Column(name = "dul_serie")
    private String dulSerie;

    @Column(name = "dul_number")
    private String dulNumber;
}
