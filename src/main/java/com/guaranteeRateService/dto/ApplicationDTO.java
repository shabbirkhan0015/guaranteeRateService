package com.guaranteeRateService.dto;

import com.guaranteeRateService.model.Address;
import com.guaranteeRateService.model.PersonalDetails;
import com.guaranteeRateService.model.ProductRequest;
import com.guaranteeRateService.model.SecurityDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDTO {
        private String applicationId;
        private String phoneNumber;
        private ProductRequest productRequest= new ProductRequest();
        private Address address = new Address();
        private PersonalDetails personalDetails = new PersonalDetails();
        private SecurityDetailsDTO securityDetails = new SecurityDetailsDTO();
        private Boolean softPullConsent;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
