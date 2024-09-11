package com.guaranteeRateService.dto;

import com.guaranteeRateService.model.Address;
import com.guaranteeRateService.model.ProductRequest;
import jakarta.persistence.Embedded;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
        private String applicationId;
        private String phoneNumber;
        private ProductRequest productRequest= new ProductRequest();
        private String email;
        private String firstName;
        private String middleName;
        private String lastName;
        private Address address = new Address();
        private String rentOrOwn;
        private Integer monthlyHousePayment;
        private String employmentStatus;
        private Integer grossAnnualIncome;
        private String industry;
        private String jobTitle;
        private String employerName;
        private String dateOfBirth;
        private String ssnNumber;
        private Boolean softPullConsent;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
