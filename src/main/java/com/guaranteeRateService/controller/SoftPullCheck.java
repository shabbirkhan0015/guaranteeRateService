package com.guaranteeRateService.controller;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.SoftPullResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/softpull")
@RestController
public class SoftPullCheck {

    @PostMapping
    public ResponseEntity<SoftPullResponse> softPullCheckData(@RequestBody ApplicationDTO applicationData) {
        SoftPullResponse softPullResponse = new SoftPullResponse();
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
        Integer grossAnnualIncome = applicationData.getGrossAnnualIncome();

        if (grossAnnualIncome != null && grossAnnualIncome < 20000) {
            declineReasons.add("Your income is below the required $20,000 minimum.");
        }

        // Check for decline reasons
        if (!declineReasons.isEmpty()) {
            softPullResponse.setDeclineReasons(declineReasons);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(softPullResponse);
        }

        return ResponseEntity.ok(softPullResponse);
    }
}

