package com.guaranteeRateService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "application")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Component
public class Application {
    @Id
    private String applicationId;
    private String phoneNumber;
    @Embedded
    private ProductRequest productRequest;
    @Embedded
    private PersonalDetails personalDetails;
    @Embedded
    private Address address;
    @Embedded
    private SecurityDetails securityDetails;
    private Boolean softPullConsent;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
