package com.guaranteeRateService.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "application")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Application {
    @Id
    private String applicationId;
    private String phoneNumber;
    @Embedded
    private ProductRequest productRequest;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    @Embedded
    private Address address;
    private String rentOrOwn;
    private Integer monthlyHousePayment;
    private String employmentStatus;
    private Integer grossAnnualIncome;
    private String industry;
    private String jobTitle;
    private String employerName;
    private LocalDate dateOfBirth;
    private String ssnNumber;
    private Boolean softPullConsent;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
