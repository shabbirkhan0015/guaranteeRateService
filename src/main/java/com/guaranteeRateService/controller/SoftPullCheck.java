package com.guaranteeRateService.controller;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.ValidationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/softpull")
@RestController
public class SoftPullCheck {

    public ResponseEntity<ValidationResponse> softPullCheckData(ApplicationDTO applicationData) {
        ValidationResponse validationResponse = new ValidationResponse();
        List<String> declineReasons = new ArrayList<>();

        // Validate age
        String dateOfBirth = applicationData.getDateOfBirth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
        int age = Period.between(dob, LocalDate.now()).getYears();

        if (age < 18) {
            declineReasons.add("You are not meeting the minimum age requirement for this product.");
        }

        // Validate income
        Integer grossAnnualIncome = applicationData.getGrossAnnualIncome(); // Assuming it's an Integer

        if (grossAnnualIncome != null && grossAnnualIncome < 20000) {
            declineReasons.add("Your income is below the required $20,000 minimum.");
        }

        // Check if any decline reasons were found
        if (!declineReasons.isEmpty()) {
            validationResponse.setDeclineReasons(declineReasons);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationResponse);
        }

        // If all validations pass, return OK with no decline reasons
        return ResponseEntity.ok().build();
    }
}
