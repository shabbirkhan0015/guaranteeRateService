package com.guaranteeRateService.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String rentOrOwn;
    private Integer monthlyHousePayment;
    private String employmentStatus;
    private Integer grossAnnualIncome;
    private String industry;
    private String jobTitle;
    private String employerName;
}
