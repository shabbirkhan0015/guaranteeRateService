package com.guaranteeRateService.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String loanType;
    private Integer requestedAmount;
}
