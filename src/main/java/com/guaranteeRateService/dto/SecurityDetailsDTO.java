package com.guaranteeRateService.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SecurityDetailsDTO {
    private String dateOfBirth;
    private String ssnNumber;
}
