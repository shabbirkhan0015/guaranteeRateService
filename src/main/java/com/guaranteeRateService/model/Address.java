package com.guaranteeRateService.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {
    private String streetAddress;
    private String appSuiteNumber;
    private String city;
    private String state;
    private String postalCode;
}


