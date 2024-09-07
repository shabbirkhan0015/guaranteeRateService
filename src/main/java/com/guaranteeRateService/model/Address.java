package com.guaranteeRateService.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String streetAddress;
    private String appSuiteNumber;
    private String city;
    private String state;
    private String postalCode;
}
